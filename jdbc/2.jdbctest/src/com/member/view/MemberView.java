package com.member.view;

import com.member.controller.MemberController;

import java.util.Scanner;

// view 클래스는 항상 기능을 수행 할 때 controller를 호출하게 됨
public class MemberView {
    private MemberController contoller = new MemberController();

    // 사용자에게 보여질 화면을 구성하는 클래스.
    // 화면(console)에 출력되는 메소드(기능)을 가지고 있음.
    // 지금은 console이지만
    // -> html, css,js,jq로 변경
    public void mainMenu(){
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
                    for(int i=0; i<contoller.selectAll().size(); i++){
                        System.out.println(contoller.selectAll().get(i));
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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

}
