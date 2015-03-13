<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- <link rel="stylesheet" type="text/css" href="styles/styles.css"> -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css">
<title>가상 결제 화면</title>
</head>
<body class="checkout">
	<div class="container">
		<div class="page-header">
			<h2>결제 확인</h2>
<!-- 			<div class="col-sm-4 col-sm-offset-8"> -->
				<!-- 							<span class="card">결제 진행중...</span> -->
<!-- 				<div class="animation-square"></div> -->
<!-- 			</div> -->
		</div>
		<form action="payment" method="post">
			<div class="row">
				<section id="payment-summary">
				<div class="col-xs-12 col-sm-6 col-sm-offset-6 text-right">
					<dl class="dl-horizontal">
						<blockquote>
							<dt>제품 가격</dt>
							<dd>￦${requestScope.subtotal }</dd>
							<dt>배송비</dt>
							<dd>￦${requestScope.shippingPrice }</dd>
							<hr>
							<dt>총 가격</dt>
							<dd>￦${requestScope.subtotal + requestScope.shippingPrice }</dd>
						</blockquote>
					</dl>
				</div>
				<div class="col-xs-12 col-sm-12">
					<hr>
					<div class="row">
						<div class="col-xs-12 col-sm-4 col-sm-offset-2">
							<div class="form-group">
								<label for="cardNumber">카드 번호</label> <input type="text"
									class="form-control" name="cardNumber" id="cardNumber"
									size="20" placeholder="카드 번호" data-stripe="number">
							</div>
						</div>
						<div class="col-xs-12 col-sm-4">
							<div class="form-group">
								<label for="cardCompany">카드사</label> <input type="text"
									class="form-control" name="cardCompany" id="cardCompany"
									list="cardCompanies">
								<datalist id="cardCompanies">
									<option>우리은행</option>
									<option>신한은행</option>
									<option>국민은행</option>
									<option>하나은행</option>
									<option>농협</option>
									<option>IBK 기업은행</option>
									<option>?????</option>
								</datalist>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-4 col-sm-offset-2">
							<div class="form-group">
								<label for="cvc">CVC</label> <input type="text"
									class="form-control" name="cvc" id="cvc" size="4"
									placeholder="CVC" data-numeric>
							</div>
						</div>
						<div class="col-xs-12 col-sm-4">
							<div class="form-group">
								<label for="expiration">기간 만료일</label> <input type="text"
									class="form-control" name="expiration" id="expiration" size="9"
									placeholder="MM / YYYY">
							</div>
						</div>
					</div>
				</div>
				</section>
			</div>
			<div class="row">
				<section id="button">
				<div class="col-xs-12">
					<hr>
				</div>
				<div class="col-xs-12 text-right">
					<input type="submit" class="btn btn-inverse btn-lg" value="돈 받아라">
					<input type="button" class="btn btn-inverse btn-lg" value="결제 취소"
						onclick="goToPrevious()">
				</div>
				</section>
			</div>
		</form>
	</div>
</body>
</html>