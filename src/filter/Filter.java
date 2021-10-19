package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import connection.SingleConnection;

@WebFilter(urlPatterns="/*")
public class Filter implements javax.servlet.Filter{

	private static Connection connection;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain filter)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		try {
			
			filter.doFilter(req, resp);
			connection.commit();
		}catch(Exception e) {
			try {
				e.printStackTrace();
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}		
	}

	@Override
	public void init(FilterConfig filter) throws ServletException {
		connection = SingleConnection.getConnection();
		
	}

}
