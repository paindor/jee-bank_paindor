package com.bank.web.services;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;

public interface MemberService {

	public void join(CustomerBean param);
	public void register(EmployeeBean param);
	public CustomerBean login(CustomerBean param);
	
	
	
	
	
	
}
