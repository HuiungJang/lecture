package com.firstjdbc;

import java.sql.*;

public class BasicJDBC {
    public static void main(String[] args) {

        // JDBC 활용 객체는 반드시 반환을 해야하기 때문에
        // Connection, Statement, ResultSet -> Exception 처리해야함
        // -> try문 안에 선언됨 -> 정상적으로 반환할 수 없음
        // 그래서 try 문 외부에서 지역변수로 선언해야함
        // 지역변수는 반드시 초기화 해야하니까 null로 초기화
        Connection conn=null;
        Statement stmt =null;
        ResultSet rs=null;



        // DataBase에 연결하기
        // 1. Class.forName() 메소드를 이용해서 활용할 드라이버 등록한다.
        // oracle.jdbc.driver.OracleDriver
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // 반드시 예외처리해줘야한다.
            System.out.println("드라이버 등록성공");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


        // 2. DB 연결위한 Connection 객체 생성하기
        // DriverManager 객체의 getConnection() 메소드를 이용해서
        // Connection 생성

        // getConnection()
        // 매개변수 -> 3개의 문자열 매개변수를 가짐
        // 1. DB 접속주소 -> "jdbc:oracle:thin:@DB 서버아이피주소:DB 포트:DB의 sid"
        //                   ex) "jdbc:oracle:thin:@localhost:1521:xe"
        // 2. 사용자 계정 -> 문자열로 계정명 작성 ex) "student"
        // 3. 사용자 비밀번호 -> 문자열로 비밀번호작성 ex) "student"
        //                      -> 비밀번호는 대소문자 구분한다.

        // 주의
        // >> git 업로드할때 public 으로 올렸을때 계정명과 비밀번호 노출될 수 있다. <<
        // 주의

        try{
//          Connection conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "student","student");
            System.out.println("DB 접속성공");



            // 3. SQL 문을 실행할 객체를 생성 -> Connection 객체를 사용하자
            //    Statement 객체
            // Connection 객체의 createStatement() 메소드를 이용해서 생성
//            Statement stmt = conn.createStatement();
            stmt = conn.createStatement();


            // 4. 실행할 SQL 문 작성 -> 문자열로 작성한다.
            // SQL Developer 에서 사용한 구문을 사용하면된다.(select, insert, update, delete)
            // 구문을 작성했을때 반드시 ; (세미콜론)은 제거한다.
            String sql = "SELECT * FROM MEMBER";

            // 5. 작성된 SQL 문을 실행
            // Statement.executeQuery() || executeUpdate() 메소드 이용

            // executeQuery("실행할 SQL 구문")
            // : SELECT 문을 실행 할때 사용 -> ResultSet 객체 반환

            // executeUpdate("실행할 SQL 구문")
            // : INSERT, UPDATE, DELETE 문을 실행 할 때 사용 -> int 반환

//            ResultSet rs = stmt.executeQuery(sql); // SQL 실행 메소드
            rs = stmt.executeQuery(sql);

            System.out.println("SQL 문 실행 ");

            // 6. 결과확인
            // SELECT 문 실행결과는 ResultSet 객체에 테이블 형식으로 저장되어있음
            // ResultSet 객체의 1행씩 데이터를 가져와야함.
            // ResultSet.next() -> 결과로 가져온 테이블 row 1개씩 지칭함.
            // 컬럼에 있는 데이터를 가져오려면
            // getString || getInt || getDate || getDouble("컬럼명") 메소드 이용
            // varchar2, char -> String
            // number -> Int,Double
            // date -> java.sql.Date

            // rs.next() -> return true || false -> 다음 로우가 있으면 true, 없으면 false

//            rs.next(); // 1번 row를 지정
//            String memberId = rs.getString("member_id"); // 매개변수 컬럼명은 대소문자 구분x
//            String memberPwd = rs.getString("member_pwd");
//            String memberName = rs.getString("member_name");
//            int age =rs.getInt("age");
//            System.out.println(memberName +" "+ memberPwd+" "+memberName+" "+age);
//
//            rs.next(); // 2번 row를 지정
//            memberId = rs.getString("member_id"); // 매개변수 컬럼명은 대소문자 구분x
//            memberPwd = rs.getString("member_pwd");
//            memberName = rs.getString("member_name");
//            age =rs.getInt("age");
//            System.out.println(memberName +" "+ memberPwd+" "+memberName+" "+age);

            while (rs.next()){
                String memberId = rs.getString("member_id");
                String memberPwd = rs.getString("member_pwd");
                String memberName = rs.getString("member_name");
                int age =rs.getInt("age");

                System.out.println(memberId +" "+ memberPwd+" "+memberName+" "+age);
            }


            // insert문 실행하기
            // 컬럼에 들어갈 값을 작성할 때 리터럴 표시를 정확하게 해야한다.
            // 문자열-> '' ,숫자-> 1234, 날짜 -> SYSDATE || '21/03/10'
            sql = "INSERT INTO MEMBER VALUES('ho123','ho123','양호준','F',47,'ho@ho.COM'," +
                    "'01012345678','서울시 은평구','기타,운동',SYSDATE)";
            int result = stmt.executeUpdate(sql);
            System.out.println(result);
            // 1
            // 1행이 삽입되었으니가 그 행(row)의 수가 나옴
            System.out.println(result>0 ? "입력성공" : "입력실패");

            // insert, update, delete ->트랜젝션 처리 해줘야함.

            // 7. 생성된 객체 닫기
            // connection, statement, resultset 객체는 입출력하는 것으로
            // 반드시 반환을 해줘야함 -> close() 메소드로
            // 반환하는 순서는 생성의 역순으로 진행한다.
            // resultset.close() -> statement.close() -> connection.close()


        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            // 7. 객체반환
            try {
                if(rs != null && !rs.isClosed())rs.close();
                if(stmt != null && !stmt.isClosed())stmt.close();
                if(conn != null && !conn.isClosed())conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }


    }
}
