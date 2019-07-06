/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.tests.util;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

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
 * Http Request for Test
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 */
public final class HttpTest {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final int TIME_OUT = 40_000;

    private static final String ACCEPT_LANGUAGE = "pt-BR";

    private static final String CONTENT_TYPE = "application/json; charset=UTF-8";

    /**
     * Default Empty Constructor
     */
    private HttpTest() {
    }

    /**
     * Send Http GET Method to URL
     * 
     * @param url
     *            Destiny URL
     * @return a Response as String
     */
    public static String sendGet(@NotBlank String url) throws RuntimeException {

	if ((url == null) || (url.isEmpty())) {
	    throw new RuntimeException("Url Cannot be Empty");
	}

	URL obj = null;

	try {

	    obj = new URL(url);

	} catch (MalformedURLException e) {

	    System.err.println("Could not Parse Url");

	    e.printStackTrace();

	    throw new RuntimeException(e.getMessage(), e);

	}

	HttpURLConnection con = null;

	try {

	    con = (HttpURLConnection) obj.openConnection();

	} catch (IOException e) {

	    System.err.println("Could not Open Connection");

	    e.printStackTrace();

	    throw new RuntimeException(e.getMessage(), e);
	}

	// add request header
	try {

	    con.setRequestMethod("GET");

	} catch (ProtocolException e) {

	    System.err.println("Could not Set Protocol of Request");

	    e.printStackTrace();

	    throw new RuntimeException(e.getMessage(), e);
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

	    throw new RuntimeException(e.getMessage(), e);
	}

	System.out.println("Send Request " + con.getRequestMethod() + " to URL : " + url);

	System.out.println("Response Code : " + responseCode);

	String resp;

	if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {

	    BufferedReader in = null;

	    try {

		in = new BufferedReader(new InputStreamReader(con.getInputStream()));

	    } catch (IOException e) {

		System.err.println("Could not Receive Data");

		e.printStackTrace();

		throw new RuntimeException(e.getMessage(), e);
	    }

	    StringBuilder response = new StringBuilder();

	    String inputLine;

	    try {

		while ((inputLine = in.readLine()) != null) {
		    response.append(inputLine);
		}

	    } catch (IOException e) {

		System.err.println("Could not Read Received Data");

		e.printStackTrace();

		throw new RuntimeException(e.getMessage(), e);
	    }

	    System.out.println("Response of Server ");

	    System.out.println(response.toString());

	    resp = response.toString();

	} else {

	    System.err.println("Server Response Code : " + responseCode);

	    resp = null;
	}

	return resp;
    }

    // HTTP POST request
    public static String sendPost(@NotBlank String url, @NotEmpty String params) throws RuntimeException {

	if ((url == null) || (url.isEmpty())) {
	    throw new RuntimeException("Url Cannot be Empty");
	}

	params = new String(params.getBytes(), StandardCharsets.ISO_8859_1);

	URL obj = null;

	try {

	    obj = new URL(url);

	} catch (MalformedURLException e) {

	    System.err.println("Could not Parse Url");

	    e.printStackTrace();

	    throw new RuntimeException("Could not Parse Url");
	}

	HttpURLConnection con = null;

	try {

	    con = (HttpURLConnection) obj.openConnection();

	} catch (IOException e) {

	    // TODO Auto-generated catch block

	    System.err.println("Verify your connection");

	    e.printStackTrace();

	    throw new RuntimeException("Verify your connection");
	}

	// add request header
	try {

	    con.setRequestMethod("POST");

	} catch (ProtocolException e) {

	    System.err.println("Could not Set Protocol of Request");

	    e.printStackTrace();

	    throw new RuntimeException(e.getMessage(), e);
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

	    throw new RuntimeException(e.getMessage(), e);
	}

	try {

	    wr.writeBytes(params);

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();

	    throw new RuntimeException(e.getMessage(), e);
	}

	try {

	    wr.flush();

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();

	    throw new RuntimeException(e.getMessage(), e);
	}

	int responseCode = 0;

	try {

	    responseCode = con.getResponseCode();

	} catch (IOException e) {

	    System.err.println("Could not Get Response Code");

	    e.printStackTrace();

	    throw new RuntimeException(e.getMessage(), e);
	}

	System.out.println("Send Request " + con.getRequestMethod() + " to URL : " + url);

	System.out.println("Response Code : " + responseCode);

	System.out.println("Parameters of Post : \n" + params);

	String resp;

	if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {

	    System.out.println("Server Response Code : " + responseCode);

	    BufferedReader in = null;

	    try {

		in = new BufferedReader(new InputStreamReader(con.getInputStream()));

	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		throw new RuntimeException(e.getMessage(), e);
	    }

	    StringBuilder response = new StringBuilder();

	    String inputLine;

	    try {
		while ((inputLine = in.readLine()) != null) {

		    response.append(inputLine);

		}
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		throw new RuntimeException(e.getMessage(), e);
	    }

	    System.out.println("Response of Server");

	    System.out.println(response.toString());

	    resp = response.toString();

	} else {

	    System.err.println("Server Response Code : " + responseCode);

	    resp = null;
	}

	return resp;

    }

}
