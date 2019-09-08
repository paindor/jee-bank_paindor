package com.bank.web.daoimpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.pool.Constants;

public class MemberDAOImpl implements MemberDAO {

	private File file;
	public MemberDAOImpl() {
		file = new File(Constants.FILE_PATH + "member.txt");
	}
	@Override
	public void insertCustomer(CustomerBean param) {
		
		try {
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(param.getId() + "/" +
			param.getPw() + "/" + param.getName() + "/" + param.getSsn() + "/" + param.getCredit());
			writer.newLine();
			writer.flush();
			
			writer.close();
			
			
			
			
					
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerBean login(CustomerBean param) {
	
		
		CustomerBean cus = new CustomerBean();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String fr = reader.readLine();
			reader.close();
			String[] spl = fr.split("/");
			if(param.getId().equals(spl[0])) {
				cus.setId(spl[0]);
				cus.setPw(spl[1]);
				cus.setName(spl[2]);
				cus.setSsn(spl[3]);
				cus.setCredit(spl[4]);
				
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cus;
	}

}
