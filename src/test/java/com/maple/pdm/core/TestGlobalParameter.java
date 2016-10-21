package com.maple.pdm.core;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by gjf on 2016/10/22.
 */
@Ignore
public class TestGlobalParameter {
    @Test
    public void testInitByConfig(){
        GlobalParameter instance = GlobalParameter.getInstance();
        instance.initByConfig();
        System.out.println(instance.getJavaRootSrc());
    }
}
