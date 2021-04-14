package com.git.run;

import com.git.controller.GitController;
import com.git.model.vo.Person;

public class Main {
    public static void main(String[] args) {
        new GitController().calcPlus(10,20);

        Person p = new Person();
        System.out.println(p);
    }
}
