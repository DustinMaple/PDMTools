package com.maple.pdm.generator;

import com.maple.pdm.core.Generator;
import com.maple.pdm.core.GeneratorAdapter;
import com.maple.pdm.entity.Table;
import com.maple.pdm.enums.EnumFrameworkTypes;


/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class MybatisGenerator extends GeneratorAdapter{
    @Override
    public void generateFile(String javaFilePath, String configFilePath, Table table) {
        Generator javaFileGenerator = GeneratorFactory.getGenerator(EnumFrameworkTypes.JAVA);
        Generator resultMapGenerator = GeneratorFactory.getGenerator(EnumFrameworkTypes.RESULTMAP);

        if(javaFileGenerator != null && resultMapGenerator != null){
            javaFileGenerator.generateFile(javaFilePath, table);
            resultMapGenerator.generateFile(configFilePath, table);
        }
    }
}
