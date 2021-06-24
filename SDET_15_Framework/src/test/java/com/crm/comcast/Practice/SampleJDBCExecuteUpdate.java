package com.crm.comcast.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	@Test
	public void databaseExecuteUpdate() throws Throwable{
		Connection con=null;
		try {
			//Step1:Register to Database
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);

			//Step2:Get Connection with DataBase - provide database name
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet", "root", "root");

			//Step3:Issue Create Statement
			Statement stmt=con.createStatement();

			//Step4:Execute any Query - provide Table Name
			int rs=stmt.executeUpdate("insert into employee values('Chandana',123654785,'Tpt')");
			if(rs==1)
			{
				System.out.println("Query successfull-added one row");
			}
			else
			{
				System.out.println("Query unsuccessfull");
			}
		}
		catch(Exception e)
		{

		}

		//Step5:Close DataBase
		finally
		{
			con.close();
			System.out.println("DataBase Connection Closed Successfully");
		}

	}
}
