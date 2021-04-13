package com.member.controller;

import com.member.model.service.MemberService;
import com.member.model.vo.Member;
import com.member.view.MemberView;

import java.util.List;
import java.util.Map;

public class MemberController {

    // Member 서비스를 관리하는 객체
    // client 에게 특성 서비스 기능을 요청받아 처리
    // 필요한 화면(view) / DB 데이터를 가져오는 것(model)
    private MemberView view = new MemberView();
    private MemberService service = new MemberService();

    public void mainMenu(){
        // 메인 화면을 보여달라는 요청
        view.mainMenu(this);

    }

    public void selectAll(){
        // DB의 student 계정의 member테이블 전체데이터를 가져와 출력하는 기능
        // DB에 접근해야할 때 Service 객체에 요청
        List<Member> list = service.selectAll();

        view.printData(list);
    }

    public void searchName(){
        String name = view.searchName();

        List<Member> list = service.searchName(name);

        view.printData(list);
    }

    public void choiceSearch(){
       Map<String,String> param= view.colvalInput();
       // 검색을 원하는 컬럼, 값을 입력받기
        List<Member> list = service.choiceSearch(param);

        view.printData(list);

    }
}
