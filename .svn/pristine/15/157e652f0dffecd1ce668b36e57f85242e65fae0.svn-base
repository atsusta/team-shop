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
		 * 총 물품리스트페이지
		 * top, bottom, outer 페이지를 구분하기 위해.
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
			// 총 물품의 수 DB에서 조회
			totalProductCount = dao.selectCount();
			if (totalProductCount == 0) {
				return new ProductPage(Collections.<Product> emptyList(), 0, 0,
						0, 0);
			}

			// 총 페이지수 계산
			totalPage = totalProductCount / COUNT_PER_PAGE;
			if (totalProductCount % COUNT_PER_PAGE != 0) {
				totalPage++;
			}

			// startPage 계산
			startPage = requestPage - 4;
			if (startPage < 1)
				startPage = 1;

			// endPage 계산
			endPage = requestPage + 5;
			if (endPage > totalPage)
				endPage = totalPage;

			int startRow = (requestPage - 1) * COUNT_PER_PAGE;
			productList = dao.selectProductList(startRow, COUNT_PER_PAGE);
			
			return new ProductPage(productList, startPage, endPage, totalPage,
					requestPage);
		} else {
			// category선택에 의한 물품의 수 DB에서 조회
			totalCategoryProductCount = dao
					.selectCategoryProductCount(category);
			if (totalCategoryProductCount == 0) {
				return new ProductPage(Collections.<Product> emptyList(), 0, 0,
						0, 0);
			}

			// 총 페이지수 계산
			totalCategoryPage = totalCategoryProductCount / COUNT_PER_PAGE;
			if (totalCategoryProductCount % COUNT_PER_PAGE != 0) {
				totalCategoryPage++;
			}

			// startPage 계산
			startPage = requestPage - 4;
			if (startPage < 1)
				startPage = 1;

			// endPage 계산
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
