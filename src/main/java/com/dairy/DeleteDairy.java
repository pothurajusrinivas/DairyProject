package com.dairy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.io.PrintWriter;


@WebServlet("/DeleteDairy")
public class DeleteDairy extends HttpServlet {
	private static final long serialVersionUID = 1L;
      Connection con=null;
      Statement st=null;
      
    public DeleteDairy() {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");	
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dairynote?useSSl=false","root","Vasu@123");
    		st=con.createStatement();
    	}
    	catch(ClassNotFoundException e)
    	{
    		System.out.println("type 4 is not correct");
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e.getMessage());
    	}
    	
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try
		{
			String  dat=req.getParameter("da");
	     	String  que="delete from dataentry where daattee ='"+dat+"'";
	     	 int ans=st.executeUpdate(que);
	     	PrintWriter pw=res.getWriter();
	     	 pw.write("<h1>Deleted Data Suc...</h1><br>");
			 pw.write("<a href='retrivedate.jsp'>Check data...</a>");
	     	
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			  
		}
	}

}
