package com.dairy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/view")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  Connection con=null;
	  Statement st=null;
  
    public View()
    {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dairynote?useSSl=false","root","Vasu@123");
    		st=con.createStatement();
    	}
    	  catch(ClassNotFoundException e)
    	{
        	System.out.println("type 4 not found ");
    	}
     	catch(SQLException e)
    	{
    		System.out.println(e.getMessage());
    	}
      
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		 String dat=req.getParameter("da");
			java.sql.Date dtr=java.sql.Date.valueOf(dat);
			String sqdat="'"+dtr.toString()+"'";
	    
	try
	{

		//@SuppressWarnings("unused")
		String str="select * from dataentry where daattee="+sqdat;
		ResultSet rs=st.executeQuery(str);
		
		if(rs.next())
		{
			req.setAttribute("id",rs.getString(1));
			req.setAttribute("data",rs.getString(2));
			RequestDispatcher rd=req.getRequestDispatcher("view.jsp");
			rd.forward(req,res);
		}
		 else {
             req.setAttribute("error", "No data found for the given date.");
             RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
             rd.forward(req, res);
         }

	}
        	 catch(SQLException e)
            {
            	System.out.println(e.getMessage());
             }

		
	}

}
