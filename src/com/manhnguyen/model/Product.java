package com.manhnguyen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private int id;
	private String product_name;
	private String avatar_url;
	private String product_desc;
	private float product_price;
	private int category_id;
	/*
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 * 
	 * public String getProduct_name() { return product_name; }
	 * 
	 * public void setProduct_name(String product_name) { this.product_name =
	 * product_name; }
	 * 
	 * public String getAvatar_url() { return avatar_url; }
	 * 
	 * public void setAvatar_url(String avatar_url) { this.avatar_url = avatar_url;
	 * }
	 * 
	 * public String getProduct_desc() { return product_desc; }
	 * 
	 * public void setProduct_desc(String product_desc) { this.product_desc =
	 * product_desc; }
	 * 
	 * public float getProduct_price() { return product_price; }
	 * 
	 * public void setProduct_price(float product_price) { this.product_price =
	 * product_price; }
	 * 
	 * public Product(int id, String product_name, String avatar_url, String
	 * product_desc, float product_price, int category_id) { this.id = id;
	 * this.product_name = product_name; this.avatar_url = avatar_url;
	 * this.product_desc = product_desc; this.product_price = product_price;
	 * this.category_id = category_id; }
	 * 
	 * public Product() { }
	 * 
	 * public int getCategory_id() { return category_id; }
	 * 
	 * public void setCategory_id(int category_id) { this.category_id = category_id;
	 * }
	 * 
	 * @Override public String toString() { return "Product [id=" + id +
	 * ", product_name=" + product_name + ", avatar_url=" + avatar_url +
	 * ", product_desc=" + product_desc + ", product_price=" + product_price + "]";
	 * }
	 */

}
