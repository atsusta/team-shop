<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.css">
<script src="http://code.jquery.com/jquery-2.1.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#buyer").click(
				function() {
					$("#display").load(
							"http://localhost:8081/Port3/order?type=seller");
				})
		$("#seller").click(function() {
			$("#display").load("http://localhost:8081/Port3/order?type=buyer");
		})
		$("#newOrder").click(function() {
			$("#display").load("/Port3/order?type=newOrder");
		})
		$("#newProduct")
				.click(
						function() {
							$("#display")
									.load(
											"http://localhost:8081/Port3/product?type=productForm");
						})
	})
</script>
<title>관리자 페이지</title>
</head>
<body class="bg-inverse">
	<div class="container">
		<div class="page-header">
			<h1 class="text-inverse">관리자 페이지</h1>
		</div>
	</div>
<!-- 	<div class="container"> -->
<!-- 		<div class="row"> -->
<!-- 			<section> -->
<!-- 				<div class="col-sm-3 text-center"> -->
<!-- 					<button type="button" class="btn btn-default btn-md btn-block" id="buyer"> -->
<!-- 						구매자 결제요청 -->
<!-- 					</button> -->
<!-- 				</div> -->
<!-- 				<div class="col-sm-3 text-center"> -->
<!-- 					<button type="button" class="btn btn-default btn-md btn-block" id="seller"> -->
<!-- 						<span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> 판매자 결제승인 -->
<!-- 					</button> -->
<!-- 				</div> -->
<!-- 				<div class="col-sm-3 text-center"> -->
<!-- 					<button type="button" class="btn btn-default btn-md btn-block" id="newOrder"> -->
<!-- 						주문 등록 -->
<!-- 					</button> -->
<!-- 				</div> -->
<!-- 				<div class="col-sm-3 text-center"> -->
<!-- 					<button type="button" class="btn btn-default btn-md btn-block" id="newProduct"> -->
<!-- 						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 상품 추가 -->
<!-- 					</button> -->
<!-- 				</div> -->
<!-- 			</section> -->
	<div class="container">
		<nav class="nav navbar-inverse">
			<ul class="nav navbar-nav">
				<li role="presentation"><a href="#">구매자 결제요청</a></li>
				<li role="presentation"><a href="#"><span
						class="glyphicon glyphicon-credit-card" aria-hidden="true"></span>
						판매자 결제승인</a></li>
				<li role="presentation"><a href="#">주문 등록</a></li>
				<li role="presentation"><a href="#"><span
						class="glyphicon glyphicon-plus" aria-hidden="true"></span> 상품 추가</a>
				</li>
			</ul>
		</nav>
	</div>
<!-- 		</div> -->
	<div class="container" id="display">
	<!-- page view -->
	
	</div>
	</div>
</body>
</html>
