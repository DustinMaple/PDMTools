package com.maple.pdm.enums;

/**
 * Created by gjf on 2016/10/18.
 */
public enum EnumFrameworkTypes {
    MYBATIS(1, "mybatis");

    int key;
    String value;

    EnumFrameworkTypes(int key, String value){
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public EnumFrameworkTypes getEnumByKey(int key){
        for(EnumFrameworkTypes e : EnumFrameworkTypes.values()){
            if(e.getKey() == key){
                return e;
            }
        }
        return null;
    }
}
