package com.manhnguyen.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manhnguyen.libs.MD5;
import com.manhnguyen.model.Contants;
import com.manhnguyen.model.User;
import com.manhnguyen.service.UserService;

public class RegisterController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String pass = MD5.getMD5(req.getParameter("password"));
		User u = User.builder().fullname(name).email(email).pass(pass).phone(phone).build();
		try {
			UserService.create(u);
			resp.sendRedirect(req.getRequestURI() + "?status=" + Contants.SUCCESS);
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			resp.sendRedirect(req.getRequestURI() + "?status=" + Contants.ERROR + "&value=" + Contants.SQL_ERROR_101);
		} catch (SQLException e) {
			e.printStackTrace();
			resp.sendRedirect(req.getRequestURI() + "?status=" + Contants.ERROR);
		}
	}

}
