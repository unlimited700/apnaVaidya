package com.apnavaidya.treasure.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.mysql.fabric.xmlrpc.base.Array;

public class TestApp {

	public static void main(String[] args) {
		HttpURLConnection urlConnection = null;
		URL url = null;
		JSONObject object = null;
		InputStream inStream = null;
		DataOutputStream printout = null;
		try {
			url = new URL("http://52.34.124.11:8080/v1/problems");
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			// urlConnection.setDoOutput(true);
			// urlConnection.setDoInput(true);
			urlConnection.setRequestProperty("Content-Type", "application/json");
			urlConnection.connect();
			String arraystring[] = { "throat" };
			JSONArray jsonArray = new JSONArray();
			jsonArray.put(0, "throat");
			JSONObject jsonParam = new JSONObject();
			jsonParam.put("problems", jsonArray);
			/*
			 * jsonParam.put("description", "Real"); jsonParam.put("enable",
			 * "true");
			 */ // printout = new
				// DataOutputStream(urlConnection.getOutputStream());
			// printout.write(Integer.parseInt(URLEncoder.encode(jsonParam.toString(),
			// "UTF-8").toString()));
			/*
			 * printout.write(jsonParam.toString().getBytes("UTF-8"));
			 * printout.flush(); printout.close();
			 */
			inStream = urlConnection.getInputStream();
			BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));
			String temp, response = "";
			while ((temp = bReader.readLine()) != null) {
				response += temp;
			}
			object = (JSONObject) new JSONTokener(response).nextValue();
			JSONArray jsonArray2 = object.getJSONArray("problems");
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < jsonArray2.length(); i++) {
				list.add((String) jsonArray2.get(i));
			}
			System.out.println(object);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
