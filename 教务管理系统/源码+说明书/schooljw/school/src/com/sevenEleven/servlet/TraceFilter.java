package com.sevenEleven.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Filter implementation class for Filter: TraceFilter
 * 
 */
public class TraceFilter implements Filter {
	private ServletContext context;

	/**
	 * 初使化方法
	 * 
	 * @param config
	 * @exception ServletException
	 */
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		context = config.getServletContext();
	}

	/**
	 * Filter 主方法
	 * 
	 * @param request
	 * @param response
	 * @param chain
	 * @exception ServletException,IOException
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		((HttpServletRequest) request).setCharacterEncoding("gb2312");
		chain.doFilter(request, response);
	}

	/**
	 * destroy方法
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

}