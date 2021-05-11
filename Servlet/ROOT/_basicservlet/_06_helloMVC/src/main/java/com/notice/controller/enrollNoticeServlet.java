package com.notice.controller;

import com.notice.model.service.NoticeService;
import com.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "enrollNoticeServlet", value = "/notice/enrollNotice")
public class enrollNoticeServlet extends HttpServlet {
    private static final long serialVersionUID = -8714646858108587073L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 샘이한거
        // 파일 업로드 처리하기
        // cos.jar 라이브러리에서 제공하는 클래스를 이용해서 처리한다.
        // 1. 클라이언트가 form으로 보낸 데이터가 multipart 형식인지 확인하기

        if(!ServletFileUpload.isMultipartContent(request)){
            // 잘못된 요청
            request.setAttribute("msg","공지사항 작성오류 [form:enctype] 관리자에게 문의하세요");
            request.setAttribute("loc","/notice/noticeList");
            request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);
            return;
        }

        // 2. 파일 업로드 처리를 위한 필요한 값을 설정하기
        // 1) 파일 업로드 위치 -> 절대경로로 가져와야함s
//        String path = getServletContext().getRealPath("/upload/notice");
//        System.out.println(path);

        String path = "/Users/jang/Desktop/_basicservlet/_06_helloMVC/src/main/webapp/upload/notice";
        System.out.println(path +" 경로 1");

        // 2) 저장할 파일에 대한 최대크기 설정
        int maxSize=1024*1024*10; // 10MB 까지

        // 3) 문자열 인코딩
        String encode= "utf-8";

        // 4) 업로드된 파일에 대한 이름 재정의(rename)
        // 개발자가 직접 작성가능하고, 기본으로 제공하는 클래스가 있음(DefaultFileRenamePolicy)


        // 파일 업로드 하기
        // MultipartRequest 클래스를 생성-> request로 전송된 데이터가 지정한 경로에 저장
        // 5개의 매개변수가 필요함
        // 1. HttpServletRequest 2. 파일경로 3. 파일 최대크기 4. 인코딩 5. rename 규칙
        MultipartRequest mr = new MultipartRequest(request,path,maxSize,encode,new DefaultFileRenamePolicy());

        Notice n = new Notice();
        n.setNoticeTitle(mr.getParameter("title"));
        n.setNoticeContent(mr.getParameter("content"));
        n.setNoticeWriter(mr.getParameter("writer"));

        // 파일명을 DB에 저장해야함 -> rename된 파일을 가져오기
        n.setFilePath(mr.getFilesystemName("filePath"));


//        n.setNoticeTitle(request.getParameter("title"));
//        n.setFilePath(request.getParameter("filePath"));
//        n.setNoticeContent(request.getParameter("content"));
//        n.setNoticeWriter(request.getParameter("writer"));



        int result = new NoticeService().insertNotice(n);

//        // 내가한거
//        String title = request.getParameter("title");
//        String filePath =request.getParameter("filePath");
//        String content = request.getParameter("content");
//        String writer =request.getParameter("writer");
////        ((Member) session.getAttribute("loginMember")).getUserId();
//
//        int result = new NoticeService().enrollNotice(title, writer,filePath, content);

        String msg ="";
        String loc="";
        if(result>0){
            msg="공지가 등록되었습니다.";
            loc="/notice/noticeList";
        }else{
            msg="공지가 등록이 실패했습니다";
            loc="/notice/noticeForm";
        }

        request.setAttribute("msg",msg);
        request.setAttribute("loc",loc);
        request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
