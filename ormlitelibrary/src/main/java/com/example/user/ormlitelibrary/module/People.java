package com.example.user.ormlitelibrary.module;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Copyright  : 2015-2033 Beijing Startimes Communication & Network Technology Co.Ltd
 * <p/>
 * Created by xiongl on 2016/6/10..
 * ClassName  :
 * Description  :
 */
@DatabaseTable(tableName = "tb_people")
public class People {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "age")
    private int age;
    @DatabaseField(canBeNull = true, foreign = true, columnName = "user_id")
    //canBeNull= true 不能为null, foreign= true 是外键
    private User user;

    public People(){};

    public People(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    @Override
    public String toString() {
        return "id= "+id+"... name="+name+"...age="+age;
    }
}
