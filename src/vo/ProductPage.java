package vo;

import java.util.List;

public class ProductPage {
	private List<Product> productList; // 화면에 보여질 물품 목록
	private int startPage;
	private int endPage;
	private int totalPage;
	private int requestPage;

	public ProductPage() {

	}

	public ProductPage(List<Product> productList, int startPage, int endPage,
			int totalPage, int requestPage) {

		this.productList = productList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPage = totalPage;
		this.requestPage = requestPage;
	}

	public List<Product> getproductList() {
		return productList;
	}

	public void setproductList(List<Product> productList) {
		this.productList = productList;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}

}
