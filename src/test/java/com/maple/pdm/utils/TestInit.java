package com.maple.pdm.utils;

import com.maple.pdm.entity.Column;
import com.maple.pdm.entity.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gjf on 2016/10/21.
 */
public class TestInit {
    public static Table getTestTable(){
        List<Column> list = new ArrayList<>();
        Column column1 = new Column();
        column1.setType("bigint");
        column1.setJavaType("long");
        column1.setName("主键");
        column1.setJavaCode("id");
        column1.setPrimaryKey(true);
        column1.setCode("f_id");
        column1.setComment("主键");
        Column column2 = new Column();
        column2.setType("varchar(32)");
        column2.setJavaType("String");
        column2.setName("姓名");
        column2.setJavaCode("name");
        column2.setPrimaryKey(false);
        column2.setCode("f_name");
        column2.setComment("姓名");

        list.add(column1);
        list.add(column2);


        Table table = new Table();
        table.setCode("t_test");
        table.setJavaCode("Test");
        table.setName("测试");
        table.setColumnList(list);

        return table;
    }
}
