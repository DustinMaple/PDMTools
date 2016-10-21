package com.maple.pdm.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gjf on 2016/10/19.
 */
public class TypeParser{
    private static final Logger log = LoggerFactory.getLogger(TextParser.class);

    private static final TypeParser instance = new TypeParser();

    private TypeParser() {
    }

    public static TypeParser getInstance(){
        return instance;
    }

    public String parseType(String pdmType){
        if(pdmType.equalsIgnoreCase("bigint")){
            return "long";
        }
        if(pdmType.equalsIgnoreCase("int")){
            return "int";
        }
        return "String";
    }
}
