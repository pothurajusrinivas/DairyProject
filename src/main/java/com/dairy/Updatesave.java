package com.dairy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;

@WebServlet("/updatsave")
public class Updatesave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   Connection con=null;
	  
  
    public Updatesave() 
    {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dairynote?useSSl=false","root","Vasu@123");
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
		String datenam=req.getParameter("id");
		String descrip=req.getParameter("textar");
		String query = "insert into dataentry (daattee, descrip) VALUES (?, ?)";
		
		try (PreparedStatement ps = con.prepareStatement(query)) {
            java.sql.Date date = java.sql.Date.valueOf(datenam);
            ps.setDate(1, date);
            ps.setString(2, descrip);
            ps.executeUpdate();
			
            PrintWriter out=res.getWriter();
			 out.write("<h1>Updated the  Data...</h1><br>");
			out.write("<a href='home.jsp'>View Updated   Data..</a>");
			  
		} 
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				  
			}
		
	}

}
