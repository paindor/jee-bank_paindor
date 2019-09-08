package com.bank.web.serviceimpls;

import com.bank.web.daoimpls.MemberDAOImpl;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService {

	MemberDAO dao;
	
	public MemberServiceImpl() {
		dao = new MemberDAOImpl();
		
	}
	@Override
	public void join(CustomerBean param) {
		dao.insertCustomer(param);
		
	}

	@Override
	public void register(EmployeeBean param) {
		 
		
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		CustomerBean cus = new CustomerBean();
		cus = dao.login(param);
		return cus;
	}

}
