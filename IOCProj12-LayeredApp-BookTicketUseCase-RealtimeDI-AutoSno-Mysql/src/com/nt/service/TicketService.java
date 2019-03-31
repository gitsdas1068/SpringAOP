package com.nt.service;

import com.nt.dto.TicketDTO;

public interface TicketService {
	public  String generateResult(TicketDTO dto)throws Exception;
	public  String generateTotalFare(TicketDTO dto)throws Exception;

}
