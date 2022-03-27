package com.manhnguyen.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manhnguyen.model.Image;
import com.manhnguyen.model.Product;

public class ProductService extends BaseService {

	public static ArrayList<Product> getAll() throws SQLException {
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "select * from products";
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("product_name");
				String avatar = rs.getString("avatar_url");
				String description = rs.getString("product_desc");
				float price = rs.getFloat("product_price");
				int category_id = rs.getInt("category_id");
				Product p = new Product(id, name, avatar, description, price, category_id);
				products.add(p);
			}
		}

		return products;
	}

	// lọc theo danh mục category
	public static ArrayList<Product> getAll(int categoryID) throws SQLException {
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "select * from products where category_id = ?";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, categoryID);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("product_name");
					String avatar = rs.getString("avatar_url");
					String description = rs.getString("product_desc");
					float price = rs.getFloat("product_price");
					int category_id = rs.getInt("category_id");
					Product p = new Product(id, name, avatar, description, price, category_id);
					products.add(p);
				}
			}
		}

		return products;
	}

	// kết hợp phân trang + lọc danh mục
	public static ArrayList<Product> getAll(int categoryID, int lim, int page) throws SQLException {
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "select * from products where category_id = ? limit ? offset  ?";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, categoryID);
			ps.setInt(2, lim);
			ps.setInt(3, (page - 1) * lim);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("product_name");
					String avatar = rs.getString("avatar_url");
					String description = rs.getString("product_desc");
					float price = rs.getFloat("product_price");
					int category_id = rs.getInt("category_id");
					Product p = new Product(id, name, avatar, description, price, category_id);
					products.add(p);
				}
			}
		}

		return products;
	}

	// phân trang
	public static ArrayList<Product> getAll(int lim, int page) throws SQLException {
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "select * from products limit ? offset  ?";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, lim);
			ps.setInt(2, (page - 1) * lim);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("product_name");
					String avatar = rs.getString("avatar_url");
					String description = rs.getString("product_desc");
					float price = rs.getFloat("product_price");
					int category_id = rs.getInt("category_id");
					Product p = new Product(id, name, avatar, description, price, category_id);
					products.add(p);
				}
			}
		}

		return products;
	}

	public static Product find(int id) throws SQLException {
		String sql = "select * from products where id = ?";
		Product p = null;
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					p = new Product();
					p.setId(id);
					p.setProduct_name(rs.getString("product_name"));
					p.setAvatar_url(rs.getString("avatar_url"));
					p.setProduct_desc(rs.getString("product_desc"));
					p.setProduct_price(rs.getFloat("product_price"));
					p.setCategory_id(rs.getInt("category_id"));
				}

			}

		}
		return p;

	}

	public static int totalRecord(int categoryID) throws SQLException {
		String sql = "select count(*) as total from products where category_id = ?";
		int totalRecord = 0;
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, categoryID);
			try (ResultSet rs = ps.executeQuery()) {
				rs.next();// luôn trả về giá trị , mặc định là 0
				totalRecord = rs.getInt("total");
			}

		}
		return totalRecord;

	}

	public static int totalRecord() throws SQLException {
		String sql = "select count(*) as total from products";
		int totalRecord = 0;
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				rs.next();// luôn trả về giá trị , mặc định là 0
				totalRecord = rs.getInt("total");
			}

		}
		return totalRecord;

	}

	public static List<Image> getImages(int id) throws SQLException {
		List<Image> images = new ArrayList<Image>();
		String sql = "select * from product_images where product_id = ?";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					int stt = rs.getInt("stt");
					int product_id = rs.getInt("product_id");
					String image_url = rs.getString("image_url");
					Image i = new Image(stt, product_id, image_url);
					images.add(i);
				}
			}
		}

		return images;
	}

}
