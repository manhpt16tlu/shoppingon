package com.manhnguyen.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manhnguyen.model.Category;
import com.manhnguyen.model.Product;
import com.manhnguyen.service.CategoryService;
import com.manhnguyen.service.ProductService;

public class HomeController extends HttpServlet {
	private static final int lim = 2;// giới hạn số record

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Category> categories = null;
		ArrayList<Product> products = null;
		int category = -1;
		int page = 1;
		int totalPage = 0;
		int totalRecord = 0;

		// handle phân trang
		try {
			page = Integer.parseInt(req.getParameter("page"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		// handle lọc danh mục
		try {
			category = Integer.parseInt(req.getParameter("category"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		try {
			categories = CategoryService.getAll();
			if (category < 0)
				products = ProductService.getAll(lim, page);
			else
				products = ProductService.getAll(category, lim, page);

			if (category < 0)
				totalRecord = ProductService.totalRecord();
			else
				totalRecord = ProductService.totalRecord(category);
			if (totalRecord == 0)
				totalPage = 1;
			else
				totalPage = (int) Math.ceil((double) totalRecord / lim);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("categories", categories);
		req.setAttribute("products", products);
		req.setAttribute("totalRecord", totalRecord);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("activePage", page);
		HttpSession session = req.getSession();
		session.setAttribute("urlHistory",
				req.getRequestURI() + "?" + (req.getQueryString() == null ? "" : req.getQueryString()));
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}

}
