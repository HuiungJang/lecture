package com.generic.model.dao;

import com.generic.model.vo.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private static List<Book> totalBook = new ArrayList();

    static  {
        totalBook.add(new Book("one","유병승",10000,0.2));
        totalBook.add(new Book("two","김상현",12000,0.5));
        totalBook.add(new Book("three","유병승",300000,1.2));
        totalBook.add(new Book("four","김예진",10000,2.2));
    }

    public static List<Book> getTotalBook() {
        return totalBook;
    }


}
