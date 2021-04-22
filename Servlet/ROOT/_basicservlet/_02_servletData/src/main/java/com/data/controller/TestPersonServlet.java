package com.data.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "TestPersonServlet", value = "/testperson.do")
public class TestPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post 방식으로 전송된 데이터에 한글이 있는 경우 깨짐
        // 1. request 에  encoding 설정을 해줌
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 클라이언트가 보낸 파라미터 값 받아오기
        // 1. 기본 데이터 받기 : request.getParameter("key") -> 단일 값에 대해 가져올 때 사용
        String name = request.getParameter("name");

        // 전송받는 데이터는 모두 문자열로 받는다. -> 형변환 필요하다.
        int age = Integer.parseInt(request.getParameter("age"));
        double height = Double.parseDouble(request.getParameter("height"));
        String color = request.getParameter("color");

        // 전송되는 데이터가 다중값일때
        // request.getParameterValues() -> 다중값을 받ㅇ르 때 사용하고 반환은 String[]
        String[] foods = request.getParameterValues("foods");
        String animal = request.getParameter("animal");

        System.out.println("이름 " + name);
        System.out.println("나이 " + age);
        System.out.println("키 " + height);
        System.out.println("색상 " + color); 
//        System.out.println("음식 " + Arrays.asList(foods));
        System.out.print("음식 : ");
        for (String fo:foods) {
            System.out.print(fo+ " ");
        }
        System.out.println();
        System.out.println("동물 : " +animal);


        // key 값을 모르고 있을 때 key 값 전체를 가져올 수 있는 메소드
        // getParameterNames();
        // 클라이언트가 보낸 데이터의 key 값을 모두 보여주는 메소드
        System.out.println("모든 key 값 출력하기");
        // Iterator 객체와 동일하게 출력함
        Enumeration<String> keys = request.getParameterNames();
        ArrayList<String[]> sendData = new ArrayList<>();


        while(keys.hasMoreElements()){
//            System.out.println(keys.nextElement());
            String key  =keys.nextElement();
            sendData.add(request.getParameterValues(key));
        }
        System.out.println(sendData);

        for(String[] v : sendData){
            for(int i =0; i<v.length; i++){
                System.out.println(v[i]);
            }
        }

        // 값을 전체 key,value 값을 한번에 받을 수 있는 기능
        // getParameterMap(); -> Map 객체를 이용해서 클라이언트가 전송한 값을 key,value 로 출력
        Map<String,String[]> param = request.getParameterMap();
        System.out.println(param);

        Set<Map.Entry<String,String[]>> entry = param.entrySet();
        Iterator<Map.Entry<String,String[]>> it = entry.iterator();

        while(it.hasNext()){
            Map.Entry<String,String[]> p = it.next();
            System.out.println("key 값"+p.getKey());
            for(String s : p.getValue()){
                System.out.println("값 : " + s);
            }
            System.out.println();
        }


        // request 객체에 setAttribute로 넣은 값을 가져오기
        String msg = (String)request.getAttribute("msg");
        Date today = (Date)request.getAttribute("today");
        // 만약 Attribute 값을 가져올 때 key와 연결되어있는 데이터가 없다면
        // null 값 반환한다 -> 에러가 발생하지 않는다.
        System.out.println("attribute : " +msg);
        System.out.println("attribute : " +today);



        // 기본 응답페이지 작성해보자
        // 응답을 하기 위해서는 HttpServletResponse 이용한다.
        // 응답하기 위한 클라이언트의 정보를 가지고 있음

        // 1. 응답하는 방식을 결정 response.setContentType();
        // 전송되는 데이터 형식(MIME type), 인코딩 방식을 결정
        response.setContentType("text/html;charset=utf-8");

        // client와 연결되는 문자열 Stream을 가져오는 메소드
        PrintWriter out = response.getWriter();
        String html ="<html>";
        html+="<body>";
        if(msg!=null) {
            html += "<h1>" + msg + "</h1>";
        }
        if(today !=null){
            html += "<h3>" + new SimpleDateFormat("yy-MM-dd").format(today) + "</h3>";
        }

        html+="<h1>당신의 취향 테스트 결과</h1>";
        html+="<h2> 당신의 이름은 "+name+"이고 </h2>";
        html+="<h2> 당신의 나이는 "+age+"이고 </h2>";
        html+="<h2> 당신의 키는 "+height+"입니다. </h2>";
        html+="<p> 당신이 좋아하는 색은<span style= \'color:+"+color+"+\'>"+color+"</span>이고 </p>";
        html+="<ul> 당신이 좋아하는 음식은";
        for(String f :foods){
            String src="";
            switch (f){
                case "콩불": src="https://recipe1.ezmember.co.kr/cache/recipe/2018/06/07/d4f891f29e44087ef6a4ebe6634bb8b11.jpg"; break;
                case "카레": src="https://recipe1.ezmember.co.kr/cache/recipe/2018/12/05/8c2b5280776871cec2506d042f8ed5361.jpg"; break;
                case "마라탕": src="https://upload.wikimedia.org/wikipedia/commons/3/3b/Malatang_from_South_Korea.jpg"; break;
                default: src=""; break;
            }
            html+="<li><img src="+src+"; width='100px'; height='100px';>"+f+"</li>";
        }
        html+="</ul>";
        html+="<p> 당신이 좋아하는 동물은 "+animal+"</p>";

        html+="</body>";
        html+="</html>";

        out.write(html);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
