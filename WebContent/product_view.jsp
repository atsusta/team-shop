<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
</style>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Product_View</title>
</head>
<body>
	<form action="order" method="POST">
		<table border="1">
			<tr>
				<div id="view">

					<div id="smallImg">
						<img src="img/${requestScope.product.productImage}" width="120"
							height="200" />
					</div>
					<div id="productName">
						<h4>${requestScope.product.productName}</h4>
					</div>
					<div id="productContent">
						<h4>${requestScope.product.productContent}</h4>
					</div>
					<div id="productPrice">
						<h3>price: ${requestScope.product.productPrice}</h3>
					</div>
					color: &nbsp;<select name="productColor">
						<option value="none">None</option>
						<option value="black">Black</option>
						<option value="red">Red</option>
						<option value="blue">Blue
							</oprion>
					</select> size: &nbsp;<select name="productSize">
						<option value="Samll">S</option>
						<option value="Medium">M</option>
						<option value="Large">L</option>
					</select> 수량: <input type="number" name="quantity" min="1" width="2">

					<input type="hidden" name="customerId"
						value="${sesscionScope.registerId}"> <input type="hidden"
						name="productNo" value="${requestScope.product.productNo}">
					<input type="hidden" name="productPrice"
						value="${requestScope.product.productPrice}"> <input
						type="hidden" name="productStock"
						value="${requestScope.product.productStock}">
					<!-- 		<input type="hidden" name="type" value="order"> -->
					<input type="submit" value="구매하기">

					<hr>
					<div id="bigImg">
						<img src="img/${requestScope.product.productImage}" width="400"
							height="500" />
					</div>


				</div>
		</table>
	</form>
</body>
</html>