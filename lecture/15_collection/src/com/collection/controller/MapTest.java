package com.collection.controller;

import com.collection.model.vo.*;

import java.util.*;

public class MapTest {
    // map에 대해 알아보자
    // 쌍으로 이루어져있는 자료구조 key : value
    // key : Object / value : Object
    // Collectrion 인터페이스를 상속받지 않아서 거기에 속하지 않음
    // Map인터페이스로 구성되어있음.
    public static void main(String[] args) {

        HashMap map = new HashMap();
        // 데이터 넣기
        // key value 값 모두 대입해야함
        // put(key, value) 메소드 이용
        // key : String Integer를 많이 사용한다.
        // value : vo(데이터 보관용 객체)를 사용.

        map.put("유병승",19);
        map.put("김상현",29);
        map.put(1,"장혜린");
        map.put(2,"정유정");

        System.out.println(map);
        // set구조 처럼 순서를 저장하지 않고 순서대로 출력되지않음

        // map에 저장된 데이터 가져오기
        // map에 저장된 데이터는 key값을 기준으로 가져옴
        // key == 인덱스 느낌으로 보면됨
        System.out.println(map.get("유병승")); // 19
        System.out.println(map.get(1)); // 장혜린
        // key값을 기준으로 value값을 가져옴 -> key값은 중복이 불가능 , value는 가능

        map.put(1,"김동규");
        System.out.println(map.get(1)); // 김동규
        // key가 중복되면 key값은 유지되고 value값만 덮어씌워짐

        // 값 삭제하기
        // remove() -> key값을 기준으로 삭제
        map.remove(1);
        System.out.println(map.get(1)); // null
        System.out.println(map);
        System.out.println(map.size());

        // Map에 저장되어있는 전체 자료 조회하기.
        // key를 기준으로 값을 가져온다 -> 1. key값을 확인하고 데이터를 가져옴
        // key-> set방식으로 저장됨 -> Itreator를 사용해야함
        System.out.println();
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        } // key값 출력
        System.out.println();

        Iterator it2 = map.keySet().iterator();
        while(it2.hasNext()){
            Object key = it2.next();
            Object value = map.get(key);

            System.out.println(key+ " : "+ value);
        }
        System.out.println();

        // Map.Entry를 이용해서 key,value값을 동시에 가져오는것
        Set entrySet = map.entrySet(); // Map.Entry클래스
        Iterator entry = entrySet.iterator();

        while(entry.hasNext()){
            // it.next() => Map.Entry 객체가 들어가있음.
            Map.Entry e = (Map.Entry)entry.next();
            // getKey() / getValue()
            System.out.println(e.getKey()+" : "+e.getValue());
        }

        // 데이터가 비었는지 확인
        System.out.println(map.isEmpty());

        // key 값 확인
        System.out.println(map.containsKey(3));

        // value 값 확인
        System.out.println(map.containsValue(29));

        // map을 이용하기
        map.clear();
        map.put(1,new Fruit("귤","제주도",12,1555));
        map.put(2,new Fruit("파인애플","필리핀",6,8000));
        map.put(3,new Fruit("레몬","미국",1,3000));

        // map에 있는 값의 이름, 원산지 출력하기

        // 1.
//        Set s = map.keySet();
//        it = s.iterator();
        it = map.keySet().iterator(); // 위 주석된 코드를 줄인것.
        while(it.hasNext()){
            Object key = it.next();
            Fruit f =(Fruit)map.get(key);
            System.out.println(f.getF()+" "+f.getLegion());
        }

        System.out.println();

        // 2.
        // Map.Entry이용해서 처리하기
        Set es = map.entrySet(); // Map.Entry클래스
        Iterator iee = es.iterator();
        while(iee.hasNext()){
            Map.Entry e = (Map.Entry)iee.next();
            Fruit fru = (Fruit) e.getValue();
            System.out.println(fru.getF()+" "+ fru.getLegion());

        }
        System.out.println();

        // values(); 활용하기
        Collection c = map.values();
        System.out.println(c);
        System.out.println();


        Iterator it3 = c.iterator();
        while(it3.hasNext()){
            System.out.println(it3.next());
        }
        System.out.println();

        ArrayList list = new ArrayList(c);
//      ArrayList list = new ArrayList(map.values()); // 위 코드와 같다.

        System.out.println(c);
        System.out.println(list.get(1));


    }


}
