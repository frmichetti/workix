/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
/**
 * HTTP Request for Firebase
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
@Deprecated
public class Http {	

	private final String USER_AGENT = "Mozilla/5.0";

	private final Integer TIME_OUT = 35_000;	
	
	private final String WEB_API_KEY = "AIzaSyDF7Uc_yoj_VAOx-7fzag92DLTfyca88aE";

	public Http() {
		System.out.println("[Creating Instance of " + this.getClass().getSimpleName() + "]");
	}

	public String sendPost(String url, String urlParameters) {

		urlParameters = new String(urlParameters.getBytes(),StandardCharsets.ISO_8859_1);

		URL obj = null;

		try {

			obj = new URL(url);

		} catch (MalformedURLException e) {			

			e.printStackTrace();
		}

		HttpURLConnection con = null;

		try {

			con = (HttpURLConnection) obj.openConnection();

		} catch (IOException e) {

			e.printStackTrace();
		}		

		con.setReadTimeout(TIME_OUT);

		try {

			con.setRequestMethod("POST");

		} catch (ProtocolException e) {

			e.printStackTrace();
		}

		con.setRequestProperty("User-Agent", USER_AGENT);

		con.setRequestProperty("Accept-Language", "pt-BR");

		con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

		con.setRequestProperty("Authorization", "key="+ WEB_API_KEY);        

		con.setDoOutput(true);

		DataOutputStream wr;

		try {

			wr = new DataOutputStream(con.getOutputStream());

			wr.writeBytes(urlParameters);

			wr.flush();



		} catch (IOException e) {

			e.printStackTrace();
		}	

		int responseCode = 0;

		try {

			responseCode = con.getResponseCode();

		} catch (IOException e) {			

			e.printStackTrace();
		}		

		System.out.println("--------------------------------------------------------");

		System.out.println("Response " + "Sending Request "+ con.getRequestMethod() +" for URL : " + url);

		System.out.println("Response " + "Parameters of Post : " + urlParameters);

		System.out.println("Response " + "Response Code : " + responseCode);

		System.out.println("--------------------------------------------------------");

		StringBuffer response;

		BufferedReader in = null;

		try {

			in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		} catch (IOException e) {

			e.printStackTrace();
		}

		String inputLine;

		response = new StringBuffer();

		try {

			while ((inputLine = in.readLine()) != null) {

				response.append(inputLine);

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("--------------------------------------------------------");

		System.out.println("Response " + "Response of Server");

		System.out.println("Response " + response.toString());

		System.out.println("--------------------------------------------------------");

		return response.toString();

	}

}
