package com.manhnguyen.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manhnguyen.model.User;

public class UserService extends BaseService {
	public static User login(String email, String pass) throws SQLException {
		String sql = "select * from users where email = ? and pass = ?";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, email);
			ps.setString(2, pass);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User u = User.builder().fullname(rs.getString("fullname")).id(rs.getInt("id"))
							.email(rs.getString("email")).pass(rs.getString("pass")).phone(rs.getString("phone"))
							.build();
//					u.setEmail(rs.getString("email"));
//					u.setPass(rs.getString("pass"));
//					u.setId(rs.getInt("id"));
//					u.setFullname(rs.getString("fullname"));
//					u.setPhone(rs.getString("phone"));
					System.out.println("login user " + u.toString());
					return u;
				}
			}
		}
		return null;

	}

	public static void create(User u) throws SQLException {
		String sql = "insert into users(fullname,email,pass,phone) values (?,?,?,?)";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, u.getFullname());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPass());
			ps.setString(4, u.getPhone());
			ps.executeUpdate();
			System.out.println("create user " + u.toString());
		}
	}
}
