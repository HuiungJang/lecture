package com.member.controller;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;
import com.member.view.MemberView;

import java.util.Arrays;
import java.util.List;

public class MemberController {
    private MemberView view;
    private MemberDao dao = new MemberDao();

    public void mainMenu(){
        // 메인메뉴를 호출하는 기능.
        view = new MemberView();
        view.mainMenu(this);
    }

//    public List<Member> selectAll() {
//        // DB student 계정의 member테이블에 있는 전체 데이터 가져오는 서비스
//
//        // view에서 받은 데이터 출력하기 -> 숙제
//        // 내가한거
//        return dao.selectAll();
//
//    }

    public void selectAll() {
        // 선생님이 한거
        //DB student계정의 member테이블에 있는 전체 데이터 가져오는 서비스
        List<Member> result = dao.selectAll();
        //view에서 받은 데이터 출력하기 -> 오늘 숙제
        //System.out.println(result);
//		for(Member m : result) {
//			System.out.println(m);
//		}
//		result.get(0).setMemberName("박찬혁");
//		for(Member m : result) {
//			System.out.println(m);
//		}
        //view에서 데이터를 출력하는 매소드를 호출
        //console창에 전달받은 데이터를 출력해주고 마무의ㄹㅣ!
        System.out.println(view);
        view.printData(result);
    }


//    public void searchId(){
//         내가한거
//        // 1. 검색할 아이디를 입력받는다 -> view에 요청
//        // 2. 입력받은 값을 받으면 db에 있는지 확인한다. -> dao
//        // 3. dao가 준 결과를 view에서 출력한다. -> view에 요청
//        String memberId = view.inputData();
//        List<Member> result = dao.searchId(memberId);
//
//        if(result == null) {
//            System.out.println("찾는 회원이 없습니다.");
//        }else{
//            view.printData(result);
//        }
//    }

    public void searchId(){
        // 선생님이 한거
        // 1. 검색할 아이디를 입력받는다 -> view에 요청
        // 2. 입력받은 값을 받으면 db에 있는지 확인한다. -> dao
        // 3. dao가 준 결과를 view에서 출력한다. -> view에 요청

        String memberId = view.searchData();
        Member m = dao.searchId(memberId);

        // Arrays.asList(new Member[] {m});
        // 일반배욜을 List로 변경해주는 메소드
        view.printData(m);

    }

    public void searchName(){
        String memberName = view.searchData();
        List<Member> l = dao.searchName(memberName);
        if(l == null){
            System.out.println("일치하는 이름이 없습니다.");
        }else {
            view.printData(l);
        }
    }

    public void enrollMember(){
        Member inputData = view.inputData();
        int result = dao.insertMember(inputData);
        view.printMsg( result>0? "회원 등록완료" : "회원등록 실패");
    }

}
