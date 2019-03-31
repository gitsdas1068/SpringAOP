package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public final class StudentServiceImpl implements StudentService {
	private StudentDAO  dao;

	public StudentServiceImpl(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public String generateResult(StudentDTO dto) throws Exception {
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentBO bo=null;
		int count=0;
		//write b.logic
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(dto.getM1()>=35 && dto.getM2()>=35 && dto.getM3()>=35)
			result="PASS";
		else
			result="FAIL";
		//Prepare BO class obj having  persistable data
		bo=new StudentBO();
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use DAO
		count=dao.insert(bo);
		//process the reuslt
		if(count==0)
			return "Student Registration Failed :::  result   is-->"+result;
		else 
			return "Student Registration Succeded :::  result   is-->"+result;
		
		
	}//method
}//class
