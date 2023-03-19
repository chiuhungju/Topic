<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>InsertComplient</title>
    <style>
        input,
        textarea {
            width: 300px;
            height: 20px;
        }

        #content {
            width: 300px;
            height: 100px;  
            font-size: 16px;
        }

        select {
            width: 300px;
            height: 20px;
        }
        form{
            text-align: center;
        }
       
    </style>
</head>

<body>
    <form method="get" action="InsertComplient" accept-charset="UTF-8">
       <span>聯絡人</span> <br><input type="text" value="${param.name}" name="customerName" disabled><br>
       <span>電子郵件</span> <br><input type="text" value="${param.email}" name="email" disabled><br>
       <span>問題類型</span> <br><input type="text" value="${param.complaintID}" name="complaintID" disabled><br>
        <span>標題</span> <br><input type="text" value="${param.title}" name="title" disabled><br>
        <span>問題說明</span> <br><textarea id="content"  name="content" disabled>${param.content}</textarea><br>
    </form>

    <script>
        var textarea = document.getElementById("content");
        textarea.focus();
        textarea.setSelectionRange(0, 0);
    </script>

</body>

</html>