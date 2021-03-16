package com.example.book.demo.Service;


import org.springframework.stereotype.Service;

@Service
public interface BookService {


    void addBook(String name, String author, String type, String price, String content,int uid, String publisher, String publishTime, String version, double depreciationRate, String remark);

    Object getBooks();
}
