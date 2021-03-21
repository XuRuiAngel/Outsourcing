package com.example.user.Mapper;



import com.example.user.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    @Select("select * from user where studentId=#{studentId}")
    User login(@Param("studentId") String studentId);

    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(name,tel,type,college,sex,major,classNum,studentId,password,account) values (#{name},#{tel},0,#{college},#{sex},#{major},#{classNum},#{studentId},#{password},0)")
    void registUser(String name, String tel, String college, String sex, String major, String classNum, String studentId, String password);
}
