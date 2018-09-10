package com.neusoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.UserLogin;
import com.neusoft.service.RegisterService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String name=null;	
		String servercode=null;
		//验证用户名密码是否正确
		Cookie[] cookieArry= request.getCookies();
		String cookieusername=null;
		String cookiepassword=null;
		
		
		if(cookieArry!=null) {//判断当前是否存在cookie 如果存在 则进行判断，如果不存在 则跳过cookie判断
			for(Cookie c:cookieArry) {
				if(c.getName() .equals("cookieusername")||c.getName().equals("cookiepassword")){
				

						if("cookieusername".equals(c.getName())) {
							cookieusername=c.getValue();  //拿到cookie的 name叫做cookieusername  的value值
						}
						if("cookiepassword".equals(c.getName())) {
							cookiepassword=c.getValue();//拿到cookie的 name叫做cookiepassword  的value值
						}
				}else{
					// servercode=(String) request.getSession().getAttribute("code");
				}
			}
			
			if(cookieusername!=null&&cookiepassword!=null) {
				System.out.println("cookie赋值给了 username:"+cookieusername+";password:"+cookiepassword);
				
			}
			//向javabean中塞入数据
			UserLogin userloginbean=new UserLogin();
			userloginbean.setUserAccount(request.getParameter("username"));
			userloginbean.setUserPassword(request.getParameter("password"));
			
			
			RegisterService	registerService= new RegisterService();
			boolean a=registerService.login(userloginbean);
			System.out.println(a);
			if(a==true) {//登陆成功
				System.out.println("登陆成功cookie！");	
				request.getRequestDispatcher("jsp/personal.jsp").forward(request, response);	
			}else {//登录失败
				System.out.println("登陆失败cookie！");
				response.sendRedirect("jsp/login.jsp");
			}
	
		}else {
		
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				//验证验证码
				String code=(String) request.getParameter("code");
				servercode=(String) request.getSession().getAttribute("code");
				
				//向JavaBean中注入数值
				UserLogin userloginbean=new UserLogin();				
				userloginbean.setUserAccount(username);
				userloginbean.setUserPassword(password);

				//control----->service
				//new service 其实就是注册服务的过程
				RegisterService	registerService= new RegisterService();
				//注册好了之后，在当前的servlet当中调用 service服务
				boolean a=registerService.login(userloginbean);								 
				if(a==true) {//登陆成功
					System.out.println("登陆成功nocookie！");					
					//创建c1
					
					if(userloginbean.getUserAccount()!=null&&userloginbean.getUserPassword()!=null){
					Cookie c1=new Cookie("cookieusername",userloginbean.getUserAccount());
					//生命周期60s			
					Cookie c2=new Cookie("cookiepassword",userloginbean.getUserPassword());
					//生命周期60s
					c1.setMaxAge(3*24*60*60);	
					c2.setMaxAge(3*24*60*60);
					response.addCookie(c1);
					response.addCookie(c2);
					}
					System.out.println(code);
					System.out.println(servercode);
					if(code!=null&&servercode.equals(code)){
						System.out.println("验证码正确");
						response.sendRedirect("jsp/personal.jsp");
//						request.getRequestDispatcher("jsp/Personal.jsp").forward(request, response);				
						}else{
							System.out.println("验证码不正确");
							response.sendRedirect("jsp/login.jsp");
						}
					
				}else {//登录失败
					System.out.println("登陆失败nocookie！");
					response.sendRedirect("jsp/login.jsp");
					
				}
		}
		
		//当正确的时候，查询当前用户的昵称user_name
		//将name值展示到personal.jsp中
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
