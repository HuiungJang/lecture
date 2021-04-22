package com.listener.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contexttest.do")
public class ContextListenerTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContextListenerTestServlet() {
        super();

    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//context에 값 추가하기
		ServletContext context=request.getServletContext();
		context.setAttribute("data", "데이터입력!");
		context.setAttribute("data", "호호호호");
		context.removeAttribute("data");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
