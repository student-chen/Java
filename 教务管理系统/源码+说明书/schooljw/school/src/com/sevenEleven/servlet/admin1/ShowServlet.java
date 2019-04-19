package com.sevenEleven.servlet.admin1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CConnectMSSQL;

/**
 * Servlet implementation class for Servlet: ShowServlet
 *
 */
 public class ShowServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ShowServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//提取管理员信息，
		String action = request.getParameter("action");
		if (("show_admin_teach".equalsIgnoreCase(action)))
		{ 
		CConnectMSSQL db = new CConnectMSSQL();
		List list = db.getNestedListFromResultSet("select a_id,a_type,a_name,a_password from administrator where a_type=2");
		request.setAttribute("mylist", list);
		//System.out.print(list);	
		request.getRequestDispatcher("show_admin.jsp").forward(request,
				response);		
		 
		}  
		else if(("show_admin_book".equalsIgnoreCase(action)))
		{ 
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet("select a_id,a_type,a_name,a_password from administrator where a_type=3");
			request.setAttribute("mylist", list);
			//System.out.print(list);
			request.getRequestDispatcher("show_admin.jsp").forward(request,
					response);		
			
			}  
		else if(("show_admin_bbs".equalsIgnoreCase(action)))
		{ 
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet("select a_id,a_type,a_name,a_password from administrator where a_type=4");
			request.setAttribute("mylist", list);
			//System.out.print(list);
			request.getRequestDispatcher("show_admin.jsp").forward(request,
					response);		
			
	   } 
	}
}   	  	    
