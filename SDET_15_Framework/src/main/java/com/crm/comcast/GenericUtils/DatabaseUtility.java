package com.crm.comcast.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
/**
 * This Class contains Methods related to DataBase
 * @author Harsha
 *
 */

public class DatabaseUtility {
	Connection conn=null;
	ResultSet rs=null;
	/**
	 * This Method will Establish Connection with DataBase
	 * @throws SQLException
	 */
	
	public void connectionToDB() throws SQLException
	{
		
		Driver driverRef;
		try
		{
			driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet", "root", "root");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This Method Will close DataBase Connection
	 * @throws SQLException
	 */
	
	public void closeDB() throws SQLException
	{
		conn.close();
	}
	/**
	 * This Method helps to verify data in DataBase
	 * @param query
	 * @param columnName
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	
	public String executeQueryAndGetData(String query,int columnName,String expData) throws SQLException
	{
		boolean flag=false;
		rs=conn.createStatement().executeQuery(query);
		while(rs.next())
		{
			if(rs.getString(columnName).equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData+"Data is Verified in DataBase");
			return expData;
		}
		else
		{
			System.out.println(expData+"Data is not Verified in DataBase");
			return expData;
		}
		
		
	}
	/**
	 * 
	 * @return
	 */
	public ResultSet readDataFromDataBase()
	{
		
		return rs;
		
	}
}
	
		

