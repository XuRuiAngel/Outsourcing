package com.example.book.demo.Service.ServiceImpl;


import com.example.book.demo.Mapper.BookMapper;
import com.example.book.demo.Model.Book;
import com.example.book.demo.Service.BookService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;


    @Override
    public void addBook(String name, String author, String type, String price, String content, int uid, String publisher, String publishTime, String version, double depreciationRate, String remark, String ISBN) {
        bookMapper.addBook(name, author, type, price, content, uid, publisher, publishTime, version, depreciationRate, remark, ISBN);
    }

    @Override
    public Object getBooks() {

        List<Book> books = bookMapper.getBooks();
        JSONObject result = new JSONObject();
        result.put("state", 1);
        JSONArray jsonArray = new JSONArray();
        for (Book book : books) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", book.getId());
            jsonObject.put("name", book.getName());
            jsonObject.put("author", book.getAuthor());
            jsonObject.put("type", book.getType());
            jsonObject.put("price", book.getPrice());
            jsonObject.put("content", book.getContent());
            jsonObject.put("uid", book.getUid());
            jsonObject.put("publisher", book.getPublisher());
            jsonObject.put("publisherTime", book.getPublishTime());
            jsonObject.put("version", book.getVersion());
            jsonObject.put("depreciationRage", book.getDepreciationRate());
            jsonObject.put("remark", book.getRemark());
            jsonObject.put("state", book.getState());

            jsonArray.add(jsonObject);
        }
        result.put("data", jsonArray);
        return result;
    }
}
