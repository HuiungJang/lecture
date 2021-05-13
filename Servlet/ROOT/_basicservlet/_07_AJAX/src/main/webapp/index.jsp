<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>AJAX 알아보기</title>
</head>
<body>

    <h2>자바스크립트를 이용한 ajax 통신</h2>
    <p>비동기식으로 서버와 통신을 하는 기술 -> js를 통해서</p>
    <button onclick="ajaxTest1();">js ajax 테스트</button>
    <button onclick="ajaxTest2();">js ajax 테스트 post</button>
<div id="target"></div>
<script>
    const ajaxTest1 = ()=>{
      // ajax 서버와 통신하기
      // 1. XMLHttpRequest 객체 생성하기
      const xhr = new XMLHttpRequest();

      // 2. XMLHttpRequest 객체를 설정하기
      // open() 함수를 이용해서 통신값을 설정한다.
          // 매개변수
          // 1) 방식 : get, post
          // 2) 요청주소 : 서블릿
          // 3) 동기식, 비동기식 설정 -> 생략가능

      // 클라이언트가 보내는 값을 쿼리스트링으로 전송한다.
      xhr.open("get","<%=request.getContextPath()%>/ajaxTest.do?id=admin");

      // 3. 요청에 대한 서버응답을 처리할 함수를 지정
      // xhr 객체에 onreadystateonchange 속성에 함수를 대입
      // xhr 객체 내부의 상태를 관리하는 속성
          // 1) readyState : 전송상태관리 0,1,2,3,4
          // 2) status : 응답코드 관리 ex) 200, 400, 403 ,404, 500 등

      xhr.onreadystatechange=()=>{
        if(xhr.readyState == 4 ){
          // 통신완료 !
          if(xhr.status==200) {
            // 응답메세지를 정상적으로 수신
            // alert("서버 통신완료!");
            // 서버가 응답한 내용은 xhr 객체의 responseText 속성에 자동으로 대입
            console.log(xhr.responseText);
            document.getElementById("target").innerHTML="<h3>"+xhr.responseText+"</h3>";
          }
          // if(xhr.status==404){
          //   alert("찾는페이지 없어!");
          // }
        }
      }

      // 모든 값에 대해 설정 한 뒤 요청을 전송
      // send() 함수르르 이용
      xhr.send();

    };

    const ajaxTest2=()=>{
      // post 방식으로 데이터 전송
        const xhr = new XMLHttpRequest();
        xhr.open("post","<%=request.getContextPath()%>/ajaxTest.do");

        xhr.onreadystatechange = ()=>{
          if(xhr.readyState == 4){
            if(xhr.status == 200){
              document.getElementById("target").innerHTML ="<h1>"+xhr.responseText+"</h1>"

            }

          }

        };
        // post 방식에서 데이터를 전송할 경우
        // url에 데이터 내용을 작성하지 않고 send함수의 매개변수로 넣음 key = value 형식
        // 전송방식도 수정해야함
        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhr.send("id=user01");
    };

</script>

</body>
</html>