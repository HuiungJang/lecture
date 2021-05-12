package com.board.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "BoardFileDownloadServlet", value = "/board/filedownload")
public class BoardFileDownloadServlet extends HttpServlet {
    private static final long serialVersionUID = -9134396514787613881L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rename = request.getParameter("rename");
        String oriname = request.getParameter("oriname");

        String path = "/Users/jang/Desktop/_basicservlet/_06_helloMVC/src/main/webapp/upload/board/";

//        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path+rename));


        // 한글 인코딩
        String header=request.getHeader("user-agent");
//        boolean isMSIE = header.indexOf("MSIE") != -1 || header.indexOf("Trident") != -1;
        boolean isMSIE = header.contains("MSIE") || header.contains("Trident");
        String reFile="";

        if(isMSIE){
            reFile=URLEncoder.encode(oriname,"utf-8");
            reFile=oriname.replaceAll("\\+","%20");

//            reFile= URLEncoder.encode(oriname,"utf-8".replaceAll("\\+","%20"));
        }else{
            reFile= new String(oriname.getBytes("utf-8"),"ISO_8859_1");
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename="+reFile);

        ServletOutputStream sos = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(sos);

        int read =0;
        while((read= bis.read()) != -1 ){
            bos.write(read);
        }
        bis.close();
        bos.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
