package com.maple.pdm.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by gjf on 2016/10/19.
 */
public class GlobalParameter {
    private static final Logger log = LoggerFactory.getLogger(GlobalParameter.class);
    private static final GlobalParameter instance = new GlobalParameter();

    private GlobalParameter() {
    }

    public static GlobalParameter getInstance() {
        return instance;
    }

    private boolean removePrefix;
    private String javaRootSrc;
    private String pojoPackage;
    private String pojoPath;
    private String mapperPackage;
    private String mapperPath;
    private String mapPath;
    private String pdmPath;

    public void init(boolean removePrefix, String pdmPath, String javaRootSrc, String pojoPackage, String mapperPackage, String mapPath) {
        this.removePrefix = removePrefix;
        this.javaRootSrc = javaRootSrc;
        this.pojoPackage = pojoPackage;
        this.mapperPackage = mapperPackage;
        this.mapPath = mapPath;
        this.pdmPath = pdmPath;

        this.pojoPath = javaRootSrc + pojoPackage.replaceAll("\\.", "/") + "/";
        this.mapperPath = javaRootSrc + mapperPackage.replaceAll("\\.", "/") + "/";

        Properties properties = new Properties();
        try {
//            properties.load(ClassLoader.getSystemResourceAsStream("config.properties"));
//            properties.load(new FileInputStream(new File("src/main/resources/config.properties")));
            properties.setProperty("removePrefix", String.valueOf(removePrefix));
            properties.setProperty("pdmPath", pdmPath);
            properties.setProperty("javaRoot", javaRootSrc);
            properties.setProperty("pojoPackage", pojoPackage);
            properties.setProperty("mapperPackage", mapperPackage);
            properties.setProperty("mapConfigPath", mapPath);
            String dir = System.getProperty("user.dir");
            properties.store(new FileOutputStream(new File(dir + "/src/main/resources/config.properties")), "");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isRemovePrefix() {
        return removePrefix;
    }

    public String getJavaRootSrc() {
        return javaRootSrc;
    }

    public String getPojoPackage() {
        return pojoPackage;
    }

    public String getPojoPath() {
        return pojoPath;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public String getMapperPath() {
        return mapperPath;
    }

    public String getMapPath() {
        return mapPath;
    }

    public String getPdmPath() {
        return pdmPath;
    }

    public void initByConfig() {
        Properties properties = new Properties();
        try {
            String dir = System.getProperty("user.dir");
            log.info("user.dir:{}", dir);
            properties.load(new FileInputStream(new File(dir + "/src/main/resources/config.properties")));
            init(
                    Boolean.parseBoolean(properties.getProperty("removePrefix")),
                    properties.getProperty("pdmPath"),
                    properties.getProperty("javaRoot"),
                    properties.getProperty("pojoPackage"),
                    properties.getProperty("mapperPackage"),
                    properties.getProperty("mapConfigPath")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
