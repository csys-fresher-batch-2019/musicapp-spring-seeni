package com.chainsys.otherclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

/**
 * To connect java with mobile
 * 
 * @author seen2380
 *
 */
public class Msg91 {
	public static int msg(String number) {
		String authkey = "316211AGvuCbSI5e35af47P1";
		String mobiles = number;
		String senderId = "SEENII";
		String country = "91";
		Random rand = new Random();
		int message = rand.nextInt(99999);
		String route = "4";
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;
		String mainUrl = "https://api.msg91.com/api/v2/sendsms?";
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authkey);
		sbPostData.append("&mobiles=" + mobiles);
		sbPostData.append("&message=" + message);
		sbPostData.append("&route=" + route);
		sbPostData.append("&country=" + country);
		sbPostData.append("&sender=" + senderId);
		mainUrl = sbPostData.toString();
		try {
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String response;
			while ((response = reader.readLine()) != null)
				Logger.getInstanceOf().info(response);
			reader.close();

		} catch (IOException e) {
			Logger.getInstanceOf().error(e.getMessage());
		}

		return message;
	}

}
