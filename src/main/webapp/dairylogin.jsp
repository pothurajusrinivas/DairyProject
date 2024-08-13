<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<link rel="stylesheet" href="styledairy.css">
</head>
<body>
 <%
       String value=(String) request.getAttribute("msg");
   if(value!=null)
   {
	   out.print(value);
   }
   %>
<form  method="post" action="Dairylogin">
<div class="box">
  <h1>Login Here</h1>
  <div class="mov">
  UserName   <input type="text" name="usna" placeholder="Enter name"><br></br>
  password   <input type="password" name="pasw" placeholder="enter password">
  <div class="button">
  <button type="submit" class="login-button">Login</button>
  </div>
  <p><a href="Register.html">Create new  Account</a></p>
  </div>
  <div class="img">
  <img src="images/book.png" alt="no image">
  <p> My Dairy </p>
  </div>
  </div>
  </form>
</body>
</html>