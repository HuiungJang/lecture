package com.member.controller;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;
import com.member.view.MemberView;

import java.util.List;

public class MemberController {
    private MemberView view;
    private MemberDao dao = new MemberDao();

    public void mainMenu(){
        // 메인메뉴를 호출하는 기능.
        view = new MemberView();
        view.mainMenu();
    }

    public List<Member> selectAll(){
        // DB student 계정의 member테이블에 있는 전체 데이터 가져오는 서비스

        // view에서 받은 데이터 출력하기 -> 숙제
        return dao.selectAll();

    }
}
