import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EmpInfo 
{
		public static int savedetails(OrgBean bean) 
		{
			int status=0;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeesdata","root","Rk@mysql09");
				PreparedStatement prestate =connect.prepareStatement("insert into Empdetails (Empid,Empname,password,gender,country,email,mobile) values(?,?,?,?,?,?,?)");
				
				//OrgBean bean=new OrgBean();
				
				String Empname=bean.getEmpname();
				String Empid=bean.getEmpid();
				String pass=bean.getPassword();
				String gen=bean.getGender();
				String mail=bean.getEmail();
				String mob=bean.getMobile();
				String countryy=bean.getCountry();
				
				
				prestate.setString(1, Empid);
				prestate.setString(2, Empname);
				prestate.setString(3, pass);
				prestate.setString(4, gen);
				prestate.setString(5, countryy);
				prestate.setString(6, mail);
				prestate.setString(7, mob);
				
				
				status=prestate.executeUpdate();
			
				connect.close();
			
			}catch(SQLException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return status;
			
		}
		
		public static List<OrgBean> getAllEmployees()
		{
			List<OrgBean> emplist=new ArrayList<OrgBean>();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeesdata","root","Rk@mysql09");
				PreparedStatement prestate=connect.prepareStatement("select * from Empdetails");
				ResultSet result=prestate.executeQuery();
				while(result.next())
				{
					OrgBean bean=new OrgBean();
					bean.setEmpid(result.getString(1));
					bean.setEmpname(result.getString(2));
					bean.setPassword(result.getString(3));
					bean.setGender(result.getString(4));
					bean.setCountry(result.getString(5));
					bean.setEmail(result.getString(6));
					bean.setMobile(result.getString(7));
					emplist.add(bean);
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
			return emplist;
		}
		
		public static int deleteEmp(String empid )
		{
			int status=0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeesdata","root","Rk@mysql09");
				PreparedStatement prestate=connect.prepareStatement("delete from Empdetails where Empid=?");
				
				prestate.setString(1, empid);
				status=prestate.executeUpdate();
				connect.close();
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return status;
		}
		
		public static int editDetails(OrgBean bean) 
		{
			int status=0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect =DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeesdata","root","Rk@mysql09");
				PreparedStatement prestate=connect.prepareStatement("update Empdetails set Empname=?,password=?,gender=?,country=?,email=?,mobile=? where Empid=?");
				
				String empid=bean.getEmpid();
				String empname=bean.getEmpname();
				String password=bean.getPassword();
				String Gender=bean.getGender();
				String country=bean.getCountry();
				String mail=bean.getEmail();
				String mobile=bean.getMobile();
				
				//prestate.setString(1, empid);
				prestate.setString(1, empname);
				prestate.setString(2, password);
				prestate.setString(3, Gender);
				prestate.setString(4, country);
				prestate.setString(5, mail);
				prestate.setString(6, mobile);
				prestate.setString(7, empid);
				
				status=prestate.executeUpdate();
				connect.close();
			
			}catch(Exception e)
				{
				System.out.println(e);	
				}
			return status;
		}
		
		
		public static OrgBean getEmpById(String empid)
		
		{
			OrgBean bean=new OrgBean();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect =DriverManager.getConnection("jdbc:mysql://localhost:3306/Employeesdata","root","Rk@mysql09");
				PreparedStatement prestate=connect.prepareStatement("select * from Empdetails  where Empid=?");
				
				prestate.setString(1, empid);
				ResultSet result=prestate.executeQuery();
				
				while(result.next())
				{
					bean.setEmpid(result.getString(1));
					bean.setEmpname(result.getString(2));
					bean.setPassword(result.getString(3));
					bean.setGender(result.getString(4));
					bean.setCountry(result.getString(5));
					bean.setEmail(result.getString(6));
					bean.setMobile(result.getString(7));
					connect.close();
				}
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
			return bean;
		}
		
		
}
