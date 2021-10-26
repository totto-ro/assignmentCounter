<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home Page</title>
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
	</head>
	<body>
		<main class="main">
			<div>
				<h1>You have visited <c:out value="${ numCount }"/> times</h1>
				<a class="links" href="/">Test another visit?</a>
				<a class="resetB" href="/reset"><button>Reset Session</button></a>
			</div>
		</main>
	</body>
</html>