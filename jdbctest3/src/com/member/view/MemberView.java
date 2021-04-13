package com.member.view;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MemberView {
    private MemberController controller;
    private Scanner sc = new Scanner(System.in);

    public void mainMenu(MemberController mc){
        controller = mc;

        while(true) {
            System.out.println("==== 회원관리 .v3 ====");
            System.out.println("1. 전체회원조회");
            System.out.println("2. 이름으로 조회");
            System.out.println("3. 아이디로 조회");
            System.out.println("4. 회원등록");
            System.out.println("5. 회원수정");
            System.out.println("6. 회원삭제");
            System.out.println("7. 원하는 조건으로 검색");
            System.out.println("0. 프로그램 종료");

            System.out.print("선택 : ");
            int cho = sc.nextInt();
            sc.nextLine();

            switch (cho) {
                case 1:
                    mc.selectAll();
                    break;
                case 2:
                    mc.searchName();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    mc.choiceSearch();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
                    break;
            }
        }
    }

    public void printData(List<Member> list){
        System.out.println("==== 조회결과 ====");

        for(Member m : list) {
            System.out.println(m);
        }
    }

    public String searchName(){
        System.out.println("찾을 회원 이름을 입력해주세요 : ");
        String name = sc.nextLine();

        return name;
    }

    public Map<String,String> colvalInput(){
        Map<String,String> parma = new HashMap();
        System.out.println("==== 검색을 원하는 컬럼명, 값을 입력 ====");
        System.out.print("컬럼명 : ");
        String col =sc.nextLine();
        System.out.println("값 : ");
        String val = sc.nextLine();

        parma.put(col,val);

        return parma;
    }

}
