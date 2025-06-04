<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>React(CDN) + Controller</title>
</head>
<body>
<ul>
<!-- jstl로 back-end 직접 출력 -->
<cr:forEach var="aa" items="${product}">
<li>${aa}</li>
</cr:forEach>
</ul>

<!-- react로 front-end가 출력 -->
<div id="box">
</div>

</body>
<script>
//backend 변수
var alldata = ${product};
</script>
<script src="https://unpkg.com/react@18.3.1/umd/react.production.min.js"></script>
<script src="https://unpkg.com/react-dom@18.3.1/umd/react-dom.production.min.js"></script>
<script src="https://unpkg.com/@babel/standalone@7.27.4/babel.min.js"></script>
<script type="text/babel" src="./product_list.js"></script>
</html>