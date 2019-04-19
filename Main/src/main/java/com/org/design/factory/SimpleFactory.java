package com.org.design.factory;

import com.org.domain.Student;
import com.org.interf.BaseClass;

public class SimpleFactory {
    private static final int TYPE_STUDENT = 1;

    public BaseClass createClass(int type) {
        switch (type) {
            case TYPE_STUDENT:
                return new Student();
            default:
                return null;
        }
    }
}
