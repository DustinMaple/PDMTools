package com.maple.pdm.generator;

import com.maple.pdm.core.GeneratorAdapter;
import com.maple.pdm.core.GlobalParameter;
import com.maple.pdm.entity.Column;
import com.maple.pdm.entity.Table;
import com.maple.pdm.utils.FileUtil;

import java.io.File;

import static com.maple.pdm.constants.StringConstant.*;

/**
 * Created by gjf on 2016/10/19.
 */
public class MybatisResultMapGenerator extends GeneratorAdapter {
    @Override
    public void generateFile(Table table) {
        File file = new File(GlobalParameter.getInstance().getMapPath() + table.getJavaCode() + "Mapper.xml");

        boolean isReplace = false;

        if (file.exists() && isReplace) {
//            replaceFileContent();
        } else {
            FileUtil.initFile(file);
            FileUtil.appendToFile(file, createFileContent(table));
        }

    }

    /**
     * Write content to the file.
     *
     * @param table
     */
    public String createFileContent(Table table) {
        //Get the template of mybatis result map.
        StringBuffer buffer = new StringBuffer();

        buffer.append(MAP_HEAD);
        buffer.append(NEWLINE);
        buffer.append(createMapper(table));

        return buffer.toString();
    }

    private String createMapper(Table table) {
        StringBuffer buffer = new StringBuffer();

        String mapperName = GlobalParameter.getInstance().getMapperPackage() + "." + table.getJavaCode() + "Mapper";

        String mapperBegin = RESULT_MAP_MAPPER_BEGIN.replace(MAPPER_NAME, mapperName);

        buffer.append(mapperBegin);
        buffer.append(NEWLINE);

        buffer.append(createResultMap(table, TAB));

        buffer.append(RESULT_MAP_MAPPER_END);
        buffer.append(NEWLINE);


        return buffer.toString();
    }

    public String createResultMap(Table table, String tab){
        StringBuffer buffer = new StringBuffer();

        String pojo = GlobalParameter.getInstance().getPojoPackage() + "." + table.getJavaCode();
        String mapName = table.getJavaCode() + "ResultMap";
        String resultMapBegin = RESULT_MAP_BEGIN.replace(MAP_NAME, mapName).replace(POJO, pojo);

        buffer.append(tab);
        buffer.append(RESULT_MAP_BEGIN_COMMENT);
        buffer.append(NEWLINE);

        buffer.append(tab);
        buffer.append(resultMapBegin);
        buffer.append(NEWLINE);

        for (Column column : table.getColumnList()) {
            buffer.append(createResult(column, tab + TAB));
        }

        buffer.append(tab);
        buffer.append(RESULT_MAP_END);
        buffer.append(NEWLINE);

        buffer.append(tab);
        buffer.append(RESULT_MAP_END_COMMENT);
        buffer.append(NEWLINE);

        return buffer.toString();
    }

    private String createResult(Column column, String tab) {
        StringBuffer buffer = new StringBuffer();

        buffer.append(tab);
        if(column.isPrimaryKey()){
            buffer.append(RESULT_MAP_ID.replace(FIELD_NAME, column.getJavaCode()).replace(COLUMN_NAME, column.getCode()));
        }else{
            buffer.append(RESULT_MAP_FIELD.replace(FIELD_NAME, column.getJavaCode()).replace(COLUMN_NAME, column.getCode()));
        }
        buffer.append(NEWLINE);

        return buffer.toString();
    }
}
