package com.dairy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dairyregister")
public class Dairyregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement st=null;
   
    public Dairyregister() {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dairynote?useSSl=false","root","Vasu@123");
    	    st=con.createStatement();
    	}
       catch(ClassNotFoundException e) 
    	{
    	   System.out.println("type 4 for mysql found ");
    	}
    	catch(SQLException e)
    	{
    		System.out.println(e.getMessage());
    	}
      
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		try
		{
		 String usernam=req.getParameter("usnam");
		 String userpasw=req.getParameter("pasw");
		 st.executeUpdate("insert into dairy(usname,paswrd) values('"+ usernam+"','"+userpasw+"')");
		 PrintWriter out=res.getWriter();
		 out.write("<h1>Registered Suc...</h1><br>");
		 out.write("<a href='dairylogin.jsp'>Please login..</a>");
		}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				  
			}
		}
		
	}


