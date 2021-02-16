package com.generic.controller;

import com.generic.model.vo.Book;

import java.util.*;

public class GenericTest {
    public static void main(String[] args) {
        // 기본 제네릭 알아보기
        // <자료형>으로 제네릭에 대한 자료형을 선언함
        // 주로 Collection, Map을 이용할때 사용함

        Collection c;
        ArrayList list;

        ArrayList<String> names = new ArrayList<String>();
        // 이름을 저장하기 위한 변수(String)
        // generics  사용하면 타입을 고정시킴.

        names.add("유병승");
        names.add("김상현");
        names.add("정유정");

//        names.add(19);
        // String 형식으로 저장해야하는데 int형식 들어감 -> 컴파일시 에러
        // generics 사용하면 해결

        //for(String a:names){
//        for(Object o : names){
        for(String a : names){
//            String name = (String)o;
//            System.out.println(name.charAt(0));
            // generics로 고정됐으니까
            System.out.println(a.charAt(0));
        }

        ArrayList books = new ArrayList();
        ArrayList<Book> booksGen = new ArrayList<Book>();
        // 뒤쪽 제네릭스는 안써도 무방함.


        // books에 저장된 책의 이름과 가격을 출력하세요


        // 제네릭스를 사용안했을 때.
//        books.add(new Book("자바의 정석","남궁성",34000,0.5));
//        books.add(new Book("노인과 바다","헤밍웨이",34000,0.5));
//        books.add(new Book("어린왕자","생택쥐페리",34000,0.5));
//        for(Object o :books){
//            Book b = (Book)o;
//            System.out.println(((Book) o).getTitle()+"  "+((Book) o).getPrice());
//        }


        // 제네릭스를 사용했을 때.
        booksGen.add(new Book("자바의 정석","남궁성",34000,0.5));
        booksGen.add(new Book("노인과 바다","헤밍웨이",34000,0.5));
        booksGen.add(new Book("어린왕자","생택쥐페리",34000,0.5));

        for(Book b :booksGen){
            System.out.println(b.getTitle()+" "+ b.getPrice());
        }

        // Set에서 Generic 선언하기.
        // generic 없이 사용힐 때
        HashSet set = new HashSet<String>();


        set.add("유병승");
        set.add("김지한");
        set.add("정인채");
        set.add("이진주");

        Iterator it = set.iterator();
        while(it.hasNext()){
//            String name = (String)it.next();
//            System.out.println(name.charAt(0));
            System.out.println( ((String)it.next()).charAt(0) );

        }
        System.out.println("---제네릭 표시한 후---");
        HashSet<String> set1 = new HashSet<String>();

        set1.add("유병승");
        set1.add("김지한");
        set1.add("정인채");
        set1.add("이진주");

        Iterator<String> it2 = set1.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next().charAt(0));
        }


        System.out.println("---for - Each문 사용---");
        // Set은 forEach문을 이용해서 값을 받을 수 있음.
        for(String name : set1){
            System.out.println(name.charAt(0));
        }


        // 객체도 가능
        HashSet<Book> setBook = new HashSet<>(booksGen);

        for(Book b : setBook){
            System.out.println(b);
        }


        // Map
        System.out.println("---Map 사용---");

        HashMap map = new HashMap();
        map.put(1,"사과");
        map.put(2,"배");
        map.put(3,"포도");


        for(int i =1; i<=map.size(); i++){
            System.out.println(map.get(i));
        }


        Set keys = map.keySet();
        Iterator it3 = keys.iterator();
        while(it3.hasNext()){
            Object key = it3.next();
            System.out.println(map.get(key));
        }


        System.out.println("---generic 사용한 HashMap---");
        // key 값과 value 값 2개를 generic에 넣어야한다.
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1,"복숭아");
        map2.put(2,"수박");
        map2.put(3,"딸기");

        Set<Integer> keys2 = map2.keySet();
        Iterator<Integer> it4 = keys2.iterator();
        while(it4.hasNext()){
            int a = it4.next();
            System.out.println(map2.get(a));
            System.out.println(map2.get(a).charAt(0));
            // String으로 자료형이 고정되어있기 때문에 사용가능.
        }


        System.out.println("----Map.Entry로 key value 전체 가져오기.----");
        Set<Map.Entry<Integer,String>> entry = map2.entrySet();
        Iterator<Map.Entry<Integer,String>> itEntry = entry.iterator();

        while(itEntry.hasNext()){
            Map.Entry<Integer, String> all = itEntry.next();
            System.out.println(all.getKey() +" : "+ all.getValue());
        }

        // forEach문을 이용해서 map 객체 접근하기
        for(Map.Entry<Integer, String> all : map2.entrySet() ){
            System.out.println(all.getKey() + " : "+ all.getValue());
        }

        HashMap<String, Book> booksMap = new HashMap<>();
        booksMap.put("one",new Book("자바의 정석","남궁성",34000,0.5));
        booksMap.put("two",new Book("노인과 바다","헤밍웨이",34000,0.5));
        booksMap.put("three",new Book("어린왕자","생택쥐페리",34000,0.5));

        // 책에 key 값과 책이름, 저자 , 가격을 출력하기

        for( Map.Entry<String,Book>all : booksMap.entrySet()) {
            System.out.println(all.getKey() + " :  "
                    + all.getValue().getTitle()
                    + all.getValue().getAuthoe()
                    + all.getValue().getPrice());
        }

        // 내가 선언한 제네릭 이용하기.
        MyGeneric m = new MyGeneric<>();
        System.out.println(m.getTmp());

        MyGeneric<Integer> m2 = new MyGeneric();
        System.out.println(m2.getTmp());
        m2.setTmp(100);
        System.out.println(m2.getTmp());
       // m2.setTmp("백"); m2-> Integer로 이미 선언

        MyGeneric<String> m3 = new MyGeneric<String>();
        m3.setTmp("백");
        System.out.println(m3.getTmp());

        MyGeneric<List<Book>> m4 = new MyGeneric<>();
        m4.setTmp(new ArrayList<>());
        m4.getTmp().add(new Book("hi","hoho",10000,0));
        System.out.println(m4.getTmp());
    }

}
