package com.maple.pdm.parser;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by gjf on 2016/10/19.
 */
@Ignore
public class TestTextParser {
    @Test
    public void testParseTextToJava(){
        System.out.println(TextParser.getInstance().parseJavaText("t_student", true, false));
        System.out.println(TextParser.getInstance().parseJavaText("t_student_test", true, false));
    }
}
