package com.maple.pdm.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class Table {
    private String name;
    private String javaCode;
    private String code;
    private List<Column> columnList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

    public String getJavaCode() {
        return javaCode;
    }

    public void setJavaCode(String javaCode) {
        this.javaCode = javaCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", javaCode='" + javaCode + '\'' +
                ", columnList=" + columnList +
                '}';
    }
}
