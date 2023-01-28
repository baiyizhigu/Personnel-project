package com.gec.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��������  
@WebFilter(filterName = "LoginFilter", urlPatterns = { "/*" })
public class LoginFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ����ת��
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String url = req.getServletPath();
		System.out.println(url);
		// ��session�л�ȡ��¼����
		Object login = req.getSession().getAttribute("now_login");
		// ����ͨ�����ص�·��
		if (url.equals("/staff_login.jsp") || url.contains("/assets/") || url.equals("/admin_login.jsp")
				|| url.equals("/StaffLogin") || url.equals("/AdminLogin")) {
			// System.out.println("ͨ������");
			chain.doFilter(request, response);
			return;
		}
		// 1���ж��û��Ƿ��¼��session��û��������ݡ�
		if (login == null) {
			// ��ת����¼ҳ�� http://localhost:8080/WebProject/login.jsp
			res.sendRedirect("staff_login.jsp");
			return;
		} else {
			System.out.println("ͨ������");
			chain.doFilter(request, response);
		}

	}

	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
