package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBHelper;
import vo.Product;

public class ProductDAO {
	private static ProductDAO productDaoInstance;
	
	private ProductDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static ProductDAO getInstance() {
		if (productDaoInstance == null) {
			productDaoInstance = new ProductDAO();
		}
		
		return productDaoInstance;
	}
	
	/**
	 * DB�� ����� �� ��ǰ���� ���� ��ȸ
	 * @return
	 */
	public int selectCount() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = DBHelper.getConnection(0);
			String sql = "select count(*) from product";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getInt(1);

		} catch (SQLException e) {
			System.out.println("ProductDAO-selectCount Error :" + e);
		} finally {
			DBHelper.close(con);
			DBHelper.close(stmt);
			DBHelper.close(rs);
		}
		return result;
	}
	
	/**
	 * ī�װ��� ���� ����� ��ǰ ���� ��ȸ
	 * @param category
	 * @return
	 */
	public int selectCategoryProductCount(String category) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = DBHelper.getConnection(0);
			String sql = "select count(*) from product where product_category=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
			System.out.println(result);

		} catch (SQLException e) {
			System.out.println("ProductDAO-selectCategoryProductCount Error :"
					+ e);
		} finally {
			DBHelper.close(con);
			DBHelper.close(pstmt);
			DBHelper.close(rs);
		}
		return result;
	}
	
	/**
	 * ��ǰ ��ȣ�� ���� ���� ������
	 * @param productNo
	 * @return
	 */
	public Product selectProduct(int productNo) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Product product = null;
		
		try {
			connection = DBHelper.getConnection(0);
			String sql = "select * from product "
					+ "where product_no = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productNo);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				product = new Product();
				product.setProductNo(
						resultSet.getInt("product_no"));
				product.setProductName(
						resultSet.getString("product_name"));
				product.setProductColor(
						resultSet.getString("product_color"));
				product.setProductPrice(
						resultSet.getInt("product_price"));
				product.setProductImage(
						resultSet.getString("product_image"));
				product.setProductContent(
						resultSet.getString("product_content"));
				product.setProductDetail(
						resultSet.getString("product_detail"));
				product.setProductCategory(
						resultSet.getString("product_category"));
				product.setProductStock(
						resultSet.getInt("product_stock"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	
	}
	
//	/**
//	 * ��ǰ ���� ������
//	 * @param productName
//	 * @param productColor
//	 * @return
//	 */
//	public Product selectProduct(String productName, String productColor) {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		Product product = null;
//		
//		try {
//			connection = DbHelper.getConnection();
//			String sql = "select * from product "
//					+ "where product_name = ? and product_color = ?";
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, productName);
//			preparedStatement.setString(2, productColor);
//			
//			resultSet = preparedStatement.executeQuery();
//			
//			if (resultSet.next()) {
//				product = new Product();
//				product.setProductNo(resultSet.getInt("product_no"));
//				product.setProductName(resultSet.getString("product_name"));
//				product.setProductColor(resultSet.getString("product_color"));
//				product.setProductPrice(resultSet.getInt("product_price"));
//				product.setProductImage(resultSet.getString("product_image"));
//				product.setProductContent(resultSet.getString("product_content"));
//				product.setProductDetail(resultSet.getString("product_detail"));
//				product.setProductCategory(resultSet.getString("product_category"));
//				product.setProductStock(resultSet.getInt("product_stock"));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return product;
//	}
	
	/**
	 * �� ��ǰ �������� �ε��ϴ� �޼ҵ�
	 * @param firstRow
	 * @param count
	 * @return
	 */
	public List<Product> selectProductList(int firstRow, int count) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> result = new ArrayList<Product>();

		try {
			con = DBHelper.getConnection(0);
			String sql = "select * from product "
					+ "order by product_no desc limit ?,?";
			// category�� �����Ͽ� �������� ��� sql

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("product_name"));
				product.setProductCategory(rs.getString("product_category"));
				product.setProductColor(rs.getString("product_color"));
				product.setProductContent(rs.getString("product_content"));
				product.setProductImage(rs.getString("product_image"));
				product.setProductDetail(rs.getString("product_detail"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
				product.setProductNo(rs.getInt("product_no"));
				result.add(product);
			}
		} catch (SQLException e) {
			System.out.println("ProductDAO=selectProductList Error : " + e);
		} finally {
			DBHelper.close(con);
			DBHelper.close(pstmt);
			DBHelper.close(rs);
		}
		return result;

	}
	
	/**
	 * category ���ÿ� ���� 
	 * top, bottom, outer ��ǰ ����Ʈ�� �ҷ����� �޼ҵ�
	 * @param firstRow
	 * @param count
	 * @param category
	 * @return
	 */
	public List<Product> selectCategoryProductList(int firstRow, int count,
			String category) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> result = new ArrayList<Product>();

		try {
			con = DBHelper.getConnection(0);
			String sql = "select * from product where product_category=? "
					+ "order by product_no desc limit ?,?";
			// category�� �����Ͽ� �������� ��� sql

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setInt(2, firstRow);
			pstmt.setInt(3, count);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("product_name"));
				product.setProductCategory(rs.getString("product_category"));
				product.setProductColor(rs.getString("product_color"));
				product.setProductContent(rs.getString("product_content"));
				product.setProductImage(rs.getString("product_image"));
				product.setProductDetail(rs.getString("product_detail"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
				product.setProductNo(rs.getInt("product_no"));
				result.add(product);

			}
		} catch (SQLException e) {
			System.out.println("ProductDAO=selectProductList Error : " + e);
		} finally {
			DBHelper.close(con);
			DBHelper.close(pstmt);
			DBHelper.close(rs);
		}
		return result;

	}
	
	/**
	 * ��ǰ ���� �߰��ϱ�
	 * @param product
	 * @return
	 */
	public int insertProduct(Product product) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int sqlResult = 0;
		
		try {
			connection = DBHelper.getConnection(0);
			String sql = "insert into product ("
					+ "product_name, product_color, product_price, "
					+ "product_image, product_content, product_detail, "
					+ "product_category, product_stock) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setString(2, product.getProductColor());
			preparedStatement.setInt(3, product.getProductPrice());
			preparedStatement.setString(4, product.getProductImage());
			preparedStatement.setString(5, product.getProductContent());
			preparedStatement.setString(6, product.getProductDetail());
			preparedStatement.setString(7, product.getProductCategory());
			preparedStatement.setInt(8, product.getProductStock());
			
			sqlResult = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(preparedStatement);
			DBHelper.close(connection);
		}
		
		return sqlResult;
	}
	
	/**
	 * ��ǰ ���� �����ϱ�
	 * @param productName
	 * @param productColor
	 * @return
	 */
	public int deleteProduct(String productName, String productColor) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int sqlResult = 0;
		
		try {
			connection = DBHelper.getConnection(0);
			String sql = "delete from product "
					+ "where product_name = ? and product_color = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			preparedStatement.setString(2, productColor);
			
			sqlResult = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(preparedStatement);
			DBHelper.close(connection);
		}
		
		return sqlResult;
	}
	
}
