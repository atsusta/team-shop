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
			$("#subtotalValue").text("�� " + newSubtotal);
		})
	})
</script>
<title>�ֹ��� �ۼ�</title>
</head>
<body class="checkout">
	<div class="container">
		<div class="page-header">
			<h2>�ֹ� Ȯ��</h2>
		</div>
	</div>
	<div class="container">
		<form action="checkout" method="post">
			<div class="row">
				<!-- �ֹ��� ��ǰ -->
				<div class="col-xs-12 col-sm-12">
					<section>
					<h3>�ֹ� ��ǰ</h3>
					<table class="table">
						<tr>
							<th id="image"></th>
							<th>��ǰ</th>
							<th>����</th>
							<th>����</th>
							<th>�� ����</th>
						</tr>
						<tr>
							<td id="image" rowspan="2"><img src="${requestScope.imgSrc }" alt="��ǰ�̹���"></td>
							<td id="name">${requestScope.product.productName }</td>
							<td id="price" rowspan="2">${requestScope.product.productPrice }</td>
							<td rowspan="2" class="col-sm-3">
								<input type="number" class="form-control input-xs" id="quantity"
									name="orderQuantity" value="${requestScope.orderInfo.orderQuantity }" 
									min="1" max="10">
								<input type="hidden" name="orderNo"
									value="${requestScope.orderInfo.orderNo }">
							</td>
							<td rowspan="2" id="subtotalValue" class="col-sm-3">�� ${requestScope.subtotal }</td>
						</tr>
						<tr>
							<td id="size">size: ${requestScope.orderInfo.productSize }</td>
						</tr>
					</table>
					</section>
				</div>
			</div>
			<div class="row">
				<!-- �ֹ��� ����(����) -->
				<div class="col-xs-12 col-sm-8">
					<section>
					<h3>�ֹ��� ����</h3>
					<table class="table">
						<tr>
							<th>�̸�</th>
							<td>${requestScope.customer.name }</td>
						</tr>
						<tr>
							<th>E-mail</th>
							<td>${requestScope.customer.eMail }</td>
						</tr>
						<tr>
							<th>��ȭ ��ȣ</th>
							<td>${requestScope.customer.phone }</td>
						</tr>
					</table>
					</section>
				</div>
			</div>
			<div class="row">
				<!-- ����� ���� -->
				<div class="col-xs-12 col-sm-12">
						<section>
							<h3>����� ����</h3>
							<hr>
							<div class="row">
								<div class="col-xs-12 col-sm-2">
									<h4>�̸�</h4>
								</div>
								<div class="form-group col-sm-4">
									<input type="text" class="form-control input-md" size="20"
										name="customerName">
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-2">
									<h4>��ȭ��ȣ</h4>
								</div>
								<div class="form-group col-sm-4">
									<input type="text" class="form-control input-md col-xs-2"
										name="phoneNumber" pattern="\d*">
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<h4>�ּ�</h4>
								</div>
								<div class="form-group col-xs-3 col-sm-3 col-sm-offset-2">
									<label for="zipCode">���� ��ȣ</label>
									<input type="text" class="form-control input-md" 
										id="zipCode" size="3" name="zipCode" pattern="\d*">
								</div>
								<div class="form-group col-xs-12 col-sm-8 col-sm-offset-2">
									<label for="address">�⺻ �ּ�</label>
									<input type="text" class="form-control input-md"
										id="address" size="30" name="address">
								</div>
								<div class="form-group col-xs-12 col-sm-8 col-sm-offset-2">
									<label for="address2">������ �ּ�</label>
									<input type="text" class="form-control input-md" id="address2" size="30"
										name="address2">
								</div>
							</div>
							<div class="row">
								<div class="form-group col-xs-12 col-sm-8 col-sm-offset-2">
									<label for="shippingMessage">��� �޽���<br>(100�� �̳�)
									</label>
									<textarea class="form-control input-lg" id="shippingMessage"
										rows="5" cols="60" name="shippingMessage"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-xs-12 col-sm-3 col-sm-offset-7">
									<label for="paymentType">���� ���</label>
									<!-- ���� ���� -->
									<input type="text" class="form-control" id="paymentType"
										name="paymentType" list="paymentTypes">
									<datalist id="paymentTypes">
										<option>������ �Ա�</option>
										<option>�ſ� ī��</option>
									</datalist>
								</div>
							</div>
						</section>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 text-right">
					<hr>
					<input type="submit" class="btn btn-inverse btn-lg" value="�ֹ��ϱ�"
						class="order"> 
					<input type="button" class="btn btn-inverse btn-lg" value="�ֹ� ���" 
						onclick=goToPrevious() class="order">
				</div>
			</div>
		</form>
	</div>
</body>
</html>