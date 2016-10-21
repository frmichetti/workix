/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.openjobs.tests.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public final class Http {

	private static final String USER_AGENT = "Mozilla/5.0";

	private static final Integer TIME_OUT = 40_000;

	private static final String ACCEPT_LANGUAGE = "pt-BR";

	private static final String CONTENT_TYPE = "application/json; charset=UTF-8";

	public static String sendGet(String url) {

		URL obj = null;

		try {

			obj = new URL(url);

		} catch (MalformedURLException e) {

			System.err.println("Could not Parse Url");

			e.printStackTrace();
		}

		HttpURLConnection con = null;

		try {

			con = (HttpURLConnection) obj.openConnection();

		} catch (IOException ioe) {

			System.err.println("Could not Open Connection");

			ioe.printStackTrace();
		}

		//add request header
		try {

			con.setRequestMethod("GET");

		} catch (ProtocolException e) {

			System.err.println("Could not Set Protocol of Request");

			e.printStackTrace();
		}

		con.setReadTimeout(TIME_OUT);

		con.setRequestProperty("Accept-Language", ACCEPT_LANGUAGE);

		con.setRequestProperty("Content-Type", CONTENT_TYPE);

		con.setRequestProperty("User-Agent", USER_AGENT);		

		int responseCode = 0;

		try {

			responseCode = con.getResponseCode();

		} catch (IOException e) {

			System.err.println("Could not Get Response Code");

			e.printStackTrace();
		}

		System.out.println("Send Request "+ con.getRequestMethod() +" to URL : " + url);

		System.out.println("Response Code : " + responseCode);

		String resp;

		if(responseCode == 200 || responseCode == 201){


			BufferedReader in = null;

			try {

				in = new BufferedReader(
						new InputStreamReader(con.getInputStream()));

			} catch (IOException e) {

				System.err.println("Could not Receive Data");

				e.printStackTrace();
			}

			StringBuffer response = new StringBuffer();

			String inputLine;

			try {

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

			} catch (IOException e) {

				System.err.println("Could not Read Received Data");

				e.printStackTrace();
			}

			System.out.println("Response of Server ");

			System.out.println(response.toString());

			resp = response.toString();

		}else{

			System.err.println("Server Response Code : " + responseCode);

			resp = null;
		}

		return resp;
	}

	// HTTP POST request
	public static String sendPost(String url, String params) {
		
		params = new String(params.getBytes(), StandardCharsets.ISO_8859_1);

		URL obj = null;

		try {

			obj = new URL(url);

		} catch (MalformedURLException e) {

			System.err.println("Could not Parse Url");

			e.printStackTrace();
		}

		HttpURLConnection con = null;

		try {

			con = (HttpURLConnection) obj.openConnection();

		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}

		//add request header
		try {

			con.setRequestMethod("POST");

		} catch (ProtocolException e) {
		
			System.err.println("Could not Set Protocol of Request");
			
			e.printStackTrace();
		}

		con.setRequestProperty("User-Agent", USER_AGENT);

		con.setRequestProperty("Accept-Language", ACCEPT_LANGUAGE);

		con.setRequestProperty("Content-Type", CONTENT_TYPE);

		// Send post request
		con.setDoOutput(true);

		DataOutputStream wr = null;
		
		try {

			wr = new DataOutputStream(con.getOutputStream());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			wr.writeBytes(params);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			wr.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		int responseCode = 0;

		try {
			
			responseCode = con.getResponseCode();
			
		} catch (IOException e) {
			
			System.err.println("Could not Get Response Code");
			
			e.printStackTrace();
		}

		System.out.println("Send Request "+ con.getRequestMethod() +" to URL : " + url);

		System.out.println("Response Code : " + responseCode);

		System.out.println("Parameters of Post : \n" + params);		

		String resp;

		if(responseCode == 200 || responseCode == 201){

			System.out.println("Server Response Code : " + responseCode);

			BufferedReader in = null;

			try {

				in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			StringBuffer response = new StringBuffer();

			String inputLine;

			try {
				while ((inputLine = in.readLine()) != null) {

					response.append(inputLine);

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Response of Server");

			System.out.println(response.toString());

			resp = response.toString();

		}else{

			System.err.println("Server Response Code : " + responseCode);			

			resp = null;
		}

		return resp;

	}

}
