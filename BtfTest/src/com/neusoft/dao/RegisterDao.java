package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.entity.UserLogin;
import com.neusoft.Util.DBUtil;
import com.neusoft.Util.PasswordUtil;

public class RegisterDao {
	Connection con=null;
	PreparedStatement pstate=null;

	//辅助service完成 将数据插入数据库操作
	public int register(UserLogin userlogin) {
		int row=0;
		try {
			con=DBUtil.getCon();
			
			pstate= con.prepareStatement("insert into userlogin values(?,?,?,?,?,sysdate) ");
			pstate.setString(1, userlogin.getUserId());
			pstate.setString(2, userlogin.getUserName());
			pstate.setString(3, userlogin.getUserEmail());
			pstate.setString(4, userlogin.getUserAccount());
			pstate.setString(5,PasswordUtil.generate(userlogin.getUserPassword()));
	
//			4.执行sql语句
			//插入张三    员工编号9001 姓名 张三   工资 3000 部门编号40
			row= pstate.executeUpdate();
//			5.处理结果
	     	System.out.println("row:"+row);
			
		     	DBUtil.close(con,pstate);
		

	
	}catch(Exception e) {
		System.out.println(e+"register userlogin时dao 出现问题！");
		}
		
		return row;
	}
	
	//判断用户名是否重复
	public boolean accontVerify(String account){
		 con=DBUtil.getCon();
		 try {
			 pstate= con.prepareStatement("select * from userlogin where user_account=?");
			pstate.setString(1, account);
			ResultSet  rs=pstate.executeQuery();
			if(rs.next()) {
				return true;//存在重复的account
			}else {
				return false; //不存在重复的account 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close(con,pstate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage()+"DBUtil.close(con,pstate)关闭出错");
			}
		}
		
		
		return false;
		
	}
	
	//登陆方法，返回true可以登录    false不可以登录   
	public boolean login(UserLogin userlogin) {		 
		 con=DBUtil.getCon();
		 try {			 
			 pstate= con.prepareStatement("select * from userlogin where user_account=?");
			 pstate.setString(1, userlogin.getUserAccount());
			 ResultSet  rs=pstate.executeQuery();
			if(rs.next()&&PasswordUtil.verify(userlogin.getUserPassword(), rs.getString("user_password"))) {				
				return true;//如果查到可以登录
			}else {
				return false; //如果查不到，不可以登录
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close(con,pstate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage()+"DBUtil.close(con,pstate)关闭出错");
			}
		}
	return false;
}
	
	
}
