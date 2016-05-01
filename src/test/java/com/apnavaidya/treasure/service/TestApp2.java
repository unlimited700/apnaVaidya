package com.apnavaidya.treasure.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;
import org.json.JSONTokener;

public class TestApp2 {

	public static void main(String[] args) {
		HttpURLConnection urlConnection = null;
		URL url = null;
		JSONObject object = null;
		InputStream inStream = null;
		DataOutputStream printout = null;
		try {
			url = new URL("http://52.35.152.91:8080/v1/signup");
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			// urlConnection.setDoOutput(true);
			// urlConnection.setDoInput(true);
			urlConnection.setRequestProperty("Content-Type", "application/json");
			urlConnection.connect();
			JSONObject jsonParam = new JSONObject();
			jsonParam.put("password", "25");
			jsonParam.put("name", "Real");
			jsonParam.put("sex", "male");
			jsonParam.put("phone", "122");
			jsonParam.put("email", "sss");
			jsonParam.put("age", new Integer(25));
			System.out.println(jsonParam.toString());
			// printout = new DataOutputStream(urlConnection.getOutputStream());
			// printout.write(Integer.parseInt(URLEncoder.encode(jsonParam.toString(),
			// "UTF-8")));
			// printout.flush();
			// printout.close();
			inStream = urlConnection.getInputStream();

			BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));
			String temp, response = "";
			while ((temp = bReader.readLine()) != null) {
				response += temp;
			}

			while ((temp = bReader.readLine()) != null) {
				response += temp;
			}
			object = (JSONObject) new JSONTokener(response).nextValue();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
