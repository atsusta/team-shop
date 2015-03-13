package service;

import repository.CustomerDAO;
import vo.Customer;

public class CustomerService {
	private static CustomerService customerServiceInstance;
	
	private CustomerService() {
		// TODO Auto-generated constructor stub
	}
	
	public static CustomerService getInstance() {
		if (customerServiceInstance == null) {
			customerServiceInstance = new CustomerService();
		}
		
		return customerServiceInstance;
	}
	
	/**
	 * 고객 정보 추가
	 * @param customer
	 * @return
	 */
	public int insertCustomer(Customer customer) {
		CustomerDAO customerDao = CustomerDAO.getInstance();
		int sqlResult = customerDao.insertCustomer(customer);
		
		return sqlResult;
	}
	
	/**
	 * 아이디를 이용해 고객 정보 가져오기
	 * @param customerId
	 * @return
	 */
	public Customer selectCustomer(String customerId) {
		CustomerDAO customerDao = CustomerDAO.getInstance();
		Customer customer = customerDao.selectCustomer(customerId);
		
		return customer;
	}
}
