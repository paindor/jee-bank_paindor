package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.pool.Constants;

public class Receiver {

	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		try {
			 cmd = new MoveCommand(request);
			 System.out.println("리시버" +cmd.getView());
			 System.out.println("리시버page" + cmd.getPage());
		} catch(Exception e) {e.printStackTrace();}
		
	}
	public static void setView(String page) {
		cmd.view = ( String.format(Constants.VIEW_PATH, cmd.getDomain(), page));
	}
}
