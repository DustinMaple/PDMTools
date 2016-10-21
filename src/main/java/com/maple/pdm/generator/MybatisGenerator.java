package com.maple.pdm.generator;

import com.maple.pdm.core.GeneratorAdapter;
import com.maple.pdm.entity.Table;
import com.maple.pdm.enums.EnumFrameworkTypes;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class MybatisGenerator extends GeneratorAdapter {
    @Override
    public void generateFile(Table table) {
        GeneratorFactory.getGenerator(EnumFrameworkTypes.JAVA).generateFile(table);
        GeneratorFactory.getGenerator(EnumFrameworkTypes.MAPPER).generateFile(table);
        GeneratorFactory.getGenerator(EnumFrameworkTypes.RESULTMAP).generateFile(table);
    }
}
