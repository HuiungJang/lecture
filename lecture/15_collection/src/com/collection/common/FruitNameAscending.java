package com.collection.common;

import com.collection.model.vo.Fruit;

import java.util.Comparator;

// fruit 객체 이름을 정렬하게하는 sort객체
// fruit 객체 이름을 기준으로 + - 0 반환하는 메소드 구현
public class FruitNameAscending implements Comparator<Fruit> {

    @Override
    public int compare(Fruit o1, Fruit o2){

        return o1.getF().compareTo(o2.getF());
    }


}
