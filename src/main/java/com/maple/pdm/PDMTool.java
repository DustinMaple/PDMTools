package com.maple.pdm;

import com.maple.pdm.core.Generator;
import com.maple.pdm.entity.Table;
import com.maple.pdm.enums.EnumFrameworkTypes;
import com.maple.pdm.generator.GeneratorFactory;
import com.maple.pdm.parser.PDMParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class PDMTool {
    private static final Logger log = LoggerFactory.getLogger(PDMTool.class);


    String pdmPath = "E:/pdmToolTest/test.pdm";
    String javaFilePath = "E:/pdmToolTest/";
    String configFilePath = "E:/pdmToolTest/";

    //none ui
    public static void main(String[] args) {
        PDMTool tool = new PDMTool();
        tool.runTools();
    }

    public PDMTool(){}

    public PDMTool(String pdmPath, String javaFilePath, String configFilePath){
        this.pdmPath = pdmPath;
        this.javaFilePath = javaFilePath;
        this.configFilePath = configFilePath;
    }

    private void runTools() {
        /* Run a graphic interface to get all path parameter. */


        //Defination
        Generator generator = GeneratorFactory.getGenerator(EnumFrameworkTypes.MYBATIS);
        Table[] tableArray = null;
        File pdmFile = new File(pdmPath);

        //Parse
        if (pdmFile.exists()) {
            tableArray = PDMParser.getInstance().parse(pdmFile);
        } else {
            log.error("File {} is not exist.", pdmFile);
        }
        if(tableArray != null && tableArray.length > 0){
            log.info("Pdm file parsing have success.");
        }

        //Generate file.
        if(generator != null){
            for(Table table : tableArray){
                generator.generateFile(javaFilePath, configFilePath, table);
                log.info("Generate table({}) completed.", table.getJavaCode());
            }
        }
    }

}
