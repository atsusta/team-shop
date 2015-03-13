package vo;

import java.util.Date;

public class OrderInfo {
	private int orderNo;
	private Date orderDate;
	private int orderQuantity;
	private String customerId;
	private int productNo;
	private String productSize;
	private String paymentType;
	private boolean paymentCheck;
	private String shippingMessage;
	private String shippingStatus;
	
	public OrderInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderNo() {
		return orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public String getCustomerId() {
		return customerId;
	}

	public int getProductNo() {
		return productNo;
	}

	public String getProductSize() {
		return productSize;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public boolean isPaymentCheck() {
		return paymentCheck;
	}

	public String getShippingMessage() {
		return shippingMessage;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public void setPaymentCheck(boolean paymentCheck) {
		this.paymentCheck = paymentCheck;
	}

	public void setShippingMessage(String shippingMessage) {
		this.shippingMessage = shippingMessage;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	
	
}
