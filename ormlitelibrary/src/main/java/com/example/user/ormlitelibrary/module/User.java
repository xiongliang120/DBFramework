package com.example.user.ormlitelibrary.module;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

/**
 * Copyright  : 2015-2033 Beijing Startimes Communication & Network Technology Co.Ltd
 * <p/>
 * Created by xiongl on 2016/6/10..
 * ClassName  :
 * Description  :
 */
@DatabaseTable(tableName = "tb_xionglaing")
public class User {
    @DatabaseField(generatedId = true)    //id为主键,且自动生成
    private int id;
    @DatabaseField(columnName = "name") //该字段在数据库中的列名
    private String name;
    @DatabaseField(columnName = "address")
    private String address;
//    @ForeignCollectionField
    private List<People> peopleList;

    public User(){}

    public User(String name,String address){
        this.name = name;
        this.address = address;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "id="+id+"..name= "+name+"...address="+address;
    }

    public List<People> getPeopleList(){
        return peopleList;
    }
}
