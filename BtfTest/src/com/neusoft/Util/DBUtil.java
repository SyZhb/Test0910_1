package com.neusoft.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {	

	static {
		try{
		 Class.forName("oracle.jdbc.driver.OracleDriver"); 
		  String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
		  String username="scott";
		  String password="tiger";
		  con=DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			System.out.println(e+"oracle数据库连接失败");
		}
		
	}
	
      private	static Connection con;
	  public static Connection getCon() {
		return con;
	  }
	  public static void closeQuery(ResultSet rs,Connection con,Statement state) throws Exception{  
		  if(rs!=null){
			  rs.close();
		  }
		  if(state!=null){
			  state.close();
		  }
		  if(con!=null){
			  state.close();
		  }
	  }
	  public static void close(Connection con,Statement state) throws Exception{
		   
		  if(state!=null){
			  state.close();
		  }
		  if(con!=null){
			  state.close();
		  } 
	  }
	  public static void closezz(Connection con,Statement state,Statement state1) throws Exception{
		  if(state1!=null){
			  state1.close();
		  }
		  if(state!=null){
			  state.close();
		  }
		  if(con!=null){
			  state.close();
		  } 
	  }
	
	
}
