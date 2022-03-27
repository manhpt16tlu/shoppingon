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

import com.manhnguyen.model.Order;
import com.manhnguyen.model.OrderDetail;
import com.manhnguyen.model.Product;
import com.manhnguyen.model.ProductCart;
import com.manhnguyen.service.OrderDetailService;
import com.manhnguyen.service.OrderService;

public class CheckoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getPathInfo() == null ? "/" : req.getPathInfo();
		switch (action) {
		case "/result":
			checkoutResult(req, resp);
			return;
		default:
			checkoutDefault(req, resp);
			return;
		}
	}

	private void checkoutDefault(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setAttribute("totalAmount", totalCalc(req));
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/checkout.jsp");
		dispatcher.forward(req, resp);

	}

	private void checkoutResult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/checkout_result.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String customer_name = req.getParameter("name");
		String customer_phone_number = req.getParameter("phone");
		String customer_address = req.getParameter("address");
		String order_note = req.getParameter("note");

		// lấy ngày hiện tại
		long millis = System.currentTimeMillis();
		java.sql.Date currentDate = new java.sql.Date(millis);

		// tính tiền
		float totalAmount = totalCalc(req);
		Order o = Order.builder().user_id(2).customer_name(customer_name).customer_address(customer_address)
				.customer_phone_number(customer_phone_number).time_order(currentDate).order_note(order_note)
				.total_amount(totalAmount).build();

		HttpSession session = req.getSession();
		try {
			int order_id = OrderService.add(o);
			// lấy từng sản phẩm trong cart
			HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
			if (cart != null) {
				for (Map.Entry<Integer, ProductCart> entry : cart.entrySet()) {
					// lấy từng sản phẩm trong cart session
					OrderDetail od = OrderDetail.builder().order_id(order_id).product_id(entry.getKey())
							.product_quantity(entry.getValue().getQuantity())
							.current_product_price(entry.getValue().getProduct().getProduct_price()).build();
					OrderDetailService.add(od);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/checkout/result?status=fail");
			return;
		}
		session.setAttribute("cart", null); // tương đương session removeAttribute()
		resp.sendRedirect(req.getContextPath() + "/checkout/result?status=success");
	}

	private float totalCalc(HttpServletRequest req) {
		float totalAmount = 0;
		HttpSession session = req.getSession();
		HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
		if (cart != null) {
			for (Map.Entry<Integer, ProductCart> entry : cart.entrySet()) {
				Product p = entry.getValue().getProduct();
				int quan = entry.getValue().getQuantity();
				totalAmount += p.getProduct_price() * quan;// tính tiền
			}
		}
		return totalAmount;
	}

}
