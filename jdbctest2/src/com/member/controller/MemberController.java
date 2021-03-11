package com.member.controller;

import com.member.model.service.MemberService;
import com.member.model.vo.Member;
import com.member.view.MemberView;

import java.util.List;

public class MemberController {
    private MemberService service = new MemberService();
    private MemberView view;

    public void mainMenu(){
        view = new MemberView();
        view.mainMenu(this);
    }

    public void selectAll(){
        List<Member> list = service.selectAll();

        view.printData(list);
    }

    public void enrollMember(){
        Member m = view.inputData();
        int result = service.enrollMember(m);

        view.printMsg(result>0? "등록완료": "등록실패");
    }
}
