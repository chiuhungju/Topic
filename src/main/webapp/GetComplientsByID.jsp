<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>客服後台管理</title>

<style>
table, tr, td {
	border: 0.5px solid black;
}

td {
	width: 70px;
	max-width: 70px;
	height: 20px;
	white-space: nowrap;
	/* 禁止文字自動換行 */
	overflow: hidden;
	text-overflow: ellipsis
}
</style>
</head>

<body>

	<form method="get" action="GetComplientsByID">
		抱怨序號 :<br> <input type="text" name="username" /> <input
			type="submit" value="確定" />
	</form>

	<form method="get" action="GetComplientsByName">
		姓名 :<br> <input type="text" name="name" /> <input type="submit"
			value="確定" />
	</form>

	<form method="get" action="GetComplientsByType">
		提問類型 : <br> <select name="complaintID">
			<option value="member">帳戶問題</option>
			<option value="purchase">購買問題</option>
			<option value="order">訂單問題</option>
			<option value="service">服務問題</option>
			<option value="dispute">消費爭議</option>
			<option value="forum">論壇問題</option>
			<option value="other">其他</option>
		</select> <input type="submit" value="確定" />
	</form>

	<br>
	<br>
	<br>
	<br>

	<table>
		<thead>
			<tr>
				<td>提問日期</td>
				<td>姓名</td>
				<td>信箱</td>
				<td>提問類型</td>
				<td>標題</td>
				<td>提問內容</td>
				<td>查看</td>
				<td>回信</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Complients}" var="c">
				<tr>
					<td>${c.createDate}</td>
					<td>${c.customerName}</td>
					<td>${c.email}</td>
					<td>${c.complaintID}</td>
					<td>${c.title}</td>
					<td>${c.content}</td>
					<td><a
						href="ViewComplient.jsp?name=${c.customerName}&email=${c.email}&complaintID=${c.complaintID}&title=${c.title}&content=${c.content}"><button>查看</button></a>
					</td>
                     <td><a
						href="ApplyComplients.jsp?ApplyDate=${c.createDate}&customerID=${c.customerID}&name=${c.customerName}&email=${c.email}&complaintID=${c.complaintID}&title=${c.title}&content=${c.content}"><button>回信</button></a>
					</td>           
					
				</tr>
			</c:forEach>
		</tbody>
	</table>





</body>

</html>