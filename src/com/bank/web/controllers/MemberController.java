package com.bank.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.command.Receiver;
import com.bank.web.command.Sender;
import com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerBean param;
	MemberService service;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		param = new CustomerBean();
		service = new MemberServiceImpl();

		Receiver.init(request);

		// Receiver.init(request);
		Receiver.cmd.execute();
		if(Receiver.cmd.getAction() == null) {
			Receiver.cmd.setPage();
			
		}
		switch(Receiver.cmd.getAction()) {
		case "join":
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");
			param.setId(id);
			param.setPw(pw);
			param.setName(name);
			param.setSsn(ssn);
			param.setCredit(credit);
			service.join(param);
			Receiver.cmd.setPage();
			
			break;
		case "login":
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			param.setId(id);
			param.setPw(pw);
			CustomerBean result = service.login(param);
			System.out.println("컨트롤러" +result.getId());
			if(result.getId() == null) {
				Receiver.cmd.setPage("login");
				System.out.println("컨트롤러페이지"+Receiver.cmd.getPage());
			}else {
				Receiver.cmd.setPage("mypage");
			}
			System.out.println("컨트롤러 로그인" + Receiver.cmd.getPage());
			System.out.println("컨트롤러 로그인" + Receiver.cmd.getView());
			
			request.setAttribute("customer", result);
			System.out.println("컨트롤러 로그인" + Receiver.cmd.getPage());
			System.out.println("컨트롤러 로그인" + Receiver.cmd.getView());
			
			break;
			
		}
		Sender.forward(request, response);
		

	
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
