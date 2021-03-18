package com.example.book.demo.Mapper;


import com.example.book.demo.Model.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    @Insert("insert into book(name,author,type,price,content,uid,publisher,publishTime,version,depreciationRate,remark,state,ISBN)" +
            " values(#{name},#{author},#{type},#{price},#{content},#{uid},#{publisher},#{publishTime},#{version},#{depreciationRate},#{remark},0,#{ISBN})")
    void addBook(String name, String author, String type, String price, String content,int uid, String publisher, String publishTime, String version, double depreciationRate, String remark,String ISBN);


    @Select("select * from book")
    List<Book> getBooks();
}
