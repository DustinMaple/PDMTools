package com.maple.pdm.generator;

import com.maple.pdm.core.Generator;
import com.maple.pdm.core.GlobalParameter;
import com.maple.pdm.entity.Table;
import com.maple.pdm.enums.EnumFrameworkTypes;
import com.maple.pdm.utils.TestInit;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by gjf on 2016/10/22.
 */
@Ignore
public class TestMybatisMapperGenerator {
    @Test
    public void testGenerate(){
        GlobalParameter.getInstance().initByConfig();
        Table testTable = TestInit.getTestTable();
        Generator generator = GeneratorFactory.getGenerator(EnumFrameworkTypes.MAPPER);
        generator.generateFile(testTable);
    }
}
