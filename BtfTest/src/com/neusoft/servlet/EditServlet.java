package com.neusoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.UserInfo;
import com.neusoft.service.EditService;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		String userGender=request.getParameter("sex");
		//获取居住地址
		String a=request.getParameter("province");
		String b=request.getParameter("city");
		//写入
		String userAdress=request.getParameter(a+b);
		String userIndustry=request.getParameter("job");
		String userEmail=request.getParameter("email");
		String userEducation=request.getParameter("education");
		String userBirthday=request.getParameter("birthday");
		String userPhone=request.getParameter("phone");
		String userContent=request.getParameter("introduce");
		
		UserInfo UserUserInfobean=new UserInfo();
		UserUserInfobean.setUserGender(userGender);	
		UserUserInfobean.setUserAdress(userAdress);	
		UserUserInfobean.setUserIndustry(userIndustry);
		UserUserInfobean.setUserEmail(userEmail);
		UserUserInfobean.setUserEducation(userEducation);
		UserUserInfobean.setUserBirthday(userBirthday);
		UserUserInfobean.setUserPhone(userPhone);
		UserUserInfobean.setUserContent(userContent);	
		//通过cookie获取useraccount
		Cookie[] cookieArry= request.getCookies();
		String account=null;
		if(cookieArry!=null) {//判断当前是否存在cookie 如果存在 则进行判断，如果不存在 则跳过cookie判断
			for(Cookie c:cookieArry) {
				if("account".equals(c.getName())) {
					account=c.getValue();  //拿到cookie的 name叫做cookieusername  的value值
				}
			}
		
		EditService editService=new EditService();
		int qkfl=editService.editinfo(UserUserInfobean,account);
		
		if(qkfl==1) { //修改成功
			System.out.println("修改成功!!");
			response.sendRedirect("jsp/personal.jsp");
		}else if(qkfl==0) { //修改失败
			System.out.println("修改失败,因为并没有修改数据");
			response.getWriter().print("<script> alert(\"没有修改数据!\"); </script>");
			response.sendRedirect("jsp/personaledit.jsp");
		}
	}else{
		System.out.println("获取cookie中的account失败");
		response.sendRedirect("jsp/personaledit.jsp");
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
