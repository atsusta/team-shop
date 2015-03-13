
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">


<link rel="stylesheet" href="css/shop.css" />

<title>bottom_Products</title>
</head>
<body>

	<section>
		<!-- 				 <ul> -->
		<!-- 				 	<li> -->
		<div id="pageWrap">
			<div id="products">
				<table id="tb_main">

					<tr>
						<c:forEach items="${requestScope.outerProductPage.productList}"
							var="product" varStatus="status">
							<td id="product_cell" align="center"><a id="a_link"
								href="./product?type=productDetailView&productNo=${product.productNo}">
									<img id="img_cell" src="img/${product.productImage}"
									width="250px" /><br> ${product.productName}<br>
									${product.productContent}<br> ${product.productPrice}원
							</a></td>
							<c:if test="${status.count % 3 == 0}">
								<tr>
									<td colspan="3"></td>
								<tr>
							</c:if>

						</c:forEach>
					</tr>
				</table>
			</div>
			<div id="page_below">
				<c:forEach begin="${requestScope.outerProductPage.startPage}"
					end="${requestScope.outerProductPage.endPage}" var="i">
					<td colspan="3"><a id="pageCount"
						href="./product?type=outer&page=${i}">${i}</a></td>
				</c:forEach>
			</div>
		</div>
	</section>
</body>
</html>
<!-- 				 	</li> -->
<!-- 				 </ul> -->