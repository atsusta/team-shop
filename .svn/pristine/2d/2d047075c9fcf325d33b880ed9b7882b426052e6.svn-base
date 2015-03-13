package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ProductService;
import vo.Product;
import vo.ProductPage;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req, resp);
	}

	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String type = request.getParameter("type");
		ProductService service = ProductService.getInstance();
		String containerPath = "index.jsp?CONTENT=";
		String targetPath = null;
		String viewPath = null;

		if (type == null || type.equals("all")) {
			// 모든 물품 보기 기능
			ProductPage productPage = service.getProductPage(request);
			request.setAttribute("productPage", productPage);
			request.setAttribute("list", "all_list.jsp");
			targetPath = "all_list.jsp";
		} else if (type.equals("top")) {
			ProductPage productPage = service.getProductPage(request);
			request.setAttribute("topProductPage", productPage);
			request.setAttribute("list", "top_list.jsp");
			targetPath = "top_list.jsp";
		} else if (type.equals("bottom")) {
			ProductPage productPage = service.getProductPage(request);
			request.setAttribute("bottomProductPage", productPage);
			request.setAttribute("list", "bottom_list.jsp");
			targetPath = "bottom_list.jsp";
		} else if (type.equals("outer")) {
			ProductPage productPage = service.getProductPage(request);
			request.setAttribute("outerProductPage", productPage);
			request.setAttribute("list", "outer_list.jsp");
			targetPath = "outer_list.jsp";
		} else if (type.equals("productDetailView")) {
			// 물품클릭시 물품상세페이지로 이동
			Product product = service.productView(request);
			request.setAttribute("product", product);
			request.setAttribute("list", "product_view.jsp");
			targetPath = "product_view.jsp";
		}
		
		viewPath = containerPath + targetPath; 

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

}
