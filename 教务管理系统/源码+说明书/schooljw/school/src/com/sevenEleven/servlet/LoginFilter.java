package com.sevenEleven.servlet;

// ==================== Program Discription =====================
	// �������ƣ�ʾ��14-8 : LoginFilter.java
	// ����Ŀ�ģ�ѧϰʹ�õ�¼������
	// ==============================================================
	import javax.servlet.FilterChain;
	import javax.servlet.ServletRequest;
	import javax.servlet.ServletResponse;
	import java.io.IOException;
	import javax.servlet.Filter;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.ServletException;
	import javax.servlet.FilterConfig;

	public class LoginFilter implements Filter
	{
		static String LOGIN_PAGE="index.jsp";
		static String ERR_Page="../error500.jsp";
		protected FilterConfig filterConfig;
 
		public void doFilter(final ServletRequest req,final ServletResponse 
res,FilterChain chain)throws IOException,ServletException
		{
		 HttpServletRequest hreq = (HttpServletRequest)req;
//	         HttpServletResponse hres = (HttpServletResponse)res;	
	         String isLog=(String)hreq.getSession().getAttribute("isLog");	 
 if((isLog!=null)&&((isLog.equals("true"))||(isLog=="true")))//����Ƿ��¼
			 {
			 	chain.doFilter(req,res);
			 	return ;
			 }
			 else{
				 hreq.getRequestDispatcher(ERR_Page).forward(req, res);
				 //hres.sendRedirect(ERR_Page);//���û�е�¼������ͼ�ɷ�������ҳ��
			 }
			 	
		}
		
		public void destroy()
		{
			this.filterConfig=null;
		}
		public void init(FilterConfig config)
		{
			this.filterConfig=config;
		}
		public void setFilterConfig(final FilterConfig filterConfig)
		{
			this.filterConfig=filterConfig;
		}	
	}