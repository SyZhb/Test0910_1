package com.neusoft.entity;

import java.io.Serializable;
import java.util.Date;

public class UserLogin implements Serializable{

   private	String userId ;
   private  String userName;       
   private  String  userEmail; 
   private   String  userAccount ;
   private  String  userPassword;
   private  Date    userCreateTime;
   
   
		
		public String getUserId() {
				return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public  String getUserAccount() {
			return userAccount;
		}
		public void setUserAccount(String userAccount) {
			this.userAccount = userAccount;
		}
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		public Date getUserCreateTime() {
			return userCreateTime;
		}
		public void setUserCreateTime(Date userCreateTime) {
			this.userCreateTime = userCreateTime;
		}


	  
   
}
