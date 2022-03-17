package com.tledu.mybatis.mybatis.dao;

import com.tledu.mybatis.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAddressMapper {
    public void add(User user);
    public void getUserById(int id);
    public void deleteOneById(int id);
    public void updateById(User user);

    public User getUserById2(int id);
    //    模糊查询
    List<User> selectUserLike(@Param("username")String username);

    //    动态查询
    List<User> selectTest(@Param("user") User user);
    //    动态更新
    int updateTest(@Param("user") User user);
    //    动态插入
    int insertBatch(List<User> userList);
    //    动态删除
    int deleteBatch(List<Integer> idList);
}
