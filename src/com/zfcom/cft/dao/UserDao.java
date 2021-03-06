package com.zfcom.cft.dao;

import com.zfcom.cft.entity.User;
import com.zfcom.cft.utils.Constants;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("select * from " + Constants.TABLE_USER +
            " where name = #{name} and password = #{password} and project='ControlJsp'")
    User selectByNameAndPassword(User user);



}
