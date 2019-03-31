package com.nt.controller;

import com.nt.dto.TicketDTO;
import com.nt.service.TicketService;
import com.nt.vo.TicketVO;

public final class MainController {
	private TicketService service;

	public MainController(TicketService service) {
	
		this.service = service;
	}
	
	public String processTicket(TicketVO vo)throws Exception{
		TicketDTO dto=null;
		String result=null;
		//Convert VO class obj data to DTO class object
		dto=new TicketDTO();
		dto.setSname(vo.getSname());
		dto.setSadd(vo.getSadd());
		dto.setM1((vo.getFare()));
		dto.setM2((vo.getTotal()));
		dto.setM3((vo.getTrainNumber()));
		//use Service class object
		result=service.generateResult(dto);
		return result;
	}
	public String getTotalTrainFare(TicketVO vo)throws Exception{
		TicketDTO dto=null;
		String result=null;
		//Convert VO class obj data to DTO class object
		dto=new TicketDTO();
		dto.setSname(vo.getSname());
		dto.setSadd(vo.getSadd());
		dto.setM1((vo.getFare()));
		dto.setM2((vo.getTotal()));
		dto.setM3((vo.getTrainNumber()));
		//use Service class object
		result=service.generateTotalFare(dto);
		return result;
	}
}
