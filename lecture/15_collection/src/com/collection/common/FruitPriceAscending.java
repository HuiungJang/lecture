package com.collection.common;

import com.collection.model.vo.Fruit;

import java.util.Comparator;

public class FruitPriceAscending implements Comparator<Fruit> {

    @Override
    public int compare(Fruit o1, Fruit o2) {
        return o1.getPrice()-o2.getPrice();
    }
}
