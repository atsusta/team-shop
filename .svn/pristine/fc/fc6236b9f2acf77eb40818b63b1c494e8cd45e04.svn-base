package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;
import service.ProductService;
import vo.OrderInfo;
import vo.Product;

/**
 * Servlet implementation class CheckoutServlet
 * 주문하기를 눌렀을 때 사용되는 서블릿
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = null;
		int subtotal = 0;
		int shippingPrice = 0;
		
		/**
		 * 상품 설명 -> 바로 구매(장바구니) -> 주문서 작성 -!> 결제
		 * 주문서 작성 페이지에서 넘어온 정보 저장
		 * 주문서 작성 페이지에서 이미 order_info 테이블에 tuple 하나가 추가됨
		 */
		// DB에서 찾고 수정할 정보들
		int orderNo = Integer.parseInt(
				request.getParameter("orderNo"));
		int orderQuantity = Integer.parseInt(
				request.getParameter("orderQuantity"));
		String paymentType = request.getParameter("paymentType");
		boolean paymentCheck = false;
		String shippingMessage = request.getParameter("shippingMessage");
		String shippingStatus = "입금 대기";
		
//		int orderNo = 1;
//		int orderQuantity = 1;
//		String paymentType = "무통장 입금";
//		String shippingMessage = "부재시 경비실에 맡겨주세요";
		
		// 배송지 정보 -> 어떻게 처리?
		String cutomerName = request.getParameter("customerName");
		String phoneNumber = request.getParameter("phoneNumber");
		String zipCode = request.getParameter("zipCode");
		String address = request.getParameter("address") + 
				request.getParameter("address2");
		
		// DB에서 주문서의 수량, 결제방식, 결제 완료 여부, 배송 메시지, 배송 상태 수정하기
		OrderService orderService = OrderService.getInstance();		
		orderService.updateProduct(orderNo, orderQuantity,
				paymentType, paymentCheck, shippingMessage, shippingStatus);
		
		/**
		 * 결제 페이지(shop_payment.jsp)에서 보여줄 정보 넣기
		 * 제품 가격, 배송비, 총 가격
		 */
		// 주문서에서 상품 정보를 가져옴
		orderInfo = orderService.selectOrderInfo(orderNo);
		int productNo = orderInfo.getProductNo();
		
		ProductService productService = ProductService.getInstance();
		Product product = productService.selectProduct(productNo);
		
//		System.out.println("productNo : " + productNo);
//		System.out.println("product" + product.toString());
		
		// 총 가격 계산
		subtotal = product.getProductPrice() * orderQuantity;
		request.setAttribute("subtotal", subtotal);
		
		// 총 가격이 5만원 미만일 경우 배송비 추가
		if (subtotal < 50000) {
			shippingPrice = 2500;
		}
		request.setAttribute("shippingPrice", shippingPrice);
		
		// forward 시킬 주소 설정
		String viewPath = "shop_payment.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
		
	}

}
