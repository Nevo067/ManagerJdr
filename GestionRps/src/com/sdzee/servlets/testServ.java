package com.sdzee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.beans.Utilisateur;

public class testServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		Utilisateur ut = new Utilisateur("kevin","1111");
		
		req.setAttribute("ut", ut);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Incription.jsp").forward(req, resp);
		//super.doGet(req, resp);
	}
}
