package com.org.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtil {

  private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
  final static Properties properties = new Properties();

  static {
    try {
      InputStream inputStream =PropertiesUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
      properties.load(inputStream);
    } catch (FileNotFoundException e) {
      logger.error("PropertiesUtil:未找到文件");
      e.printStackTrace();
    } catch (IOException e) {
      logger.error("PropertiesUtil:IO错误");
      e.printStackTrace();
    }
  }

  static String propertiesValue(String key){
    properties.get(key);
    return properties.getProperty(key);
  }
}
