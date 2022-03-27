package com.manhnguyen.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manhnguyen.model.Contants;
import com.manhnguyen.model.User;

public class LoginFilter implements MyHttpFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("filter login");
		String path = req.getServletPath();
		System.out.println(path);
		if (path.startsWith("/register") || path.startsWith("/login"))
			chain.doFilter(req, resp);
		else {
			HttpSession session = req.getSession(false);
			try {
				User u = (User) session.getAttribute(Contants.USER_LOGGED);
				if (u == null) {// chưa login
					resp.sendRedirect(req.getContextPath() + "/login");
					return;// end filter
				}
			} catch (NullPointerException e) {// ko có session
				e.printStackTrace();
				resp.sendRedirect(req.getContextPath() + "/login");
				return;// end filter
			}
			chain.doFilter(req, resp);// chuyển tiếp servlet đích
		}

	}
}
