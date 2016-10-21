package com.maple.pdm.generator;

import com.maple.pdm.constants.StringConstant;
import com.maple.pdm.core.GeneratorAdapter;
import com.maple.pdm.core.GlobalParameter;
import com.maple.pdm.entity.Column;
import com.maple.pdm.entity.Table;
import com.maple.pdm.parser.TypeParser;
import com.maple.pdm.utils.FileUtil;
import com.maple.pdm.utils.StringUtil;

import java.io.File;
import java.util.List;

/**
 * Created by gjf on 2016/10/19.
 */
public class JavaFileGenerator extends GeneratorAdapter {
    @Override
    public void generateFile(Table table) {
        File file = new File(GlobalParameter.getInstance().getPojoPath() + table.getJavaCode() + ".java");
        FileUtil.initFile(file);
        StringBuilder fileContent = new StringBuilder();

        //package
        fileContent.append("package ");
        fileContent.append(GlobalParameter.getInstance().getPojoPackage());
        fileContent.append(";");
        fileContent.append(StringConstant.NEWLINE);
        fileContent.append(StringConstant.NEWLINE);

        fileContent.append("public class ");
        fileContent.append(table.getJavaCode()).append("{");
        fileContent.append(StringConstant.NEWLINE);
        fileContent.append(generateJavaFieled(table.getColumnList(), StringConstant.TAB));
        fileContent.append(StringConstant.NEWLINE);
        fileContent.append("}");

        FileUtil.appendToFile(file, fileContent.toString());
    }

    /**
     * exp:
     * private String name;
     *
     * public void setName(String name){
     *     this.name = name;
     * }
     *
     * public String getName(){
     *     return this.name;
     * }
     * @param columnList
     * @return
     */
    private String generateJavaFieled(List<Column> columnList, String tab) {
        StringBuffer buffer = new StringBuffer();

        for(Column column : columnList){
            buffer.append(defineField(column, tab));
            buffer.append(defineGetter(column, tab));
            buffer.append(defineSetter(column, tab));
        }

        return buffer.toString();
    }

    private String defineSetterContent(Column column, String tab) {
        StringBuffer buffer = new StringBuffer();

        buffer.append(tab);
        buffer.append("this.");
        buffer.append(column.getJavaCode());
        buffer.append(" = ");
        buffer.append(column.getJavaCode());
        buffer.append(";");

        return buffer.toString();
    }

    private String defineGetterContent(Column column, String tab) {
        StringBuffer buffer = new StringBuffer();

        buffer.append(tab);
        buffer.append("return this.");
        buffer.append(column.getJavaCode());
        buffer.append(";");

        return buffer.toString();
    }

    private String defineSetter(Column column, String tab) {
        StringBuffer buffer = new StringBuffer();

        buffer.append(tab);
        buffer.append("public void ");
        buffer.append("set");
        buffer.append(StringUtil.capitalToUpperCase(column.getJavaCode()));
        buffer.append("(");
        buffer.append(column.getJavaType());
        buffer.append(" ");
        buffer.append(column.getJavaCode());
        buffer.append("){");
        buffer.append(StringConstant.NEWLINE);
        buffer.append(defineSetterContent(column, tab + StringConstant.TAB));
        buffer.append(StringConstant.NEWLINE);
        buffer.append(tab);
        buffer.append("}");
        buffer.append(StringConstant.NEWLINE);
        buffer.append(StringConstant.NEWLINE);

        return buffer.toString();
    }

    private String defineGetter(Column column, String tab) {
        StringBuffer buffer = new StringBuffer();

        buffer.append(tab);
        buffer.append("public ");
        buffer.append(column.getJavaType());
        buffer.append(" ");
        buffer.append("get");
        buffer.append(StringUtil.capitalToUpperCase(column.getJavaCode()));
        buffer.append("(");
        buffer.append(column.getJavaType());
        buffer.append(" ");
        buffer.append(column.getJavaCode());
        buffer.append("){");
        buffer.append(StringConstant.NEWLINE);
        buffer.append(defineGetterContent(column, tab + StringConstant.TAB));
        buffer.append(StringConstant.NEWLINE);
        buffer.append(tab);
        buffer.append("}");
        buffer.append(StringConstant.NEWLINE);
        buffer.append(StringConstant.NEWLINE);

        return buffer.toString();
    }

    private String defineField(Column column, String tab) {
        StringBuffer buffer = new StringBuffer();

        buffer.append(tab);
        buffer.append("private ");
        buffer.append(TypeParser.getInstance().parseType(column.getType()));
        buffer.append(" ");
        buffer.append(column.getJavaCode());
        buffer.append(";");
        if(column.getComment() != null){
            buffer.append("//");
            buffer.append(column.getComment());
        }
        buffer.append(StringConstant.NEWLINE);
        buffer.append(StringConstant.NEWLINE);

        return buffer.toString();
    }
}
