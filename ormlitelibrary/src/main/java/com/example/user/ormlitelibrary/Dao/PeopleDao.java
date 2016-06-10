package com.example.user.ormlitelibrary.Dao;

import android.content.Context;

import com.example.user.ormlitelibrary.SqlLiteHelper;
import com.example.user.ormlitelibrary.module.People;
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
public class PeopleDao {
    private Context context;
    private Dao<People, Integer> dao;
    private SqlLiteHelper sqlLiteHelper;

    public PeopleDao(Context context) {
        this.context = context;
        try {
            sqlLiteHelper = SqlLiteHelper.getInstance(context);
            dao = sqlLiteHelper.getDao(People.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增
     */
    public void addPeople(People people) {
        try {
            dao.create(people);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删
     */
    public void deeletePeopleById(int id) {
        try {
            dao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新表
     */
    public void updatePeople(People people) {
        try {
            dao.update(people);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有
     */
    public List<People> queryAll() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id查询
     * 获取的User信息只有id
     * @param id
     * @return
     */
    public People queryById(int id) {
        try {
            return (People) dao.queryForId(new Integer(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取People以及其属性User的详细信息
     * @param id
     * @return
     */
    public People queryWithUserById(int id) {
        People people = null;
        try {
            people = (People) dao.queryForId(new Integer(id));
            sqlLiteHelper.getDao(User.class).refresh(people.getUser()); //同步
            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<People> queryByUserId(int userId){
        try {
            return dao.queryBuilder().where().eq("user_id", userId).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
