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

/**
 * Always Force requests to UTF-8 Charset 
 * @author felipe
 *
 */
@WebFilter(filterName = "CharacterEncodingFilter",urlPatterns = {"/services/*"},asyncSupported=true)
public class CharacterEncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException{}
	
	@Override
	public void destroy(){}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {		

		request.setCharacterEncoding("UTF-8");	

		response.setCharacterEncoding("UTF-8");

		filterChain.doFilter(request, response);		


	}


}
