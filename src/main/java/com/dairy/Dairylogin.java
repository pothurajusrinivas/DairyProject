package com.dairy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


@WebServlet("/Dairylogin")
public class Dairylogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	Statement st=null;

    public Dairylogin() {
    	try
    	{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dairynote?useSSl=false","root","Vasu@123");
    	st=con.createStatement();
    	}
    	catch(ClassNotFoundException e)
    	{
    		System.out.println("driver regis.. error..");
    	}
    	catch(SQLException e)
    	{
    		System.out.println("e.getMessage");
    	}
      
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		try
		{
	       String usname=req.getParameter("usna");
	       String uspwd=req.getParameter("pasw");
	       ResultSet rs=st.executeQuery("select * from dairy where usname='"+usname+"' and paswrd='"+uspwd+"' ");
	       RequestDispatcher rd=null;
	       if(rs.next())
	       {
	    	   rd=req.getRequestDispatcher("dataentry.html");
	    	   rd.forward(req, res);
	       }
	       else
	       {
	    	   req.setAttribute("msg","Incorrect  Login please try again..");
				rd=req.getRequestDispatcher("dairylogin.jsp");
				rd.forward(req, res);
	       }
		}
		catch(SQLException e)
		{
		System.out.println(e.getMessage());
		e.printStackTrace();
		}
	}

}
