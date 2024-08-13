<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retrieving the specific date</title>
<style>

.retr{
    
   margin-left:450px;
   margin-top:80px;
   background-color:violet;
   width:400px;
   height:180px;
   
}
.retr label{
    font-size:25px;
}
.retr h2{
  text-align:center;
  padding:10px;
}
.butt:hover{
   
   cursor: pointer;
  background-color:yellow; 
}
.butt{
margin-top: 30px;
padding:3px 10px;
margin-left:155px;
}
</style>
</head>
<body>
<%
String s=(String)request.getAttribute("msg");
if(s!=null)
	out.print(s);
%>
     <form method="post" action="retrivedate">
     <div class="retr">
     <h2>Check the Date</h2>
     <label>Retrieve Date :</label>
     <input type="date" name="retrieve"></br>
     <button type="submit" class="butt">check</button>
     </div>
     </form>
</body>
</html>