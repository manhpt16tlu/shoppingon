package com.manhnguyen.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manhnguyen.model.Image;
import com.manhnguyen.model.Product;
import com.manhnguyen.service.ProductService;

public class ProductDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		if (req.getParameter("productID") != null) {
			try {
				int id = Integer.parseInt(req.getParameter("productID"));
				session.setAttribute("urlHistory", req.getRequestURI() + "?productID=" + id);
				Product p = ProductService.find(id);
				List<Image> images = ProductService.getImages(id);
				req.setAttribute("product", p);
				req.setAttribute("images", images);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/detail.jsp");
				dispatcher.forward(req, resp);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
