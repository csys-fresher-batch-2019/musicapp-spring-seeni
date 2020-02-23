package com.chainsys.accountinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.otherclass.Connection1;
import com.chainsys.otherclass.Logger;

/**
 * 
 * @author seen2380 Displays premium members name
 */
public class AccountTab5Tab1DAOImpl implements AccountTab5Tab1DAO {
	public List<String> accountInfo(String str) {
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
		} catch (Exception e) {
			Logger.getInstanceOf().error(e.getMessage());
		}
		return li;
	}

	private List<String> nestTry(PreparedStatement pst) {
		List<String> li = new ArrayList<>();
		try (ResultSet rs = pst.executeQuery();) {
			li = new ArrayList<String>();
			while (rs.next()) {
				li.add(rs.getString("username"));
			}
		} catch (Exception e) {
			Logger.getInstanceOf().error(e);
		}
		return li;
	}
}
