package fr.diginamic.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GetRequest {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		GetRequest http = new GetRequest();

		System.out.println("Testing 1 - Send Http GET request");

		http.sendGet();

	}

	// HTTP GET request

	private void sendGet() throws Exception {

		String url = "https://pokeapi.co/api/v2/pokemon/1/";

		URL obj = new URL(url);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET

		con.setRequestMethod("GET");

		// add request header

		con.setRequestProperty("User-Agent", USER_AGENT);

		con.setRequestProperty("Content-Type", "application/json");

		int responseCode = con.getResponseCode();

		System.out.println("\nSending 'GET' request to URL : " + url);

		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String inputLine;

		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {

			response.append(inputLine);

		}

		in.close();

		JsonObject jsonObj = new JsonParser().parse(response.toString()).getAsJsonObject();
		JsonObject jsonObj2 = new Gson().fromJson(response.toString(), JsonObject.class);

		String pokeName = jsonObj2.get("name").getAsString();

		System.out.println("Nom du pokÃ©mon : " + pokeName);

		// print result

		System.out.println(response.toString());

	}

}
