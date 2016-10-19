package com.maple.pdm.generator;

import com.maple.pdm.core.Generator;
import com.maple.pdm.enums.EnumFrameworkTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gjf on 2016/10/18.
 */
public class GeneratorFactory {
    private static final Logger log = LoggerFactory.getLogger(GeneratorFactory.class);

    public static Generator getGenerator(EnumFrameworkTypes frameworkType) {
        switch (frameworkType) {
            case MYBATIS:
                return new MybatisGenerator();
            default:
                log.error("Don't support the framework type.({})", frameworkType.toString());
                return null;
        }
    }
}
