package com.example.user.ormlitelibrary.Dao;

import android.content.Context;

import com.example.user.ormlitelibrary.SqlLiteHelper;
import com.example.user.ormlitelibrary.module.User;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Copyright  : 2015-2033 Beijing Startimes Communication & Network Technology Co.Ltd
 * <p/>
 * Created by xiongl on 2016/6/10..
 * ClassName  :
 * Description  :
 */
public class UserDao {
    private Context context;
    private Dao<User,Integer> dao;
    private SqlLiteHelper sqlLiteHelper;
    public UserDao(Context context){
        this.context = context;
        try {
            sqlLiteHelper = SqlLiteHelper.getInstance(context);
            dao = sqlLiteHelper.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增
     */
    public void addUser(User user){
        try {
            dao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删
     */
    public void deeleteUserById(int id){
        try {
            dao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新表
     */
    public void updateUser(User user){
        try {
            dao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有
     */
    public List<User> queryAll(){
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public User queryById(int id){
        try {
            return (User)dao.queryForId(new Integer(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
