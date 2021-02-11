package com.collection.common;

import com.collection.model.vo.Fruit;

import java.util.Comparator;

public class FruitNameDecsending implements Comparator<Fruit> {
    @Override
    public int compare(Fruit f, Fruit f2){
        return  f2.getF().compareTo(f.getF());
    }
}
