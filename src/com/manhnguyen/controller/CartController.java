package com.manhnguyen.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manhnguyen.model.Contants;
import com.manhnguyen.model.Product;
import com.manhnguyen.model.ProductCart;
import com.manhnguyen.service.ProductService;

public class CartController extends HttpServlet {
	// handle get request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionString = req.getPathInfo() == null ? "/" : req.getPathInfo();
		switch (actionString) {
		case "/":
			show(req, resp);// xem các sản phẩm trong giỏ hàng
			return;
		case "/remove":
			remove(req, resp);
			return;
		default:
			break;
		}
		resp.sendRedirect(req.getContextPath() + "/home");
	}

	// xóa sản phẩm trong cart
	private void remove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("remove item in cart");

		int productID = -1;
		try {
			productID = Integer.parseInt(req.getParameter("productID"));
		} catch (NumberFormatException e) {
		}
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
		if (cart != null) {
			if (cart.containsKey(productID)) {
				cart.remove(productID);
			}
		}
		resp.sendRedirect(req.getContextPath() + "/cart");
	}

	// xem toàn bộ giỏ hàng
	private void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		float totalAmount = 0;
		HttpSession session = req.getSession();
		session.setAttribute("urlHistory", req.getRequestURI());
		HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
		if (cart != null) {
			for (Map.Entry<Integer, ProductCart> entry : cart.entrySet()) {
				Product p = entry.getValue().getProduct();
				int quan = entry.getValue().getQuantity();
				totalAmount += p.getProduct_price() * quan;// tính tiền
			}
		}
		req.setAttribute("totalAmount", totalAmount);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/cart.jsp");
		dispatcher.forward(req, resp);
	}

	// post request
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionString = req.getPathInfo();
//		System.out.println(actionString);
		switch (actionString) {
		case "/add-to-cart":
			addToCart(req, resp);
			return;
		case "/update-quantity":
			updateQuantity(req, resp);
			return;
		default:
			break;
		}
	}

	// thay đổi quantity của product
	private void updateQuantity(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int productID = -1;
		int productQuantity = -1;
		try {
			productID = Integer.parseInt(req.getParameter("productID"));
			productQuantity = Integer.parseInt(req.getParameter("productQuantity"));

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
		if (cart != null) {
			if (cart.containsKey(productID)) {
				cart.get(productID).setQuantity(productQuantity);
			}

		}
		resp.sendRedirect(req.getContextPath() + "/cart");
	}

	// handle thêm sản phẩm vào cart
	private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		int productID = -1;
		ProductCart productCart = null;
		Product p = null;
		try {
			productID = Integer.parseInt(req.getParameter("productID"));
			p = ProductService.find(productID);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("unchecked")
		HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<Integer, ProductCart>();
			productCart = new ProductCart(1, p);
			cart.put(productID, productCart);
		} else {
			if (cart.containsKey(productID)) {
				productCart = cart.get(productID);
				productCart.increaseQuantity();
			} else {
				productCart = new ProductCart(1, p);
				cart.put(productID, productCart);
			}

		}
		session.setAttribute("cart", cart);// có thể k set lại session
		session.setAttribute("addToCartResult", Contants.SUCCESS);
		resp.sendRedirect((String) session.getAttribute("urlHistory"));
	}

}
