package com.maple.pdm.core;

import com.maple.pdm.entity.Table;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public interface Generator {

    /**
     * Generate the file in the path.
     * @param table
     */
    void generateFile(Table table);
}
