package com.basicservlet.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

// Annotation 방식으로 mapping 하기
//@WebServlet("/anno.do")
// 이렇게 바로 패턴등록 가능하다.
@WebServlet(name="annoservlet",urlPatterns ={"/anno.do"})
// 이름을 부여해서 패턴 등록이 가능하다.
public class AnnotationServlet  extends HttpServlet {
    private static final long serialVersionUID = 7194336576515816528L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServerException, IOException {

        System.out.println("어노테이션으로 연결되니?");
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out=res.getWriter();
        out.write("<html>");
        out.write("<body>");
        out.write("<h2>이건 Annotation 방식으로 처리한거야</h2>");
        out.write("</body>");
        out.write("</html>");
    }
}
