package com.nt.manager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.UserBO;
import com.nt.dao.AuthenticateDAO;
import com.nt.dto.UserDTO;

@Service("authManager")
public class AuthenticationManager {
	private ThreadLocal<UserDTO> threadLocal=new ThreadLocal();
	@Autowired
	private AuthenticateDAO dao;
	

	public  void signIn(String username,String pwd) {
		UserDTO dto=null;
		//create UserDTO class object
		dto=new UserDTO();
		dto.setUsername(username);
		dto.setPassword(pwd);
		//put in ThreadLocal
		threadLocal.set(dto);
	}
	
	public void signOut() {
		threadLocal.remove();
	}
	
	public boolean validate() {
		UserDTO dto=null;
		UserBO bo=null;
		int count=0;
		//get UserDTO obj from ThreadLocal
		dto=threadLocal.get();
		//Copy DTO obj to BO object
		bo=new UserBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.authenticate(bo);
		if(count==0)
			return false;
		else
			return true;
		
	}
	

}
