<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<script src="http://code.jquery.com/jquery-2.1.3.js"></script>
<script type="text/javascript">
	$(function () {
		$("#quantity").change(function () {
			var newSubtotal = $("#price").text() * $("#quantity").val();
			$("#subtotalValue").text("￦ " + newSubtotal);
		})
	})
</script>
<title>주문서 작성</title>
</head>
<body class="checkout">
	<div class="container">
		<div class="page-header">
			<h2>주문 확인</h2>
		</div>
	</div>
	<div class="container">
		<form action="checkout" method="post">
			<div class="row">
				<!-- 주문한 상품 -->
				<div class="col-xs-12 col-sm-12">
					<section>
					<h3>주문 상품</h3>
					<table class="table">
						<tr>
							<th id="image"></th>
							<th>제품</th>
							<th>가격</th>
							<th>수량</th>
							<th>총 가격</th>
						</tr>
						<tr>
							<td id="image" rowspan="2"><img src="${requestScope.imgSrc }" alt="제품이미지"></td>
							<td id="name">${requestScope.product.productName }</td>
							<td id="price" rowspan="2">${requestScope.product.productPrice }</td>
							<td rowspan="2" class="col-sm-3">
								<input type="number" class="form-control input-xs" id="quantity"
									name="orderQuantity" value="${requestScope.orderInfo.orderQuantity }" 
									min="1" max="10">
								<input type="hidden" name="orderNo"
									value="${requestScope.orderInfo.orderNo }">
							</td>
							<td rowspan="2" id="subtotalValue" class="col-sm-3">￦ ${requestScope.subtotal }</td>
						</tr>
						<tr>
							<td id="size">size: ${requestScope.orderInfo.productSize }</td>
						</tr>
					</table>
					</section>
				</div>
			</div>
			<div class="row">
				<!-- 주문자 정보(결제) -->
				<div class="col-xs-12 col-sm-8">
					<section>
					<h3>주문자 정보</h3>
					<table class="table">
						<tr>
							<th>이름</th>
							<td>${requestScope.customer.name }</td>
						</tr>
						<tr>
							<th>E-mail</th>
							<td>${requestScope.customer.eMail }</td>
						</tr>
						<tr>
							<th>전화 번호</th>
							<td>${requestScope.customer.phone }</td>
						</tr>
					</table>
					</section>
				</div>
			</div>
			<div class="row">
				<!-- 배송지 정보 -->
				<div class="col-xs-12 col-sm-12">
						<section>
							<h3>배송지 정보</h3>
							<hr>
							<div class="row">
								<div class="col-xs-12 col-sm-2">
									<h4>이름</h4>
								</div>
								<div class="form-group col-sm-4">
									<input type="text" class="form-control input-md" size="20"
										name="customerName">
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-2">
									<h4>전화번호</h4>
								</div>
								<div class="form-group col-sm-4">
									<input type="text" class="form-control input-md col-xs-2"
										name="phoneNumber" pattern="\d*">
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<h4>주소</h4>
								</div>
								<div class="form-group col-xs-3 col-sm-3 col-sm-offset-2">
									<label for="zipCode">우편 번호</label>
									<input type="text" class="form-control input-md" 
										id="zipCode" size="3" name="zipCode" pattern="\d*">
								</div>
								<div class="form-group col-xs-12 col-sm-8 col-sm-offset-2">
									<label for="address">기본 주소</label>
									<input type="text" class="form-control input-md"
										id="address" size="30" name="address">
								</div>
								<div class="form-group col-xs-12 col-sm-8 col-sm-offset-2">
									<label for="address2">나머지 주소</label>
									<input type="text" class="form-control input-md" id="address2" size="30"
										name="address2">
								</div>
							</div>
							<div class="row">
								<div class="form-group col-xs-12 col-sm-8 col-sm-offset-2">
									<label for="shippingMessage">배송 메시지<br>(100자 이내)
									</label>
									<textarea class="form-control input-lg" id="shippingMessage"
										rows="5" cols="60" name="shippingMessage"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-xs-12 col-sm-3 col-sm-offset-7">
									<label for="paymentType">결제 방식</label>
									<!-- 결제 정보 -->
									<input type="text" class="form-control" id="paymentType"
										name="paymentType" list="paymentTypes">
									<datalist id="paymentTypes">
										<option>무통장 입금</option>
										<option>신용 카드</option>
									</datalist>
								</div>
							</div>
						</section>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 text-right">
					<hr>
					<input type="submit" class="btn btn-inverse btn-lg" value="주문하기"
						class="order"> 
					<input type="button" class="btn btn-inverse btn-lg" value="주문 취소" 
						onclick=goToPrevious() class="order">
				</div>
			</div>
		</form>
	</div>
</body>
</html>