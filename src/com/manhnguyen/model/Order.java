package com.manhnguyen.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
	private int id;
	private int user_id;
	private String customer_name;
	private String customer_address;
	private String customer_phone_number;
	private Date time_order;
	private float total_amount;
	private String order_note;
}
