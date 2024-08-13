<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
  body{
    justify-content: center;
     margin-left:500px;
     margin-top:100px;
 }
    .all{
       background-color:violet;
      width:300px;
      height:200px;
      justify-content: center;
 }
  .delete:hover{
       background-color:red;
        cursor:pointer;
   }
   .view:hover{
       background-color:yellow;
        cursor:pointer;
   }
    .update:hover{
       background-color:orange;
        cursor:pointer;
   }

     .all h1{
    text-align:center;
   
   }
   .view{
         margin-top:-40px;
         margin-left:1px;
   }
   .update{
      margin-top:-140px;
   }
   .bor{
          margin-left :-10px;
   }
 </style>
</head>
<body>
<div class="all">

<h1>Select any Action<h1>

   <form method="post" action="view">
    <input type="date" name="da" class="bor">
    <button type="submit" class="view">view</button>
    </form>
    <form method="post" action="Update">
      <input type="date" name="daa">
     <button type="submit" class="update">update</button>
     </form>
     <form method="post" action="DeleteDairy">
       <input type="date" name="da">
     <button type="submit" class="delete">Delete</button>
     </form>
     </div>
</body>
</html>