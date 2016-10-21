package com.maple.pdm.generator;

import com.maple.pdm.core.GeneratorAdapter;
import com.maple.pdm.core.GlobalParameter;
import com.maple.pdm.entity.Table;
import com.maple.pdm.utils.FileUtil;

import java.io.File;
import static com.maple.pdm.constants.StringConstant.*;

/**
 * Created by gjf on 2016/10/22.
 */
public class MybatisMapperGenerator extends GeneratorAdapter{
    @Override
    public void generateFile(Table table) {
        String fileName = table.getJavaCode()+ "Mapper.java";
        File file = new File(GlobalParameter.getInstance().getMapperPath() + fileName);

        if(!file.exists()){
            FileUtil.initFile(file);
            FileUtil.appendToFile(file, createMapperFileContent(table.getJavaCode()));
        }
    }

    /**
     * Create the content of mapper.
     * @param className
     * @return
     */
    private String createMapperFileContent(String className) {
        StringBuffer buffer = new StringBuffer();

        //package
        buffer.append("package ");
        buffer.append(GlobalParameter.getInstance().getMapperPackage());
        buffer.append(";");
        buffer.append(NEWLINE);
        buffer.append(NEWLINE);

        //class
        buffer.append("public class ");
        buffer.append(className);
        buffer.append("Mapper");
        buffer.append(" {");
        buffer.append(NEWLINE);
        buffer.append(NEWLINE);
        buffer.append("}");

        return buffer.toString();
    }
}
