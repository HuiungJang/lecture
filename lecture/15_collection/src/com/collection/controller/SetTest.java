package com.collection.controller;

import java.util.*;
import com.collection.model.vo.*;

public class SetTest {

    public static void main(String[] args) {
        // set :  객체들을 저장 할 수 있는 자료구조
        // 순서가 없고 중복값을 저장하지 않는다.

        HashSet set = new HashSet();
        //add() 메소드를 이용해서 값을 넣음
        set.add("안녕");
        set.add("하이");
        set.add("반가워");
        set.add("오랜만이야");
        set.add("잘가");

        // set에 저장되어있는 값을 출력하기 위해서는
        // 모두를 가져와 출력해야함. 특정 값을 지정해서 빼올 수 없음.
        // Iterator객체를 이용해서 출력함.
        // 출력방식-> StringTokenizer와 비슷하다.
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-----------------");

        // 중복값을 저장하지 않음.
        set.add("안녕");
        set.add("안녕");
        set.add("안녕");
        set.add("안녕");
        set.add("안녕");
        set.add("안녕");
        set.add("안녕");
        set.add("안녕");
        // -> 한번만 저장됨.

        Iterator it2 = set.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }

        it2 =set.iterator(); // 재할당
        System.out.println(it2.next());

        // set을 이용해서 중복값 제거하기
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);

        System.out.println(list);

        System.out.println("중복");
        HashSet tmp = new HashSet(list);
        System.out.println(tmp);

        // lotto만들기
        System.out.println("lotto");
        list.clear();
        while(list.size() != 6){
            list.add((int)(Math.random()*44)+1);
            //list = new ArrayList(new HashSet(list));
            HashSet s = new HashSet(list);
            list = new ArrayList(s);
        }
        System.out.println(list);

        //저장 순서를 유지하는 set
        System.out.println("LinkedList");

        LinkedHashSet lset = new LinkedHashSet();

        lset.add(1);
        lset.add("유병승");
        lset.add(new Fruit("배","나주",10,12000));

        System.out.println(lset);
        it2= lset.iterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
        }

        // treeSet
        // 무조건 오름차순으로 정렬됨.
        // 같은 자료형만 들어가야한다.
        // String이 들어있으면 String만 int형이면 int형만

        TreeSet tset = new TreeSet();
        tset.add("유병승");
        tset.add("김상현");
        tset.add("장혜린");
        tset.add("김동규");

        Iterator it3 = tset.iterator();
        while(it3.hasNext()){
            System.out.println(it3.next());
        }

//        tset.add(4);
//        tset.add(1);
//        tset.add(8);
//        tset.add(9);

        it3=tset.descendingIterator();
        // 내림차순으로 정렬.
        while(it3.hasNext()){
            System.out.println(it3.next());
        }

        HashSet fruits = new HashSet();
        fruits.add(new Fruit("복숭아","천도",12,10000)); //Object
        fruits.add(new Fruit("체리","미국",3,12333));
        fruits.add(new Fruit("체리","미국",3,12333)); // HashCode 오버라이딩 해서 중복값 안넣어짐.


        it3= fruits.iterator();
        while(it3.hasNext()){
            // 과일 이름과 가격가져오기.
            Fruit fru = (Fruit) it3.next();
            // 변수 선언해서 사용한다.
            System.out.println(fru.getF()+" "+fru.getPrice());
        }

    }
}
