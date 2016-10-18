package com.maple.pdm;

import com.maple.pdm.entity.Table;
import com.maple.pdm.parser.PDMParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class PDMTool {
    private static final Logger log = LoggerFactory.getLogger(PDMTool.class);


    String pdm_path = "E:/test.pdm";
    String project_path = "E:\\PDMTools\\";
    String middle_path = "src\\main\\java\\com\\pojo\\";
    String mapper_path = "resource\\mapper\\";

    //none ui
    public static void main(String[] args) {


        PDMTool tool = new PDMTool();

        tool.run();

    }

    private void run() {
        /* Run a graphic interface to get all path parameter. */

        String generate_class_file_to = "";
        String generate_config_file_to = "";

        File pdmFile = new File(pdm_path);
        if (pdmFile.exists()) {
            Table[] tableList = PDMParser.getInstance().parse(pdmFile);
        } else {
            log.error("File {} is not exist.", pdmFile);
        }

    }

}
