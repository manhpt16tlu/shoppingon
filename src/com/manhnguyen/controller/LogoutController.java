package com.manhnguyen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manhnguyen.model.Contants;

public class LogoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {
			// xóa cookie pass
			if (c.getName().equals(Contants.COOKIE_PASS)) {
				c.setValue("");
				c.setMaxAge(0);
				resp.addCookie(c);
			}
		}
		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
