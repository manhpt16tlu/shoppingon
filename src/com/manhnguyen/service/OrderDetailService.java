package com.manhnguyen.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.manhnguyen.model.OrderDetail;

public class OrderDetailService extends BaseService {
	public static void add(OrderDetail x) throws SQLException {
		String sql = "insert into order_detail(order_id,product_id,product_quantity,current_product_price) values(?,?,?,?)";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, x.getOrder_id());
			ps.setInt(2, x.getProduct_id());
			ps.setInt(3, x.getProduct_quantity());
			ps.setFloat(4, x.getCurrent_product_price());
			ps.executeUpdate();
			System.out.println("add order detail : " + x.toString());

		}
	}
}
