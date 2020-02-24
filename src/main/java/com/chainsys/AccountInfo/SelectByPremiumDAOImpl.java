package com.chainsys.accountinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.otherclass.Connection1;

/**
 * 
 * @author seen2380 Displays premium members email-id
 */
public class SelectByPremiumDAOImpl {
	public List<String> premiumMembers(String str) throws SQLException, ClassNotFoundException {
		String sql = "select email_id from userlogin where user_id in (select user_id from account_info where premium=?)";
		//List<String> li = null;
		try (Connection con = Connection1.connection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, str);
			try (ResultSet rs = pst.executeQuery();) {
				List<String> li = new ArrayList<>();
				while (rs.next()) {
					li.add(rs.getString("email_id"));
					
				}
				System.out.println("ArrayList is "+li);
				return li;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		

	}
}
