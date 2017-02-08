package com.tongniu.loan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AdminFilter implements Filter {
	private String contextPath;;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		contextPath = filterConfig.getServletContext().getContextPath();

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String uri = ((HttpServletRequest) request).getRequestURI().substring(contextPath.length());
		if ((!("/admin/loginPage".equals(uri) || "/admin/login".equals(uri)))
				&& (((HttpServletRequest) request).getSession().getAttribute("admin") == null
						&& ((HttpServletRequest) request).getSession().getAttribute("operator") == null)) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(
					"<script>alert('请先登录!!');window.location.href='" + contextPath + "/admin/loginPage'</script>");
			return;
		}
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
