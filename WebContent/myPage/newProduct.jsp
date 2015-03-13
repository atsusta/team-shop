<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.css">
<title>상품등록 페이지</title>
<script src="http://code.jquery.com/jquery-2.1.3.js"></script>
<script src="../bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	$(".dropdown-toggle").dropdown();
</script>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>상품등록</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<form action="/Port3/product" method="post">
					<div class="form-group">
						<label for="productName">상품 이름</label>
						<input type="text" class="form-control input-md" name="productName" id="productName"
							placeholder="상품 이름">
					</div>
					<div class="form-group">
						<div class="dropdown">
							<label for="productColor">상품 색상</label>
							<button class="btn btn-default dropdown-toggle" type="button" 
								id="productColor" data-toggle="dropdown" aria-expanded="true">
	    						상품 색상
	    						<span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu" aria-labelledby="productColor">
								<li role="presentation"><a role="menuitem" tabindex="-1" 
									href="#">RED</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1" 
									href="#">BLUE</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1" 
									href="#">AQUA</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1" 
									href="#">BLACK</a></li>
							</ul>
						</div>
					</div>
					<div class="form-group">
						<label for="productPrice">상품 가격</label>
						<input type="text" class="form-control input-md" name="productPrice" id="productPrice"
								placeholder="상품 가격">
					</div>
					<div class="form-group">
						<label for="productImage">상품 이미지</label>
						<input type="file" class="form-control input-md" name="productImage" id="productImage">
					</div>
					<div class="form-group">
						<label for="productContent">상품 간단한 내용 (24자 내외)</label>
						<input type="text" class="form-control input-md" name="productContent" id="productContent"
								placeholder="상품 간단한 내용">
					</div>
					<div class="form-group">
						<label for="productDetail">상품 상세 내용</label>
						<textarea rows="5" cols="40" name="productDetail" id="productDetail"
								placeholder="상품 상세 내용"></textarea>
					</div>
					<div class="form-group">
						<label for="productCategory">상품 카테고리</label>
						<select name="productCategory" id="productCategory">
							<option value="top">TOP</option>
							<option value="bottom">BOTTOM</option>
							<option value="outer">OUTER</option>
						</select>
					</div>
					<div class="form-group">
						<label for="productStock">재고</label>
						<input type="text" class="form-control input-md" name="productStock" id="productStock">
					</div>
					<div class="form-group">
						<input type="hidden" name="type" value="productResult">
						<input type="reset" value="리셋">
						<input type="submit" value="상품등록">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>