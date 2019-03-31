package com.nt.service;

import com.nt.bo.TicketBO;
import com.nt.dao.TicketDAO;
import com.nt.dto.TicketDTO;

public final class TicketServiceImpl implements TicketService {
	private TicketDAO  dao;

	public TicketServiceImpl(TicketDAO dao) {
		this.dao = dao;
	}

	@Override
	public String generateResult(TicketDTO dto) throws Exception {
		float total=0;
		float avg=0.0f;
		String result=null;
		TicketBO bo=null;
		int count=0;
		//write b.logic
		total=Float.parseFloat(dto.getM2())+Float.parseFloat(dto.getM2())*0.49f;
		
				//Prepare BO class obj having  persistable data
		bo=new TicketBO();
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		bo.setFare(dto.getM1());
		bo.setTotal(total+"".trim());
		bo.setTrainNumber(dto.getM3()+"");

		//use DAO
		count=dao.insert(bo);
		//process the reuslt
		if(count==0)
			return "Ticket Reservation  Failed :::  result   is-->"+count;
		else 
			return "Ticket Reservation completed:::  result   is-->"+count;
		
		
	}//method

	@Override
	public String generateTotalFare(TicketDTO dto) throws Exception {
		float total=0;
		TicketBO bo=new TicketBO();
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		bo.setFare(dto.getM1());
		bo.setTotal(total+"".trim());
		bo.setTrainNumber(dto.getM3()+"");
		String  fare=dao.getFare(bo);
		return fare;
	}

	
	
}//class
