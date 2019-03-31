package com.nt.beans;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AmoghaBillCounter {
	private Date date;
	private String billClerk;
	private int orderId;
	private List<String> orderItems;
	public int billAmount;
	private boolean isSpecialItemAvailable;
	
	

}
