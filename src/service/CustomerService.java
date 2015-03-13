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
	 * �� ���� �߰�
	 * @param customer
	 * @return
	 */
	public int insertCustomer(Customer customer) {
		CustomerDAO customerDao = CustomerDAO.getInstance();
		int sqlResult = customerDao.insertCustomer(customer);
		
		return sqlResult;
	}
	
	/**
	 * ���̵� �̿��� �� ���� ��������
	 * @param customerId
	 * @return
	 */
	public Customer selectCustomer(String customerId) {
		CustomerDAO customerDao = CustomerDAO.getInstance();
		Customer customer = customerDao.selectCustomer(customerId);
		
		return customer;
	}
}
