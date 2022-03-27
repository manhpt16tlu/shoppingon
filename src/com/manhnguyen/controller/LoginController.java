package com.manhnguyen.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manhnguyen.libs.MD5;
import com.manhnguyen.model.Contants;
import com.manhnguyen.model.User;
import com.manhnguyen.service.UserService;

public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = MD5.getMD5(req.getParameter("password"));
		String remember = req.getParameter("remember");

		User u = null;
		try {
			u = UserService.login(email, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (u != null) {
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(60 * 60);
			session.setAttribute(Contants.USER_LOGGED, u);
			if (remember != null && remember.equals("remember")) {
				Cookie cookUserEmail = new Cookie(Contants.COOKIE_EMAIL, u.getEmail());
				Cookie cookUserPass = new Cookie(Contants.COOKIE_PASS, req.getParameter("password"));// chưa mã hóa
				cookUserEmail.setMaxAge(60 * 60 * 24);
				cookUserPass.setMaxAge(60 * 60 * 24);
				resp.addCookie(cookUserEmail);
				resp.addCookie(cookUserPass);
			}
			System.out.println("login success");
			resp.sendRedirect(req.getContextPath() + "/home");
		} else {
			System.out.println("login fail");
			req.setAttribute(Contants.MESSAGE_LOGIN_ERROR, "Email or password incorrect");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
