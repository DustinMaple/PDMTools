package com.maple.pdm;

import com.maple.pdm.core.Generator;
import com.maple.pdm.core.GlobalParameter;
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

    //none ui
    public static void main(String[] args) {
        PDMTool tool = new PDMTool();

        //Initial the parameter.
        GlobalParameter.getInstance().initByConfig();

        tool.runTools();
    }

    public PDMTool(){}

    private void runTools() {
        /* Run a graphic interface to get all path parameter. */

        GlobalParameter globalParameter = GlobalParameter.getInstance();

        //Defination
        Generator generator = GeneratorFactory.getGenerator(EnumFrameworkTypes.MYBATIS);
        Table[] tableArray = null;
        File pdmFile = new File(globalParameter.getPdmPath());

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
                generator.generateFile(table);
                log.info("Generate table({}) completed.", table.getJavaCode());
            }
        }
    }

}
