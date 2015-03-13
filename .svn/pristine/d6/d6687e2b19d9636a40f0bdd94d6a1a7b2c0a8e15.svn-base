package service;

import repository.OrderInfoDAO;
import vo.OrderInfo;

public class OrderService {
	private static OrderService orderServiceInstance;
	
	private OrderService() {
		// TODO Auto-generated constructor stub
	}
	
	public static OrderService getInstance() {
		if (orderServiceInstance == null) {
			orderServiceInstance = new OrderService();
		}
		
		return orderServiceInstance;
	}
	
	/**
	 * 주문 정보 추가
	 * @param orderInfo
	 * @return 가장 최근 주문 정보(=지금 주문한 정보)의 번호
	 */
	public int insertOrderInfo(OrderInfo orderInfo) {
		OrderInfoDAO orderInfoDao = OrderInfoDAO.getInstance();
		int sqlResult = orderInfoDao.insertOrderInfo(orderInfo);
		
		if (sqlResult == 0) {
			System.out.println("insert orderInfo error");
			return sqlResult;
		} else {
			return orderInfo.getOrderNo();
		}
		
	}
	
	/**
	 * 주문 정보 가져오기
	 * @param orderNo
	 * @return
	 */
	public OrderInfo selectOrderInfo(int orderNo) {
		OrderInfoDAO orderInfoDao = OrderInfoDAO.getInstance();
		OrderInfo orderInfo = orderInfoDao.selectOrderInfo(orderNo);

		if (orderInfo == null) {
			System.out.println("select orderInfo error");
		}
		
		return orderInfo;
	}

	 public OrderInfo selectLastestOrderInfo() {
		// TODO Auto-generated method stub
		OrderInfoDAO orderInfoDao = OrderInfoDAO.getInstance();
		OrderInfo orderInfo = orderInfoDao.selectLastestOrderInfo();
		
		if (orderInfo == null) {
			System.out.println("select lastestOrderInfo error");
		}
		
		return orderInfo;
	}
	
	
	/**
	 * 주문 정보에서 제품 수량을 바꿨을 경우 호출
	 * @param orderNo
	 * @param orderQuantity
	 */
	public void updateProduct(int orderNo, int orderQuantity,
			String paymentType, boolean paymentCheck, String shippingMessage, 
				String shippingStatus) {
		// TODO Auto-generated method stub
		OrderInfoDAO orderInfoDao = OrderInfoDAO.getInstance();
		int sqlResult = orderInfoDao.updateOrderInfo(orderNo, orderQuantity,
				paymentType, paymentCheck, shippingMessage, shippingStatus);
		
		if (sqlResult == 0) {
			System.out.println("update orderInfo quantity error");
		}
	}
	
}
