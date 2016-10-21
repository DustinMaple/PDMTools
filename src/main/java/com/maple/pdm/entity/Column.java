package com.maple.pdm.entity;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class Column {
    private String name;
    private String code;
    private String comment;
    private String type;
    private boolean primaryKey;
    private String javaType;
    private String javaCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJavaCode() {
        return javaCode;
    }

    public void setJavaCode(String javaCode) {
        this.javaCode = javaCode;
    }

    @Override
    public String toString() {
        return "Column{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", comment='" + comment + '\'' +
                ", type='" + type + '\'' +
                ", primaryKey=" + primaryKey +
                ", javaType='" + javaType + '\'' +
                ", javaCode='" + javaCode + '\'' +
                '}';
    }
}
