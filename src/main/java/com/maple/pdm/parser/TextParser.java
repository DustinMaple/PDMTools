package com.maple.pdm.parser;

import com.maple.pdm.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gjf on 2016/10/19.
 */
public class TextParser {
    private static final Logger log = LoggerFactory.getLogger(TextParser.class);

    private static final TextParser instance = new TextParser();

    private TextParser() {
    }

    public static TextParser getInstance(){
        return instance;
    }

    /**
     * Transform the text of pdm file to java file format.
     * @param pdmText the pdm content
     * @param removeThePrefix Is will remove the prefix of the text?
     * @param firstIsUpcase Is the first char upcase?
     * @return
     */
    public String parseJavaText(String pdmText, boolean removeThePrefix, boolean firstIsUpcase){
        StringBuffer buffer = new StringBuffer();

        int index = 0;
        if(removeThePrefix) ++index;

        String[] words = pdmText.split("_");

        if(!firstIsUpcase) {
            buffer.append(words[index]);
            ++index;
        }

        for(;index < words.length ; ++index){
            buffer.append(StringUtil.capitalToUpperCase(words[index]));
        }

        return buffer.toString();
    }
}
