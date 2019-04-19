package com.org.reflect;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.Objects;

public class FieldNotNull<V> {
    private static final Logger logger = Logger.getLogger(FieldNotNull.class);

    public int countNull(V v) {
        if (v == null) {
            return 0;
        }
        Class vClass = v.getClass();
        if (vClass == null) {
            return 0;
        }
        int result = 0;
        Field[] fields = vClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (Objects.isNull(field.get(v))) {
                    result++;
                }
                Class c=field.getType();
                if (field.getType() == int.class && field.get(v).equals(0)) {
                    result++;
                }
            } catch (IllegalAccessException e) {
                logger.error("获取属性值出错");
                e.printStackTrace();
            }
        }
        return result;
    }
}
