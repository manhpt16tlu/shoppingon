package com.manhnguyen.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductCart {
	private int quantity;
	private Product product;

	public void increaseQuantity() {
		quantity++;
	}

}
