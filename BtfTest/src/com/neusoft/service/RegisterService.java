package com.neusoft.service;

import com.neusoft.dao.RegisterDao;
import com.neusoft.entity.UserLogin;

public class RegisterService {
	public int register(UserLogin userlogin) {
		//验证用户名是否重复  如果重复提示 用户名重复 并返回注册界面
		//如果用户名不重复   跳转到login界面
		
		
		int qkfl=0; //qkfl  1插入一条数据     2插入多条数据     0没有插入数据
		//插入到数据库当中 ，即将操作数据库 DAO
		//dao实例化的过程就是 dao注册到service里的过程
		RegisterDao registerDao	=new RegisterDao();
		
		//调用dao的accontVerify方法判断是否重复
		boolean b=registerDao.accontVerify(userlogin.getUserAccount());
		if(b==true) {
			return 0; //0没有插入数据 重复！
		}else {
		//if true 则说明重复 不调用下面的注册方法  if 是false 说明可以注册 则运行下面的方法
		//在将userloginbean 插入数据库之前 做校验
			int a=registerDao.register(userlogin);
			
			if(a==1) {
				qkfl=1;//
			}else if(a>1){
				qkfl=2;
			}else {
				qkfl=0;
			}
			return a;
		}
	
	}
	
	
	public boolean login(UserLogin userlogin) {
		RegisterDao registerDao	=new RegisterDao();
		return registerDao.login(userlogin);
	}
	
}
