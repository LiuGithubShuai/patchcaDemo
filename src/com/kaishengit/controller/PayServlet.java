package com.kaishengit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/pay.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String money = req.getParameter("money");
		String code1 = req.getParameter("code1");
		
		HttpSession session = req.getSession();
		String sessionCode = (String) session.getAttribute("code");
		
		if(code1 != null && code1.equals(sessionCode)){
			session.removeAttribute("code");
			req.getRequestDispatcher("/WEB-INF/views/paysuccess.jsp").forward(req, resp);
		}else{
			req.setAttribute("message",	"�����ظ��ύ��");
			req.setAttribute("money", money);
			
			req.getRequestDispatcher("/WEB-INF/views/payerror.jsp").forward(req, resp);
		}
	}

}
