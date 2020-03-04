package com.chainsys.musicapp.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.musicapp.DAO.AccountTab5Tab1DAO;
import com.chainsys.musicapp.util.Connection1;
import com.chainsys.musicapp.util.DbException;
import com.chainsys.musicapp.util.ErrorConstants;
import com.chainsys.musicapp.util.Logger;

/**
 * 
 * @author seen2380 Displays premium members name
 */


public class AccountTab5Tab1DAOImpl implements AccountTab5Tab1DAO {
	public List<String> accountInfo(String str) throws DbException {
		List<String> li = null;
		int premiumAmount = 400;
		String sql = "select username from userlogin where user_id in (select user_id from account_info where wants_to_premium=? and balance>="
				+ premiumAmount + ")";
		try (Connection con = Connection1.connection(); PreparedStatement pst = con.prepareStatement(sql);) {
			Logger.getInstanceOf().info(sql);
			pst.setString(1, str);
			li = nestTry(pst);
			for (String string : li) {
				Logger.getInstanceOf().info(string);
			}
		} catch(Exception e) {
			throw new DbException(ErrorConstants.connection);
		}
		return li;
	}

	private List<String> nestTry(PreparedStatement pst) throws DbException {
		List<String> li = new ArrayList<>();
		try (ResultSet rs = pst.executeQuery();) {
			li = new ArrayList<String>();
			while (rs.next()) {
				li.add(rs.getString("username"));
			}
		} catch (Exception e) {
			throw new DbException(ErrorConstants.connection);
		}
		return li;
	}
}
