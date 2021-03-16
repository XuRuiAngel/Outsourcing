package com.example.book.demo.Controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.example.book.demo.Annotation.PassToken;
import com.example.book.demo.Annotation.UserLoginToken;
import com.example.book.demo.Service.BookService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @UserLoginToken
    @RequestMapping(value = "/addBook",method = RequestMethod.POST)
    @ResponseBody
    public Object addBook(HttpServletRequest request,String name, String author, String type, String price, String content, String publisher, String publishTime, String version, double depreciationRate, String remark){
        String token  =  request.getHeader("token");
        int id=Integer.parseInt(JWT.decode(token).getAudience().get(0)) ;

        bookService.addBook(name,author,type,  price, content, id, publisher, publishTime,  version,  depreciationRate,  remark);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("message","添加书籍成功");
        jsonObject.put("status","1");
        return jsonObject;
    }

    @UserLoginToken
    @RequestMapping(value = "/getBooks",method = RequestMethod.GET)
    @ResponseBody
    public  Object getBooks(){
        return bookService.getBooks();
    }

}
