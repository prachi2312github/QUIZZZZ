package com.quiz;


	import java.sql.Connection;
import	java.lang.NullPointerException;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	//import java.lang.ClassNotFoundException;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
	
	public class UserInput 
	{
		
		static PreparedStatement prs=null;
		static Connection con=null;
	
	   public void getUserDetails(String firstName,String middleName,String lastName,String mobile,String email,String password)
	   
	   {
	   try
	   {
		   ConnectionTest connectionTest=new ConnectionTest();
		   Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","root");
		    prs = con.prepareStatement("insert into user(id,firstName,middleName,lastName,mobile,email,password) values (?,?,?,?,?,?,?)");
			int id = 0;
			prs.setInt(1, id);
			prs.setString(2,firstName);
			prs.setString(3,middleName);
			prs.setString(4,lastName);
			prs.setString(5,mobile);
			prs.setString(6,email);
			prs.setString(7,password);
			int i=prs.executeUpdate();
			//System.out.println(+i);
			   
		   }
		   
	   catch(Exception e)
	   {
			
			e.printStackTrace();
		}
	   }
	   public void getQuestion(int Qno,String Question,String A,String B,String c,String D) throws SQLException
	   {
		   prs = con.prepareStatement("select * from questions order by rand()");
		   ResultSet rs=prs.executeQuery();
		   try
		  {
		   while(rs.next())
		   {
			   int count=1;
			  //System.out.println("Qno="+rs.getInt(1));
			   System.out.println((count)+" "+"Question="+rs.getString(2));
			   System.out.println("A="+rs.getString(3));
			  System.out.println("B="+rs.getString(4));
			  System.out.println("C="+rs.getString(5));
		      System.out.println("D="+rs.getString(6));
		      count++;
		     // System.out.println("Answer="+rs.getString(7));
			   System.out.print("Choose the Correct Option:");
			   Scanner sc=new Scanner(System.in);
   			   System.out.println(" ");
		        String ans = sc.next();
		        String Answer=null;
		        int Score=0;
		        Answer=rs.getString(7);
		          if(ans==Answer)
		          {
		        	  System.out.println("correct");
		        	  Score++;
		        	  
		          }else
		          {
		        	  System.out.println("incorrect");
		          }
		          
		          prs = con.prepareStatement("insert into user(Score)values(?)");
		          //ResultSet rs1=prs.executeQuery();
		          System.out.println("total score="+Score);
		         int j= prs.executeUpdate();
		          
				   
			  }
		  }
		   catch(Exception e) 
		  {
			  e.printStackTrace();
		   }
		   rs.close();
	
	   }
	   
	   

	   public static void main(String args[]) throws SQLException
	   {
		   Scanner sc=new Scanner(System.in);
		   //for(int i=0;i<2;i++)
		   //{
			   System.out.println("Enter the ID::");
			   Integer id=sc.nextInt();
			   System.out.println("Enter the FirstName::");
			   String firstName=sc.next();
			   System.out.println("Enter the middleName::");
			   String middleName=sc.next();
			   System.out.println("Enter the LastName::");
			   String lastName=sc.next();
			   System.out.println("Enter the MobileNo::");
			   String mobile=sc.next();
			   System.out.println("Enter the Email::");
			   String email=sc.next();
			   System.out.println("Enter the Password::");
			   String password=sc.next();	   
			   UserInput userinput=new UserInput();
			   userinput.getUserDetails(firstName, middleName, lastName, mobile, email,password);
			   userinput.getQuestion(id, password, password, password, password, password);
			   
			   
			  
		   //}
		   //sc.close();
	   }
	
	
	}