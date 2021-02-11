package com.collection.model.vo;

import java.util.Objects;

public class Fruit implements Comparable<Fruit>{
    private String f;
    private String legion;
    private int su;
    private int price;

    public Fruit() {
    }

    public Fruit(String f, String legion, int su, int price) {
        this.f = f;
        this.legion = legion;
        this.su = su;
        this.price = price;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getLegion() {
        return legion;
    }

    public void setLegion(String legion) {
        this.legion = legion;
    }

    public int getSu() {
        return su;
    }

    public void setSu(int su) {
        this.su = su;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Fruit{" +
                "과일 ='" + f + '\'' +
                ", 생산지 ='" + legion + '\'' +
                ", 당도 =" + su +
                ", 가격 =" + price +
                '}';
    }

    // 객체의 동등성비교를 위해

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Fruit fruit = (Fruit) o;

        return su == fruit.su && price == fruit.price
                && Objects.equals(f, fruit.f) && Objects.equals(legion, fruit.legion);

    }


//    public boolean equals(Object obj) {
//        if(obj instanceof Fruit) {
//            Fruit e = (Fruit)obj;
//            if(f.equals(e.getF())
//                    && legion.equals(e.getLegion())
//                    && price == e.price
//                    && su == e.su) {
//
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(f, legion, su, price);
    }

    @Override
    public int compareTo(Fruit f){
        // 과일 이름으로 정렬하기
        // 정렬 알고리즘이 적용 + 0 -
        // + 자리변경
        // - 상태유지
        // - 상태유지
      //  return this.f.compareTo(f.f); // 이름 오름차순 정렬
      //  return price-f.price;
        if(price<f.price){
            return -1;
        }else if(price == f.price){
            return 0;
        }else
            return 1;
    }

}
