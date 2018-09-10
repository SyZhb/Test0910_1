package com.neusoft.service;

import com.neusoft.dao.EditDao;
import com.neusoft.entity.UserInfo;


public class EditService {
	public int editinfo(UserInfo UserInfo,String account){
		EditDao  EditDao=new EditDao();
		int qkfl=0;
		boolean b=EditDao.accontVerify(UserInfo);
		if(b==true) {
			return 0; //0没有修改数据
		}else {
		//if true 则说明重复 不调用下面的注册方法  if 是false 说明可以注册 则运行下面的方法
		//在将userloginbean 插入数据库之前 做校验
			int a=EditDao.editinfo(UserInfo,account);
		
			if(a==1) {
				qkfl=1;//
			}else {
				qkfl=0;
			}
			return a;
		}
	
}
}