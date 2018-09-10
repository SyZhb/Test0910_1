package com.neusoft.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.UserLogin;
import com.neusoft.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		
		
		UserLogin userloginbean=new UserLogin();
		userloginbean.setUserId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
		userloginbean.setUserAccount(username);				
		userloginbean.setUserPassword(password);
		userloginbean.setUserName(name);
		userloginbean.setUserCreateTime(new Date());
		
		//control----->service
		//new service 其实就是注册服务的过程
		RegisterService	registerService= new RegisterService();
		//注册好了之后，在当前的servlet当中调用 service服务
		int qkfl=registerService.register(userloginbean);
	
		if(qkfl==1) { //注册成功
			response.sendRedirect("jsp/login.jsp");
		}else if(qkfl==2){//程序出错
			System.out.println("qkfl="+qkfl);
			response.sendRedirect("html/error.html");
		}else if(qkfl==0) { //用户出错
			//用户密码出现问题
			System.out.println("qkfl="+qkfl);
			 response.getWriter().print(
					"<script >alert('用户名重复');"
					+ "history.go(-1);"
					+ "</script>");	
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
