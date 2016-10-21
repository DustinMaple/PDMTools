package com.maple.pdm.utils;

import com.maple.pdm.constants.StringConstant;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by gjf on 2016/10/19.
 */
@Ignore
public class TestFileUtil {
    @Test
    public void testAppendFile() throws IOException {
        File file = new File("e:/test.java");
        if(!file.exists()){
            file.createNewFile();
        }else{
            FileUtil.clearFile(file);
        }

        String str = "public class Test{" + StringConstant.NEWLINE
                + StringConstant.NEWLINE
                + "}";

        //Write a java file.
        FileUtil.appendToFile(file, str);
    }
}
