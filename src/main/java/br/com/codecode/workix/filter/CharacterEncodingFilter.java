/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see http://www.codecode.com.br
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.workix.filter;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Always Force requests of JaxRs to Configured Charset 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see Filter
 */
@WebFilter(filterName = "CharacterEncodingFilter", urlPatterns = {"/services/*"}, asyncSupported=true)
public final class CharacterEncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException{}
	
	@Override
	public void destroy(){}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {		

		request.setCharacterEncoding(UTF_8.displayName());	

		response.setCharacterEncoding(UTF_8.displayName());

		filterChain.doFilter(request, response);		


	}


}
