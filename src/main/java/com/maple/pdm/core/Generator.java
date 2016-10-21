package com.maple.pdm.core;

import com.maple.pdm.entity.Table;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public interface Generator {

    /**
     * Generate the file in the path.
     * @param javaFilePath
     * @param configFilePath
     * @param table
     */
    void generateFile(String javaFilePath, String configFilePath, Table table);

    /**
     * Generate the file in the path.
     * @param path
     * @param table
     */
    void generateFile(String path, Table table);


}
