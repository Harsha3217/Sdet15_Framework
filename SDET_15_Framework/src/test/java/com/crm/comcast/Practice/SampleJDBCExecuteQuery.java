package com.crm.comcast.Practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
@Test
	public void executeQueryJDBC() throws Throwable
	{
		//Step 1: Register to Data Base
	     Driver driverRef=new Driver();
	     DriverManager.registerDriver(driverRef);
	     
	     //Step 2:Get Connection with database-Provide database name
	     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet", "root", "root");
	   
	     //Step3:Issue Create Statement
			Statement stmt=conn.createStatement();

		//Step4:Execute any Query - provide Table Name
			ResultSet rs=stmt.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			}

			//Step5:Close DataBase
			conn.close();
	
	}
}
