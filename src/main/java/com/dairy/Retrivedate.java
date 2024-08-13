package com.dairy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;


@WebServlet("/retrivedate")
public class Retrivedate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       Connection con=null;
       Statement st=null;
    
    public Retrivedate()
    {
     try
     {
    	Class.forName("com.mysql.cj.jdbc.Driver"); 
    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dairynote?useSSl=false","root","Vasu@123");
    	st=con.createStatement();
     }
     catch(ClassNotFoundException e)
     {
    	 System.out.println("there is error in type4");
     }
       catch(SQLException e)
       {
        System.out.println(e.getMessage());
       }
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String dat=req.getParameter("retrieve");
		  Date dtr = Date.valueOf(dat); //before retriveing the querry, convert the string into java.sql.date
		  String sqdat="'"+dtr.toString()+"'";
		try
		{
			
			ResultSet rs=st.executeQuery("select * from dataentry where daattee="+sqdat);
			if(rs.next())
			{
				RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
				rd.forward(req,res);
			}
			else
			{
				req.setAttribute("msg","Date is not available");
				RequestDispatcher rd=req.getRequestDispatcher("retrivedate.jsp");
				rd.forward(req, res);
			}
		}
		  catch(SQLException e)
        {
        	System.out.println(e.getMessage());
        }
		
	}

}
