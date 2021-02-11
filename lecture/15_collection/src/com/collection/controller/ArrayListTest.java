package com.collection.controller;

import com.collection.common.FruitNameAscending;
import com.collection.common.FruitNameDecsending;
import com.collection.common.FruitPriceAscending;
import com.collection.model.vo.Fruit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.CollationElementIterator;
import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
        // ArrayList는 배열과 동일한 저장방식을 가지고 있으며
        // 배열의 단점을 보완한 자료구조형태이다.
        // 클래스로 되어있으 메소드를 이용하여 데이터를 수정 삭제 추가 할 수 있다.

        ArrayList list = new ArrayList();
        // 클래스이기 때문에 이용하기 위해서는 반드시 생성
        // 기본적으로 10개의 저장공간이 확보(배열)
        // 저장공간을 지정해서 생성할 수 있다.
        ArrayList list2 = new ArrayList(20);
        // 저장공간 20개 확보하고 생성
        // 데이터를 Object[]로 저장.

        // 다형성에 의해 구현인터페이스 자료형에 대입될 수 있따.
        List listTest = list;
        Collection collection = list2;

        // 생성된 list에 값 넣기
        // add() 메소드를 이용해서 값을 대입한다. -> setter랑 비슷
        // 프로젝트에서 사용하는 모든 타입을 저장할 수 있다.
        list.add("유병승");
        list.add("12");
        list.add("123.3");
//        list.add(new Date());

        // List 자료형을 사용할 때는 통상 vo객체를 저장할때 사용함.
        // 데이터 저장용 클래스
        ArrayList fruit = new ArrayList();
        fruit.add(new Fruit("사과 ", "영주", 5, 3000));
        System.out.println(list);

        // ArrayList에 있는 값 출력하기
        // 출력하는 방법 : 각 데이터 마다 인덱스가 부여되어있어
        // 인덱스를 기준으로 출력함
        // get(int index)메소드를 이용

        System.out.println(list.get(0));
        System.out.println(list.get(1));

        // for문을 이용해서 처리하자
        // List의 데이터 개수 확인하려면 size() 메소드 이용

        System.out.println("list 데이터수 "+list.size());
        System.out.println("fruit 데이터수 "+fruit.size());

        // 데이터 전체 순화하기
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
            //list 데이터 전체 순회
        }

        // List에 있는 데이터 변수에 저장하기
        // ->get으로 가져오는 모든 값의 타입은 Object임
        // 실제 대입된 객체로 이용하려면
        // 강제적 형변환을 해야함 .
        String name = (String)list.get(1);
        System.out.println(name);

        // List 데이터 삭제하기
        // remove(index||객체, 데이터값) 메소드를 이용해서 삭제
        list.remove(0);
        System.out.println(list.get(0));

        // List 데이터 수정하기
        // set(index, 수정할 데이터) 메소드 이용
        list.set(0,"이제 곧 쉬는시간");
        System.out.println(list.get(0));

        // List의 원하는 위치에 데이터 넣기
        // add(index, 데이터) : 인덱스 위치에 데이터 추가
        System.out.println(list);
        list.add(1,"이건 추가한것");
        System.out.println(list);

        // 내가 만든 객체를 이용해보기
        fruit.add(new Fruit("수박","시골",5,600));
        System.out.println(fruit);

        fruit.add(1, new Fruit("키위","뉴질랜드",8,10000));
        System.out.println(fruit);

        // remove
        fruit.remove(0);
        System.out.println(fruit);
        fruit.remove(new Fruit("키위","뉴질랜드",8,10000));
        System.out.println(fruit);

        // 수정하기
        fruit.set(0, new Fruit("바나나","필리핀",7,8000));
        fruit.add(new Fruit("망고","필리핀", 7,800));
        fruit.add(new Fruit("호박","필리핀", 7,9000));
        fruit.add(new Fruit("딸기","필리핀", 7,1000));
        System.out.println(fruit);

        // fruit 변수 -> 과일들을 관리하기 위해 선언
     //   fruit.add(new Date());
        System.out.println(fruit); // 제네릭 선언을 하면 관리가능함

        // List에서 사용할만한 메소드
        // 1. contains() : List 내부에 매개변수의 객체가 있는지 확인
        // 객체에 equals() 오버라이딩이 되어있어야 사용가능함.
        System.out.println(fruit.contains(new Fruit("바나나","필리핀",7,8000)));

        if(!fruit.contains(new Fruit("바나나","필리핀",7,8000))){
            fruit.add(new Fruit("망고","필리핀", 7,800));
            fruit.add(new Fruit("호박","필리핀", 7,9000));
            fruit.add(new Fruit("딸기","필리핀", 7,1000));

        }

        // 2. clear() : List에 있는 데이터를 모두 지움
