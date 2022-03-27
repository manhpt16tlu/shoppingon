package com.manhnguyen.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.manhnguyen.model.Category;

public class CategoryService extends BaseService {
	public static ArrayList<Category> getAll() throws SQLException {

		ArrayList<Category> categories = new ArrayList<Category>();
		String sql = "select * from categories";
		try (Connection conn = getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("category_name");
				String desc = rs.getString("category_desc");
				Category c = new Category(id, name, desc);
				categories.add(c);
			}
		}

		return categories;

	}

}
