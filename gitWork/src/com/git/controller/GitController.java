package com.git.controller;

import java.util.Date;
import java.util.GregorianCalendar;

public class GitController {
    public void testPrint(){
        System.out.println("프린트하는 것");
    }
    public int calcPlus(int su1, int su2){
        System.out.println(su1+su2);
        return su1+su2;
    }

    public String concatTest(String a, String b){
        return a+b;
    }

    public double avgCalc(int a, int b, int c){
        return (a+b+c)/3.0;
    }

    public Date birthDay(int year, int month, int day){
        return new Date(new GregorianCalendar(year,month,day).getTimeInMillis());
    }
}
