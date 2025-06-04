<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = "홍길동";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>React (CDN 방식)</title>
</head>
<body>
<div><%=username%>님 환영합니다.</div>
<div id="box"></div>
<div id="box2"></div>
</body>
<!-- React CDN 엔진 -->
<script src="https://unpkg.com/react@18.3.1/umd/react.production.min.js"></script>
<script src="https://unpkg.com/react-dom@18.3.1/umd/react-dom.production.min.js"></script>
<script src="https://unpkg.com/@babel/standalone@7.27.4/babel.min.js"></script>
<!-- React CDN 엔진 -->
<!-- React 소스 파일을 로드하여 HTML에 출력하는 코드 -->
<script type="text/babel" src="./index.js"></script>





</html>