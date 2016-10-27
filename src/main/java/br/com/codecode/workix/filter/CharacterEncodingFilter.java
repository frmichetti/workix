/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "CharacterEncodingFilter",urlPatterns = {"/services/*"},asyncSupported=true)
public class CharacterEncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("[CharacterEncodingFilter]");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {		

	/*	System.out.println("Request OLD Char Encoding " + request.getCharacterEncoding());
		
		System.out.println("Response OLD Char Encoding " + response.getCharacterEncoding());*/

		request.setCharacterEncoding("UTF-8");	
		
		response.setCharacterEncoding("UTF-8");

		filterChain.doFilter(request, response);		

/*		System.out.println("[Executing doFilter]");

		System.out.println("Request from Address -> " + request.getRemoteAddr());

		System.out.println("Request from FullName -> " + request.getRemoteHost());

		System.out.println("Request Prefered Local -> " + request.getLocale());

		System.out.println("Request Content Type " + request.getContentType());

		System.out.println("Request Char Encoding " + request.getCharacterEncoding());
		
		System.out.println("Response Char Encoding " + response.getCharacterEncoding());

		System.out.println("[-------------------------]");*/

	}

	@Override
	public void destroy() {}

}
