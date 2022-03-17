package com.tledu.mybatis.mybatis.dao;

import com.tledu.mybatis.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserMapper {
    //模糊查询
    public List<User> findFuzzy(@Param("username")String name);

    //批量插入
    int insertBatch(List<User> userList);

    //批量删除
    int deleteBatch(List<Integer> idList);

    //1对多，一次查询
    User getUserAndAddrById2(Integer id);
    //1对多，一次查询 优化
    User getUserAndAddrById3(Integer id);
}
