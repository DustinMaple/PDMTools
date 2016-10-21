package com.maple.pdm.generator;

import com.maple.pdm.core.GlobalParameter;
import com.maple.pdm.utils.TestInit;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by gjf on 2016/10/21.
 */
@Ignore
public class TestMybatisResultMapGenerator {
    @Test
    public void testCreateFileContent(){
        GlobalParameter.getInstance().init(true, "E:/pdmToolTest/test.pdm", "e:/pdmToolTest/java", "com.pojo", "com.mapper", "e:/pdmToolTest/resources");
        MybatisResultMapGenerator generator = new MybatisResultMapGenerator();
        String fileContent = generator.createFileContent(TestInit.getTestTable());
        System.out.println(fileContent);
    }

    @Test
    public void testGenerateFile(){
        GlobalParameter.getInstance().init(true, "E:/pdmToolTest/test.pdm", "e:/pdmToolTest/java", "com.pojo", "com.mapper", "e:/pdmToolTest/resources");
        MybatisResultMapGenerator generator = new MybatisResultMapGenerator();
        generator.generateFile(TestInit.getTestTable());
    }
}
