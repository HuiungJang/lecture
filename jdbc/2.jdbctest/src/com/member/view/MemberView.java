package com.member.view;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// view 클래스는 항상 기능을 수행 할 때 controller를 호출하게 됨
public class MemberView {
    // 내가 한거
    // private MemberController contoller = new MemberController();

    // 선생님이 한거
    private  MemberController controller;

    // 사용자에게 보여질 화면을 구성하는 클래스.
    // 화면(console)에 출력되는 메소드(기능)을 가지고 있음.
    // 지금은 console이지만
    // -> html, css,js,jq로 변경
//    public void mainMenu(){
//        // 내가한거
//        Scanner sc = new Scanner(System.in);
//        System.out.println("==== 회원관리 프로그램 v.1 ====");
//        while(true){
//            System.out.println("1. 전체회원 조회하기");
//            System.out.println("2. 이름으로 조회하기");
//            System.out.println("3. 아이디로 조회하기");
//            System.out.println("4. 회원등록");
//            System.out.println("5. 회원정보 수정하기");
//            System.out.println("6. 회원삭제하기");
//            System.out.println("0. 프로그램 종료");
//            System.out.println("선택 : ");
//            int cho = sc.nextInt();
//            sc.nextLine();
//
//            switch (cho){
//                case 1:
//                    System.out.println("==== 조회한 회원정보====");
//                    for(int i=0; i<contoller.selectAll().size(); i++){
//                        System.out.println(contoller.selectAll().get(i));
//                    }
//                    System.out.println("========================");
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    break;
//                case 5:
//                    break;
//                case 6:
//                    break;
//                case 0:
//                    System.out.println("프로그램을 종료합니다.");
//                    return;
//                default:
//                    System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
//                    break;
//            }
//        }
//    }

    public void mainMenu(MemberController mc){
        // 선생님이 한거
        controller = mc;

        Scanner sc = new Scanner(System.in);
        System.out.println("==== 회원관리 프로그램 v.1 ====");
        while(true){
            System.out.println("1. 전체회원 조회하기");
            System.out.println("2. 이름으로 조회하기");
            System.out.println("3. 아이디로 조회하기");
            System.out.println("4. 회원등록");
            System.out.println("5. 회원정보 수정하기");
            System.out.println("6. 회원삭제하기");
            System.out.println("0. 프로그램 종료");
            System.out.println("선택 : ");
            int cho = sc.nextInt();
            sc.nextLine();

            switch (cho){
                case 1:
                   mc.selectAll();
                    break;
                case 2:
                    mc.searchName();
                    break;
                case 3:
                    mc.searchId();
                    break;
                case 4:
                    mc.enrollMember();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }


    public void printData(List<Member> data){
        System.out.println("==== 조회한 회원정보====");
        for(Member m : data){
            System.out.println(m);
        }
    }

    // toString 오버라이딩 했으니까 됨
    public void printData(Member m){
        System.out.println("==== 검색 결과 ====");
        System.out.println(m);
    }

//    public String inputId(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("==== 아이디로 회원 검색하기 ====");
//        System.out.print("아이디를 입력해주세요  : ");
//        return sc.nextLine();
//    }
//
//    public String inputName(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("==== 이름으로 회원 검색하기 ====");
//        System.out.print("이름을 입력해주세요  : ");
//        return sc.nextLine();
//    }

    public String searchData(){
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        System.out.println("===="+data+" 회원 검색하기 ====");
        System.out.print(data+"을 입력해주세요  : ");

        sc.close();
        return data;
    }

    public Member inputData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("==== 회원등록 ====");

        System.out.print("아이디 : ");
        String id = sc.nextLine();

        System.out.print("비밀번호 : ");
        String pwd = sc.nextLine();

        System.out.print("이름 : ");
        String name = sc.nextLine();

        System.out.print("성별 (M/F) : ");
        String gender = sc.nextLine();

        System.out.print("나이 : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("이메일 : ");
        String email = sc.nextLine();

        System.out.print("전화번호 ( '-'을 제외하고 입력) : ");
        String phone = sc.nextLine();

        System.out.print("주소 : ");
        String address = sc.nextLine();

        System.out.print("취미 2개 ex) 운동,독서 : ");
        String hobby = sc.nextLine();

        Date today = new Date();
        java.sql.Date date = new java.sql.Date(today.getTime());

        Member m = new Member(id,pwd,name,gender,age,email,phone,address,hobby,date);
        return m;
    }

    public void printMsg(String msg){
        System.out.println("==== 시스템 알림 ====");
        System.out.println(msg);
        System.out.println("=====================");
    }
}
