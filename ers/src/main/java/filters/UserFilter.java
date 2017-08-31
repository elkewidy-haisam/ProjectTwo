package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public class UserFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filtering request");
		HttpServletRequest req = (HttpServletRequest) request;
		
		// if null, they didn't login
		if(req.getSession().getAttribute("loggedInUser") == null){
			
			((HttpServletResponse) response).sendRedirect("login.jsp");
			
		}else{
			
			User user = (User)req.getSession().getAttribute("loggedInUser");
			System.out.println(user.getUsername());
			
			if(user.getRole_id() == 100){
				// proceed forward to the resource
				chain.doFilter(request, response);
			}else{
				
				((HttpServletResponse) response).setStatus(403); //forbidden
				((HttpServletResponse) response).sendRedirect("index.html");
				
			}
		}
	}
	
	@Override
	public void destroy() {}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Initializing Filter");
	}

	
	
}