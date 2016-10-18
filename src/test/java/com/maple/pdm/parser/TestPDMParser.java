package com.maple.pdm.parser;

import com.maple.pdm.entity.Table;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by gjf on 2016/10/18.
 */
@Ignore
public class TestPDMParser {
    private static final Logger log = LoggerFactory.getLogger(TestPDMParser.class);

    @Test
    public void testPDMFileReader() throws DocumentException {
        File pdmFile = new File("E:/test.pdm");
        if(!pdmFile.exists()){
            log.error("File {} is not exists.", pdmFile.getAbsolutePath());
            return;
        }

        SAXReader reader = new SAXReader();
        Document doc = reader.read(pdmFile);
    }

    @Test
    public void testParser(){
        File pdmFile = new File("E:/test.pdm");
        if (pdmFile.exists()) {
            Table[] tables = PDMParser.getInstance().parse(pdmFile);
            log.info("table array length is {}", tables.length);
        } else {
            log.error("File {} is not exist.", pdmFile);
        }
    }

}
