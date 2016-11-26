/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Read External File 
 * @author felipe
 * @since 1.0
 * @version 1.0
 */
public final class ReadFile {	

	public static String readFileFromURL(URL url){

		System.out.println("Received Url :" + url);		

		StringBuffer sb = null;

		try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),
				StandardCharsets.UTF_8))) {

			String inputLine;

			sb = new StringBuffer();			

			while ((inputLine = in.readLine()) != null){

				sb.append(inputLine) ;				

			}

		} catch (IOException e) {

			System.err.println("Error on Open stream " + e);
		}	


		return sb.toString();

	}
}