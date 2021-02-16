package com.generic.controller;

public class MyGeneric<T> {

    private T tmp;

    public MyGeneric() {
    }

    public MyGeneric(T tmp) {
        this.tmp = tmp;
    }

    public void setTmp(T tmp ){
        this.tmp = tmp;
    }

    public T getTmp(){
      return tmp;
    }

}
