package com.maple.pdm.generator;

import com.maple.pdm.core.Generator;
import com.maple.pdm.entity.Table;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class MybatisGenerator implements Generator {
    @Override
    public void generateFile(String path, Table table) {
        generateJavaFile(path, table);
        generateResultMapFile(path, table);
    }

    /**
     * Generate result map for mybatis framework.
     * @param path
     * @param table
     */
    private void generateResultMapFile(String path, Table table) {
    }

    /**
     * Generate the pojo file.
     * @param path
     * @param table
     */
    private void generateJavaFile(String path, Table table) {
    }
}
