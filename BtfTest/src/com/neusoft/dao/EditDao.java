package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.Cookie;

import com.neusoft.entity.UserInfo;
import com.neusoft.Util.DBUtil;

public class EditDao {
	Connection con=null;
	PreparedStatement pstate=null;
	public int editinfo(UserInfo UserInfo,String account) {
		int row=0;	
		try {
			con=DBUtil.getCon();
			PreparedStatement pst= con.prepareStatement("update user_account set  "
					+ "user_gender=?,user_adress=?,user_industry=?,user_email=?"
					+ "user_Education=?,user_Birthday=?,user_Phone=?,user_Content=?"
					+ " where user_account=?" );
			pst.setString(1, UserInfo.getUserGender()); 
			pst.setString(2, UserInfo.getUserAdress()); 
			pst.setString(3, UserInfo.getUserIndustry()); 
			pst.setString(4, UserInfo.getUserEmail()); 
			pst.setString(5, UserInfo.getUserEducation()); 
			pst.setString(6, UserInfo.getUserBirthday()); 
			pst.setString(7, UserInfo.getUserPhone()); 
			pst.setString(8, UserInfo.getUserContent()); 		
			pst.setString(9, account); 
			pst.executeUpdate();
			 System.out.println("修改成功");
			 return 1;
		} catch (Exception e) {			
			System.out.println("连接出错！"+e);
		}finally{
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("关闭出错！"+e);
			}
		}
		
		
		
		return row;

	}
	public boolean accontVerify(UserInfo UserInfo) {
		con=DBUtil.getCon();
		 try {
			 PreparedStatement pst= con.prepareStatement("select count(1) from user_account where  "
					+ "user_gender=? and user_adress=? and user_industry=? and user_email=?"
					+ "and user_Education=? and user_Birthday=? and user_Phone=? and user_Content=?"
					);
			 pst.setString(1, UserInfo.getUserGender()); 
			 pst.setString(2, UserInfo.getUserAdress()); 
			 pst.setString(3, UserInfo.getUserIndustry()); 
			 pst.setString(4, UserInfo.getUserEmail()); 
			 pst.setString(5, UserInfo.getUserEducation()); 
			 pst.setString(6, UserInfo.getUserBirthday()); 
			 pst.setString(7, UserInfo.getUserPhone()); 
			 pst.setString(8, UserInfo.getUserContent()); 			 
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
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage()+"关闭出错");
			}
		}
		
		
		return false;
	}
}
