<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/19
  Time: 10:46 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>채팅구현하기</title>
</head>
<body>
    <input type="text" id="sender" size="10" placeholder="보내는 이름">
    <input type="text" id="receiver" size="10" placeholder="받는 사람">
    <input type="text" id="msg" placeholder="전송할 메세지 입력">
    <button onclick="sendMsg();">전송</button>
    <div id="msgContainer"></div>
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    // 웹소켓 서버에 연결하기
    //  websocket 객체를 생성함
    const socket = new WebSocket("ws://localhost:9090/<%=request.getContextPath()%>/chatting");
    // http 프로토콜 통신 -> ws:주소
    // https 프로토콜 통신 -> wss:주소
    // 이 구문이 실행되면 자동으로 주소로 접속요청을 보낸다.

    // socket 설정
    // 접속 후 실행되는 이벤트 핸들러 등록
    socket.onopen= (e)=>{
      // 서버에 등록된 onopen 메소드 실행시킴
      console.log("웹소켓 서버 접속 성공");
      console.log(e);
      // 통상 접속 성공하면 자기 자신의 정보를 전송함. 아이디나 접속정보등
    }

    // 웹소켓 서버에서 sendText, sendObject 메소들를 실행하면 실행되는 함수
    socket.onmessage=(e)=>{
      console.log("메세지 수신");
      // 메세지 = 데이터

      // 수신된 데이터를 받으려면 이벤트 객체의 data 속성을 이용함
      console.log(e);
      console.log(e.data);
      // 메세지 처리에 대한 로직을 여기에 구현을 한다.
      // Object 형태의 String 데이터를 객체로 변환해주기
      console.log(JSON.parse(e.data));
      const msg = JSON.parse(e.data);



      // let msg = e.data.split(",");
      // 0 : 보낸사람
      // 1 : 메세지




      if(msg["sender"] === $("#sender").val()){
        // $("#msgContainer").append($("<p>").text("<"+msg[0]+"> : "+msg[2]).css("text-align","left"));
        // 데이터를 객체로 보내보자
        $("#msgContainer").append($("<p>").text("<"+msg["sender"]+"> : "+msg["msg"]).css("text-align","left"));


      }else{
        // $("#msgContainer").append($("<p>").text("<"+msg[0]+"> : "+msg[2]).css("text-align","right"));

        // 데이터를 객체로 보내보자
        $("#msgContainer").append($("<p>").text("<"+msg["sender"]+"> : "+msg["msg"]).css("text-align","right"));

      }


    }

    const sendMsg = ()=>{
      // 웹소켓 서버에 메세지를 전송하는 함수
      // 전송 할 메세지 전처리
      // 전처리한 메세지를 전송하는 방법 : socket.send("데이터전송")
      // console.log($("#msg").val());

      // socket.send($("#sender").val()+" : "+$("#msg").val());
      // 데이터는 보통 문장형식으로 보내지는 않는다.

      // socket.send($("#sender").val()+","+$("#receiver").val()+","+$("#msg").val());
      // 데이터를 객체로 보내보자
      msg = new Message($("#sender").val(),$("#receiver").val(),$("#msg").val());
      // javascript 객체를 스트링으로 변환해서 전송
      // JSON.stringify(object) 함수를 이용한다.

      socket.send(JSON.stringify(msg));
      // key value 값으로 들어간다.

    }

    function Message(sender,receiver,msg){
      this.sender = sender;
      this.receiver = receiver;
      this.msg = msg;
    }

</script>
</body>
</html>
