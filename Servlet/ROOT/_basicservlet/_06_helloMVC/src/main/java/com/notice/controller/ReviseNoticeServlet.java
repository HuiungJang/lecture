package com.notice.controller;

import com.notice.model.service.NoticeService;
import com.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ReviseNoticeServlet", value = "/notice/reviseNotice")
public class ReviseNoticeServlet extends HttpServlet {
    private static final long serialVersionUID = -4045683822711734980L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        내가한 수정 로직
//        request.setCharacterEncoding("utf-8");
//
//        int contentNo = Integer.parseInt(request.getParameter("noticeNo"));
//        String title = request.getParameter("title");
//
//        String filePath ="";
//        try {
//            filePath = request.getParameter("filePath");
//        }catch(NullPointerException e){
//            filePath="";
//        }
//        String content = request.getParameter("content");
//
//        int result= new NoticeService().reviseNotice(contentNo,title,filePath,content);
//
//        request.setAttribute("msg",result>0?"공지가 수정되었습니다.":"공지가 수정되지 않았습니다.");
//        request.setAttribute("loc","/");
//        request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);

        // 파일을 처리하는 수정로직.
        if(!ServletFileUpload.isMultipartContent(request)){
            request.setAttribute("msg","잘못된 접근입니다.");
            request.setAttribute("loc","/notice/moveRevise?noticeNo="+request.getParameter("noticeNo"));
            request.getRequestDispatcher("/views/common/msg.jsp").forward(request,response);

            return;
        }

        // 파일이 저장된 경로
        // maven이라 어쩔 수 없이 이렇게 씀
//        이클립스로 다이나믹 웹프로젝트 경로 설정시
//        String path = getServletContext().getRealPath("/upload/notice");

        String path="/Users/jang/Desktop/_basicservlet/_06_helloMVC/src/main/webapp/upload/notice/";
        int maxSize = 1024*1024*10;
        MultipartRequest mr = new MultipartRequest(request,path,maxSize,"utf-8",new DefaultFileRenamePolicy());

        Notice n = new Notice();
        n.setNoticeTitle(mr.getParameter("title"));
        n.setNoticeWriter(mr.getParameter("writer"));
        n.setNoticeContent(mr.getParameter("content"));
        String filePath= mr.getFilesystemName("filePath");

        // 파일이 있는지 없는지 확인해야함
        // File 객체를 이용한다.
        File f = mr.getFile("filePath");

        // f가 null 이면, file.length()==0 -> 파일이 없다.
        // null 이 아니고 file.length() >0 -> 파일이 있다.
        if( f != null & f.length() >0){
            // 새로 추가된 파일이 있음
            // 이전 파일을 지워준다.
            File deleteFile = new File(path+mr.getParameter("oldFile"));
//            if(deleteFile.exists()){
                System.out.println(deleteFile.delete());
                // if문에 넣어도 되고 안넣어도 된다 -> t f 가 나오니가

//            }
        }else{
            filePath = mr.getParameter("oldFile");
        }

        n.setFilePath(filePath);
        n.setNoticeNo(Integer.parseInt(mr.getParameter("noticeNo")));

        int result = new NoticeService().reviseNotice(n);

        String msg="";
        String loc="";
        if(result>0){
            msg="공지사항 수정 성공";
            loc="/notice/noticeList";
        }else{
            msg="공지사항 수정 실패";
            loc="/";
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
