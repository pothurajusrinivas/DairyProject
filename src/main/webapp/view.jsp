<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update data</title>
<style>
 body {
    display: flex;
    justify-content: center;
    margin-top: 80px;
  }

  .all {
    background-color: violet;
    width: 400px;
    height:350px;
  
  }



  .data h1 {
    text-align: center;
  }
   .data label {
  
    display: block; 
    font-size: 30px;
    text-align: left;
     margin-top: 65px;
    margin-right: 50px;
    margin-bottom: -50px;
    margin-left: 6px;
     
  }
     .data input{
      margin-left:139px;
      margin-top:22px;
  }
   .data textarea{
        margin-left:138px;
   } 
    .data input[type="submit"]{
         color:yellow;
    }
    .data input[type="submit"]:hover{
             background-color:orange;
              cursor: pointer;
   }
   </style>
</head>
<body>
   <div class="all">
   <form  method="post" action="Dairylogin">
 
    <div class="data">
        <h1>View Data</h1>
        <label>Date :</label>
        <input type="date" name="id" value=<%=request.getAttribute("id") %>> <br>
        <label>Data :</label>
        <textarea name="textar" rows="4" cols="25" >${data}</textarea>
   </div>
      <input type="submit" value="Back to Login">
  </form>
</body>
</html>