//        fruit.clear();
        System.out.println(fruit);

        // 3. isEmpty() : List에 데이터가 있는지 확인
        System.out.println(fruit.isEmpty());

        if( !fruit.isEmpty()){
            for(int i =0; i< fruit.size(); i++){
                System.out.println(fruit.get(i));
            }
        }

        // 4. indexOf(객체) : 객체와 일치하는 값의 인덱스번호 반환
        // 결과가 -1 이면 없는값.
        System.out.println(list.indexOf(123.3));

        // 5.toArray() : List를 object[]로 반환해주는 메소드
        Object[] obj = list.toArray(); // 메소드 이용시 배열로 처리하는 선언한 경우

        // List는 중복값 상관없이 저장한다.
//        fruit.add(new Fruit("망고","필리핀", 7,800));
//        fruit.add(new Fruit("망고","필리핀", 7,800));
//        fruit.add(new Fruit("망고","필리핀", 7,800));
//        fruit.add(new Fruit("망고","필리핀", 7,800));
//        fruit.add(new Fruit("망고","필리핀", 7,800));

        System.out.println(fruit);

        // List는 순서가 있기 때문에 정렬이 가능하다.
        list.clear();
        for(int i =0;i<10; i++){
            list.add((int) (Math.random() * 10)+1);
        }
        System.out.println(list);

        // List를 정렬할 수 있는 메소드를 제공해줌
        // Collections.sort()
        // 오름차순 정렬
        Collections.sort(list);
        System.out.println(list);

        list.clear();
        // List에 문자열로 취미를 입력받아 저장 5개
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        for(int i =0; i<5; i++){
//            System.out.print(" 입력 :");
//            try {
//                list.add(br.readLine());
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//        System.out.println(list);

        // 문자열도 정렬이 가능하다.( 오름차순 )
        Collections.sort(list);
        System.out.println(list);

        // 객체도 정렬이 되나?
        // 생성한 객체 정렬하기
        System.out.println("생성한 객체 정렬 ");
        for(Object o : fruit ){
            System.out.println(o);
        }

        Collections.sort(fruit);
        // 생성된 객체로 Collections.sort()를 하기 위해서는
        // Compareable 인터페이스를 구현해야함. -> compareTo() 메소드 오버라이드필요

        System.out.println("정렬 후 결과 ");
        for(Object o : fruit){
            System.out.println(o);
        }

        // 정렬방법 두번째 정렬클래스를 새로 생성해서 적용하는 방법
        // Comparator 인터페이스를 구현하는 객체를 만들면됨
        // Collections.sort(리스트, Comparator구현객체);
        Collections.sort(fruit,new FruitNameAscending());
        System.out.println("Comparator 이용 정렬 처리");
        for(Object o : fruit) {
            System.out.println(o);
        }

        // 이름을 기준으로 내림차순 정렬
        Collections.sort(fruit,new FruitNameDecsending());
        System.out.println("Comparator 이용 정렬 처리");
        for(Object o : fruit) {
            System.out.println(o);
        }

        // 가격을 기준으로 오름차순정렬
        Collections.sort(fruit,new FruitPriceAscending());
        System.out.println("Comparator 이용 정렬 처리");
        for(Object o : fruit) {
            System.out.println(o);
        }

        //  한번만 쓸껀데 계속 객체만들어야하는데,,, 귀찮
        // lambda 표현식 ' -> ' 방식으로 메소드를 표현해서 바로 실행할 수 있게 만든것.
        // 메소드의 선언부를 간단하게 표시해서 매개변수로 넘길 수 있음.
        // 인터페이스에서 한개의 메소드만 선언한 것으로 처리
        // (매개변수) -> 리턴값 형식

        Collections.sort(fruit,(Object o1, Object o2)->
            ((Fruit)o2).getPrice()-((Fruit)o1).getPrice()
        );

        // 위 lambda식 풀어서 쓴거.
        Collections.sort(fruit, new Comparator<>() {
            @Override
            public int compare(Object o1 , Object o2) {
                return ((Fruit)o2).getPrice() - ((Fruit)o1).getPrice();
            }
        });


        System.out.println("Comparator 이용 정렬 처리");
        for(Object o : fruit) {
            System.out.println(o);
        }

        // LinkedList -> ArrayList와 동일함
        // 다만 데이터를 추가,수정,삭제가 다름

        // 메소드에서 약간의 차이가 있음
        LinkedList linkedList = new LinkedList();
        linkedList.add("유병승");
        linkedList.add("장희웅");
        linkedList.add("김상현");
        linkedList.add("정유정");

        for(Object o :linkedList){
            System.out.println(o);
        }
        System.out.println();
        for(int i = 0; i<linkedList.size(); i++ ){
            System.out.println(linkedList.get(i));
        }
        System.out.println();
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.pop());
        System.out.println(linkedList);
    }


}
