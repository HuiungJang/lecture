<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/05/13
  Time: 2:39 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h2>서버에있는 텍스트 파일의 내용을 읽어오기</h2>
    <button id="testAjax">실행하기</button>
    <div id="area"></div>
<script>
  $(function(){
    $("#testAjax").click((e)=>{
      $.ajax({
        url: "sample.txt",// 요청할 주소
        type: "get",//요청방식(get,post)
        //data: {}, // 파라미터 서버에 전송하는값 ->js 객체로 대입
        dataType:"text" ,// 응답받은 데이터의 타입지정 하지 않아도 자동으로 설정됨
        success: data=>{
          console.log(data);
          $("#area").html(data);
        },// 서버와 통신이 정상적으로 완료된 후 실행되는 함수 -> 매개변수에 서버가 보낸값이 들어옴
        // error: , // 서버와 통신이 정상적으로 완료되지 않았을 때 실행되는 함수
        // complete : , // 무조건 실행되어야하는 함수
      });
    });
    })
</script>
</body>
</html>
