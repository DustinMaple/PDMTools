package com.maple.pdm.parser;

import com.maple.pdm.constants.PDMNodeContants;
import com.maple.pdm.core.GlobalParameter;
import com.maple.pdm.core.Parser;
import com.maple.pdm.entity.Column;
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

import static com.maple.pdm.constants.PDMNodeContants.*;
/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class PDMParser implements Parser {
    private static final Logger log = LoggerFactory.getLogger(PDMParser.class);

    private static final PDMParser instance = new PDMParser();

    private PDMParser() {
    }

    public static PDMParser getInstance() {
        return instance;
    }

    /**
     * Parse the file to tables.
     *
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

        if (doc == null) {
            log.error("The document {} is not exites", pdmFile.getAbsolutePath());
            return null;
        }

        return getTables(doc);
    }

    /**
     * Get tables from the document object.
     *
     * @param doc
     * @return
     */
    private Table[] getTables(Document doc) {
        List<Table> tableList = new ArrayList<>();

        List tableElements = doc.selectNodes(PDMNodeContants.TABLE_NODE);

        if (tableElements.size() == 0) {
            log.error("There is not any table in the file.");
        }
        Iterator iterator = tableElements.iterator();

        Element element = null;
        Table table = null;
        while (iterator.hasNext()) {
            table = new Table();
            element = (Element) iterator.next();

            table.setName(element.elementTextTrim(PDMNodeContants.NAME));
            table.setCode(element.elementText(PDMNodeContants.CODE));
            table.setJavaCode(TextParser.getInstance().parseJavaText(table.getCode(), GlobalParameter.getInstance().isRemovePrefix(), true));
            table.setColumnList(getColumns(element));
            tableList.add(table);
        }

        return tableList.toArray(new Table[tableList.size()]);
    }

    /**
     * Get all column elements.
     *
     * @param element
     * @return
     */
    private List<Column> getColumns(Element element) {
        List<Column> columnList = new ArrayList<>();
        Column column = null;
        Iterator iterator = element.element(PDMNodeContants.COLUMNS).elements(PDMNodeContants.COLUMN).iterator();

        while (iterator.hasNext()) {
            column = new Column();

            Element columnElement = (Element) iterator.next();
            String columnId = columnElement.attributeValue(PDMNodeContants.ID);
            Iterator keyIterator = element.element(KEYS).elements(KEY).iterator();
            Element key = null;
            boolean isPrimary = false;

            while (keyIterator.hasNext()){
                key = (Element) keyIterator.next();
                isPrimary = key.attributeValue(ID).equalsIgnoreCase(element.element(PRIMARY).element(KEY).attributeValue(REF))
                        && key.element(KEYCOLUMNS).element(COLUMN).attributeValue(REF).equalsIgnoreCase(columnId);
            }

            log.debug("Column id:{}, primary ref:{}", columnId, element.element(PRIMARY).element(KEY).attributeValue(REF));

            column.setName(columnElement.elementTextTrim(NAME));
            column.setCode(columnElement.elementTextTrim(CODE));
            column.setComment(columnElement.elementTextTrim(COMMENT));
            column.setType(columnElement.elementTextTrim(TYPE));
            column.setPrimaryKey(isPrimary);
            column.setJavaType(TypeParser.getInstance().parseType(column.getType()));
            column.setJavaCode(TextParser.getInstance().parseJavaText(column.getCode(), GlobalParameter.getInstance().isRemovePrefix(), false));

            log.debug("Column {} is Primary Key?{}", column.getCode(), isPrimary);

            columnList.add(column);
        }

        return columnList;
    }


}
