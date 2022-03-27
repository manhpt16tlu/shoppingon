package com.manhnguyen.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.manhnguyen.model.Order;

public class OrderService extends BaseService {
	public static int add(Order o) throws SQLException {
		String sql = "insert into orders(user_id,customer_name,customer_address,customer_phone_number,time_order,total_amount,order_note) values(?,?,?,?,?,?,?)";
		int key = 0;
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {// return id khi
																										// insert record
																										// mới
			ps.setInt(1, o.getUser_id());
			ps.setString(2, o.getCustomer_name());
			ps.setString(3, o.getCustomer_address());
			ps.setString(4, o.getCustomer_phone_number());
			ps.setDate(5, o.getTime_order());
			ps.setFloat(6, o.getTotal_amount());
			ps.setString(7, o.getOrder_note());
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next())
					key = (int) rs.getLong(1);
			}
			System.out.println("add order : " + o.toString() + "with key : " + key);

		}
		return key;// trả về id của order dc thêm
	}

}
