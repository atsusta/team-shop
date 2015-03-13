package service;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import repository.ProductDAO;
import vo.Product;
import vo.ProductPage;

public class ProductService {
	private static ProductService productServiceInstance;
	
	private ProductService() {
		// TODO Auto-generated constructor stub
	}
	
	public static ProductService getInstance() {
		if (productServiceInstance == null) {
			productServiceInstance = new ProductService();
		}
		
		return productServiceInstance;
	}
	
	public static final int COUNT_PER_PAGE = 10;
	
	public Product selectProduct(int productNo) {
		ProductDAO productDao = ProductDAO.getInstance();
		Product product = productDao.selectProduct(productNo);
		
		if (product == null) {
			System.out.println("select product error");
		}
		
		return product;
	}

//	public int selectProductNo(String productName, String productColor) {
//		// TODO Auto-generated method stub
//		ProductDAO productDao = ProductDAO.getInstance();
//		
//		Product product = productDao.selectProduct(productName, productColor);
//		
//		if (product == null) {
//			System.out.println("select product number error");
//		}
//		
//		return product.getProductNo();
//	}
	
	public ProductPage getProductPage(HttpServletRequest request) {
		String pageStr = request.getParameter("page");
		
		/**
		 * �� ��ǰ����Ʈ������
		 * top, bottom, outer �������� �����ϱ� ����.
		 */
		String category = request.getParameter("type");

		int requestPage = 1;
		if (pageStr != null)
			requestPage = Integer.parseInt(pageStr);

		ProductDAO dao = ProductDAO.getInstance();

		int totalPage = 0;
		int totalCategoryPage = 0;
		int startPage = 0;
		int endPage = 0;

		int totalProductCount = 0;
		int totalCategoryProductCount = 0;

		List<Product> productList = null;

		if (category == null || category.equals("all")) {
			// �� ��ǰ�� �� DB���� ��ȸ
			totalProductCount = dao.selectCount();
			if (totalProductCount == 0) {
				return new ProductPage(Collections.<Product> emptyList(), 0, 0,
						0, 0);
			}

			// �� �������� ���
			totalPage = totalProductCount / COUNT_PER_PAGE;
			if (totalProductCount % COUNT_PER_PAGE != 0) {
				totalPage++;
			}

			// startPage ���
			startPage = requestPage - 4;
			if (startPage < 1)
				startPage = 1;

			// endPage ���
			endPage = requestPage + 5;
			if (endPage > totalPage)
				endPage = totalPage;

			int startRow = (requestPage - 1) * COUNT_PER_PAGE;
			productList = dao.selectProductList(startRow, COUNT_PER_PAGE);
			
			return new ProductPage(productList, startPage, endPage, totalPage,
					requestPage);
		} else {
			// category���ÿ� ���� ��ǰ�� �� DB���� ��ȸ
			totalCategoryProductCount = dao
					.selectCategoryProductCount(category);
			if (totalCategoryProductCount == 0) {
				return new ProductPage(Collections.<Product> emptyList(), 0, 0,
						0, 0);
			}

			// �� �������� ���
			totalCategoryPage = totalCategoryProductCount / COUNT_PER_PAGE;
			if (totalCategoryProductCount % COUNT_PER_PAGE != 0) {
				totalCategoryPage++;
			}

			// startPage ���
			startPage = requestPage - 4;
			if (startPage < 1)
				startPage = 1;

			// endPage ���
			endPage = requestPage + 5;
			if (endPage > totalCategoryPage)
				endPage = totalCategoryPage;

			int startRow = (requestPage - 1) * COUNT_PER_PAGE;
			productList = dao.selectCategoryProductList(startRow,
					COUNT_PER_PAGE, category);

			return new ProductPage(productList, startPage, endPage, totalPage,
					requestPage);
		}

	}

	public Product productView(HttpServletRequest request) {
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		ProductDAO dao = ProductDAO.getInstance();
		Product product = dao.selectProduct(productNo);
		return product;
	}
	
}
