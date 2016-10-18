package com.maple.pdm.parser;

import com.maple.pdm.constants.PDMNodeContants;
import com.maple.pdm.core.Parser;
import com.maple.pdm.entity.Table;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class PDMParser implements Parser{
    private static final Logger log = LoggerFactory.getLogger(PDMParser.class);

    private static final PDMParser instance = new PDMParser();

    private PDMParser(){
    }

    public static PDMParser getInstance(){
        return instance;
    }

    /**
     * Parse the file to tables.
     * @param pdmFile
     * @return
     */
    public Table[] parse(File pdmFile) {
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(pdmFile);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        if(doc == null){
            log.error("The document {} is not exites", pdmFile.getAbsolutePath());
            return null;
        }

        return getTables(doc);
    }

    /**
     * Get tables from the document object.
     * @param doc
     * @return
     */
    private Table[] getTables(Document doc) {
        List<Table> tableList = new ArrayList<>();

        List tableElements = doc.selectNodes(PDMNodeContants.TABLE_NODE);

        if(tableElements.size() == 0){
            log.error("There is not any table in the file.");
        }
        Iterator iterator = tableElements.iterator();

        while(iterator.hasNext())
        {
            Element element = (Element) iterator.next();
            String tableName = element.elementTextTrim(PDMNodeContants.NAME);
            Table table = new Table();
            table.setName(tableName);
            tableList.add(table);
        }

        return tableList.toArray(new Table[tableList.size()]);
    }
}
