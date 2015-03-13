package util;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

// instance is used as Servlet
public class DriverLoader extends HttpServlet {
	@Override
	public void init(ServletConfig config) {
		// driver loading
		String driver = config.getInitParameter("jdbcDriver");
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("driver load error : " + driver);
			e.printStackTrace();
		}
	}
}
