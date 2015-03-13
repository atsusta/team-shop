<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>쇼핑몰</title>
<meta charset="EUC-KR">
<link rel="stylesheet" href="css/shop.css" />
</head>

<body>
	<!-- 헤더 -->
	<header>
		<img border="0" src="img/headerimg.jpg" alt="header" width="100%"
			height="200px">
	</header>

	<!-- 네비게이션 -->
	<div id="navi" style="text-align: center;">
		<br> <br> <span><a href="./product?type=all">ALL</a></span><span>&nbsp;
			&nbsp; &nbsp; |&nbsp; &nbsp; &nbsp; </span> <span><a
			href="./product?type=top">TOP</a></span><span>&nbsp; &nbsp; &nbsp;
			|&nbsp; &nbsp; &nbsp; </span> <span><a href="./product?type=bottom">BOTTOM</a></span><span>&nbsp;
			&nbsp; &nbsp; |&nbsp; &nbsp; &nbsp; </span> <span><a
			href="./product?type=outer">OUTER</a></span><span>&nbsp; &nbsp;
			&nbsp; |&nbsp; &nbsp; &nbsp; </span> <span>MY-ORDER</span><span>&nbsp;
			&nbsp; &nbsp; |&nbsp; &nbsp; &nbsp; </span> <span>REVIEW</span><span>&nbsp;
			&nbsp; &nbsp; |&nbsp; &nbsp; &nbsp; </span> <span>Q&A</span>

		<!-- <section width="100%" height="900px"> -->
		<!-- <a href="/ProductView/product?type=all"><img border="0" src="img/mainimg.jpg" alt="header" height="300px" style="position:center ; padding-top: 200px"></a> -->
		<!-- <a href="/ProductView/product">홈페이지</a> -->

		<!-- section -->
		<div id="products_page">
			<jsp:include page="${requestScope.list }" flush="false" />
		</div>

		<!-- footer -->
		<footer> </footer>
	</div>
</body>
</html>