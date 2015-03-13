<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>구매자 결제요청</title>
</head>
<body bgcolor="skyblue">
	<table align="center">

		<tr>
			<td><strong>안녕하십니까, admin님^^</strong></td>
		</tr>
	</table>

	<table align="center" border="1" width="">
		<tr>
			<td><strong>admin님의 구매목록</strong></td>
		</tr>
		<tr>
			<td><c:choose>
					<c:when test="${requestScope.listcount == 0}">구매하신 물품이 없습니다.</c:when>
					<c:otherwise>
						<table border="1" width="100%">
							<tr>
								<td width="10%" align="center">주문번호</td>
								<td width="10%" align="center">이미지</td>
								<td width="12%" align="center">상품명</td>
								<td width="37%" align="center">내용</td>
								<td width="12%" align="center">주문날짜</td>
								<td width="9%" align="center">요청버튼</td>
								<td width="10%" align="center">배송상황</td>
							</tr>
						</table>
						<c:forEach items="${requestScope.buylist }" var="list">
							<table>
								<tr>
									<!-- 여기서부터 다시작업 / product_no를 이용해 select 해서 이미지값 / 이름등을 뽑아온당~ -->
									<td width="10%" align="center">${list.order_no }</td>
									<td width="10%"><img src=${list.image } width="100%"
										height="120"></td>
									<td width="12%">${list.name }</td>
									<td width="37%">${list.content }</td>
									<td width="12%">${list.order_date }</td>
									<td width="9%" align="center"><c:choose>
											<c:when test="${list.paychk}">
												결제완료
											</c:when>
											<c:otherwise>
												<input type="submit" value="결제요청">
											</c:otherwise>
										</c:choose></td>
									<td width="10%">${list.shipping }</td>
								</tr>
							</table>
							<table>
								<tr>
									<td><br></td>
								</tr>
							</table>
						</c:forEach>
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
</body>
</html>