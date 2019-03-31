package com.nt.dao;

import com.nt.bo.TicketBO;

public interface TicketDAO {
	public  int insert(TicketBO bo)throws Exception;
	public  String getFare(TicketBO bo)throws Exception;

}
