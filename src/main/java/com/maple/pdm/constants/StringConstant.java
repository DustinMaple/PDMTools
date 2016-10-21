package com.maple.pdm.constants;

/**
 * Created by gjf on 2016/10/19.
 */
public class StringConstant {
    public static final String NEWLINE = "\r\n";
    public static final String TAB = "\t";

    //mybatis result map template
    public static final String MAP_HEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
            NEWLINE +
            "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">";
    public static final String RESULT_MAP_BEGIN_COMMENT = "<!-- result map begin -->";
    public static final String RESULT_MAP_END_COMMENT = "<!-- result map end -->";
    public static final String RESULT_MAP_BEGIN = "<resultMap id=\"{#mapName}\" type=\"{#pojo}\">";
    public static final String RESULT_MAP_END = "</resultMap>";
    public static final String RESULT_MAP_FIELD = "<result property=\"{#fieldName}\" column=\"{#columnName}\"/>";
    public static final String RESULT_MAP_ID = "<id property=\"{#fieldName}\" column=\"{#columnName}\"/>";
    public static final String RESULT_MAP_MAPPER_BEGIN = "<mapper namespace=\"{#mapperName}\">";
    public static final String RESULT_MAP_MAPPER_END = "</mapper>";

    //template key word
    public static final String MAPPER_NAME = "{#mapperName}";
    public static final String MAP_NAME = "{#mapName}";
    public static final String POJO = "{#pojo}";
    public static final String FIELD_NAME = "{#fieldName}";
    public static final String COLUMN_NAME = "{#columnName}";

}
