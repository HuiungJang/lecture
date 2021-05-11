package com.notice.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "NoticeFileDownloadServlet", value = "/notice/fileDownload")
public class NoticeFileDownloadServlet extends HttpServlet {
    private static final long serialVersionUID = -2887268436260063514L;
    // 파일 다운로드 서비스
    // 1. 클라이언트가 보낸 파일명 가져오기
    // 2. 파일명이랑 일치하는 파일 서버의 저장경로에서 가져오기 -> InputStream 사용
    // 3. 클라이언트에게 보낼 파일명 인코딩하기 -> 한글 파일명 깨지지 않게
    // 4. 파일 MIME 타입 설정하기 / header 설정
    // 5. 클라이언트와 연결된 스트림으로 파일전송
    // 6. 스트림 닫기

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 파일명 가져오기
        String fileName = request.getParameter("fname");

        // 저장경로 가져오기
//        String path = getServletContext().getRealPath("/upload/notice/");
//        String path = "/Users/jang/Desktop/_basicservlet/_06_helloMVC/src/main/webapp/upload/notice";
//        String path = request.getContextPath()+"/upload/notice/";
        String path ="/Users/jang/Desktop/_basicservlet/_06_helloMVC/src/main/webapp/upload/notice/";
        String filePath = path+fileName;



        // 파일경로에서 파일 가져옴
        FileInputStream fis = new FileInputStream(filePath);
        BufferedInputStream bis = new BufferedInputStream(fis);

        // 파일명에 대한 인코딩처리
        String fileRname= "";
        String header= request.getHeader("user-agent");

        // ms 익스플로러 이면
        boolean isMSIE = header.indexOf("MSIE") != -1 || header.indexOf("Trident") != -1;
        if(isMSIE){
            fileRname = URLEncoder.encode(fileName,"utf-8").replaceAll("\\+","%20");

        }else{
            fileRname= new String(fileName.getBytes("utf-8"),"ISO_8859_1");;
        }


        // 응답 메세지 작성
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename="+fileRname);

        // 클라이언트에게 보낼 스트림 열기
        ServletOutputStream sos = response.getOutputStream();
        BufferedOutputStream bos= new BufferedOutputStream(sos);

        int read = -1; // 임의의 값을 넣는다.

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
