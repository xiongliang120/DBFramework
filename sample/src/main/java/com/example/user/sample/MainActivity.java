package com.example.user.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.ormlitelibrary.Dao.PeopleDao;
import com.example.user.ormlitelibrary.Dao.UserDao;
import com.example.user.ormlitelibrary.SqlLiteHelper;
import com.example.user.ormlitelibrary.module.People;
import com.example.user.ormlitelibrary.module.User;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add();
    }

    public void add() {
        PeopleDao peopleDao = new PeopleDao(this);
        UserDao userDao = new UserDao(this);

        User user = new User("熊亮","北京");
        userDao.addUser(user);

        People people = new People("aa",23);
        people.setUser(user);
        peopleDao.addPeople(people);
    }

    public void delete(){
        PeopleDao peopleDao = new PeopleDao(this);
        peopleDao.deeletePeopleById(1);
    }

    public void update(){
        PeopleDao peopleDao = new PeopleDao(this);
        People people1 = new People("ff",23);
        people1.setId(2);
        peopleDao.updatePeople(people1);
    }

    public void queryPeople(){
        PeopleDao peopleDao = new PeopleDao(this);
        //People people = peopleDao.queryWithUserById(1);
        List<People> list = peopleDao.queryByUserId(1);
        Log.i("msg", list.size() + "");
    }

    public void queryUser(){
        UserDao userDao = new UserDao(this);
        User user = userDao.queryById(1);
        List<People> list = user.getPeopleList();
        Log.i("msg",((People)list.get(0)).toString());
    }
}
