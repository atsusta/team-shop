package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CustomerService;
import service.OrderService;
import service.ProductService;
import vo.Customer;
import vo.OrderInfo;
import vo.Product;

/**
 * Servlet implementation class OrderServlet
 * 상품 설명에서 바로 구매를 눌렀을 때
 * (장바구니에서 상품 주문을 눌렀을 때)
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 상품 설명 -> 바로 구매(장바구니) -!> 주문서 작성 -> 결제
		 * request object는 이전 단계와 결합
		 */
		Date orderDate = new Date();
		int orderQuantity = Integer.parseInt(
				request.getParameter("quantity"));
		String customerId = request.getParameter("customerId"); // 사용자 ID 어떻게 받을까
		int shippingPrice = 0;
		
		int productNo = Integer.parseInt(
				request.getParameter("productNo"));
		String productSize = request.getParameter("productSize");
		
		/**
		 * orderInfo 객체 세팅
		 * 상품 번호는 (상품 이름+상품 색상)을 통해 DB에서 가져옴 
		 * paymentType, paymentCheck, shippingMessage, shippingStatus는
		 * 결제 화면(CheckoutServlet)에서 정해짐.
		 */
		ProductService productService = ProductService.getInstance();
		Product product = productService.selectProduct(productNo);
		
		/**
		 * paymentType, paymentCheck, shippingMessage, shippingStatus는
		 * CheckoutServlet.java에서
		 */
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrderDate(orderDate);
		orderInfo.setOrderQuantity(orderQuantity);
		orderInfo.setCustomerId(customerId);
		orderInfo.setProductNo(productNo);
		orderInfo.setProductSize(productSize);
		orderInfo.setPaymentType("undefined");
		orderInfo.setPaymentCheck(false);
		
		// DB에 새로운 정보 넣기
		OrderService orderService = OrderService.getInstance();
		orderService.insertOrderInfo(orderInfo);
		
		/**
		 * 결제 화면(shop_checkout.jsp)에 들어갈 정보를 request 객채에 넣기
		 * Customer 객체는 사용자 id를 통해 DB에서 가져옴
		 */
		// 주문 상품 정보
		request.setAttribute("product", product);
		request.setAttribute("imgSrc", request.getParameter("imgSrc"));
		
		OrderInfo savedOrderInfo = orderService.selectLastestOrderInfo();
		request.setAttribute("orderInfo", savedOrderInfo);
		request.setAttribute("subtotal", 
				product.getProductPrice() * orderQuantity);
		
		// 주문자 정보
		CustomerService customerService = CustomerService.getInstance();
		Customer customer = customerService.selectCustomer(customerId);
		if (customer == null) {
			System.out.println("customer is null!");
		}
		request.setAttribute("customer", customer);
		
		String viewPath = "shop_checkout.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

}
