package com.websocket.controller;

import com.google.gson.Gson;
import com.websocket.model.vo.MessageTest;

import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 일반 클래스를 웹 소켓 서버로 등록하려면
// @ServerEndpoint("주소") 어노테이션을 이용한다. -> 클래스 선언부에 선언함.

@ServerEndpoint(
        value="/chatting",
        encoders = {JsonEncoder.class},
        // 인코더 클래스를 생성해서 Encoder. 인터페이스를 상속받는다.
        decoders ={JsonDecoder.class}
        // 디코더 클래스를 생성해서 Decoder. 인터페이스를 상속받는다.
        )
public class ChattingServer {
    // 내부에 클라이언트에서 요청하는 내용을 처리하는 메소드를 등록한다.
//    private Map<String,Session> clients =  new HashMap();

    @OnOpen
    public void message(Session session, EndpointConfig config){
        // 접속요청을 한 클라이언트와 접속이 되면 실행되는 메소드
        System.out.println(session.getId());
        System.out.println("클라이언트 접속함");

//        clients.put(session.getId(),session);
    }

    // 클라이언트들이 보내는 메세지 처리하는 메소드 등록하기
    @OnMessage
    //인코더, 디코더를 등록했다면
    public void message(Session session, MessageTest msg){
//    public void message(Session session, String msg){
        // session 메세지를 보낸 클라이언트의 session 객체
        // HttpServlet session 과 전혀 다른 session 이다. 구별하자
        // msg - > page 에서 socket.send("데이터")
        System.out.println(msg);

        // 객체로 받아오기
//        MessageTest data = new Gson().fromJson(msg,MessageTest.class);
        // msg 받아서 Message 클래스로 변경해라
//        System.out.println(data);

        // 클라이언트가 보낸 메세지 파싱하기
//        String[] data = msg.split(",");
        // 0 : 보낸사람
        // 1 : 받는사람
        // 2 : 메세지

        // 보낸데이트를 세션에 저장할 수 있음.
//        session.getUserProperties().put("msg",data);
        // 인코더 디코더를 등록했다면
        session.getUserProperties().put("msg",msg);


        // 클라이언트가 보낸 데이터를 다른 접속한 클라이언트에게 전송하기
        // 1. 접속한 클라이언트 관리
        //  1) Collection 클래스를 이용하는 방법 Map, List, Set 이용해서 관리
        //  2) session 클래스에서 접속한 session을 알 수 있는 메소드를 제공한다.
        //     session.getOpenSessions() -> 현재 웹소켓에접속해서 session이 유지되고 있는
        //     모든 session 값을 반환해준다.

        // 2. 접속 session 객체를 이용해서 데이터를 전송 할 수 있음.
        // session.getBasicRemote() 메소드 -> 접속한 세션과 연결되는 스트림을 가져옴

        // 3. getBasicRemote()로 가져온 객체의 sendText() 메소드를 실행 ->
        //      메세지를 클라이언트에 전송
        Set<Session> clients =  session.getOpenSessions();
        // 웹소켓 서버에 접속한 모든 세션을 가져옴

        for(Session s : clients){
//            String[] clientData = (String[])s.getUserProperties().get("msg");
             MessageTest clientData = (MessageTest)s.getUserProperties().get("msg");

//            if(data[1].length() > 0){
//            // 받는 사람이 있다면
//                if(clientData[0].equals(data[1])
//                    || clientData[0].equals(data[0])){
//                // 보낸사람과 받는 사람이 같다면 = 귓속말
//                    try{
//                        s.getBasicRemote().sendText(msg);
//                        // 접속한 모든 세션에게 msg 를 전송한다.
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }
//
//            }else{
                if(clientData.getReceiver() != null && !clientData.getReceiver().equals("")){
                    if(clientData.getSender().equals(msg.getReceiver())
                        || clientData.getSender().equals(msg.getSender())){
                        try{
//                            s.getBasicRemote().sendText(new Gson().toJson(data));
                            // 접속한 모든 세션에게 msg 를 전송한다.

                            // 인코더 디코더를 등록했다면
                            s.getBasicRemote().sendObject(msg);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }else{
                    try{
//                            s.getBasicRemote().sendText(new Gson().toJson(data));
                        // 접속한 모든 세션에게 msg 를 전송한다.

                        // 인코더 디코더를 등록했다면
                        s.getBasicRemote().sendObject(msg);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
//            }


        }




    }

}
