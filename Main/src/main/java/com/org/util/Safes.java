package com.org.util;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class Safes<E> {
    public static  Collection  of(Collection t) {
        if (!CollectionUtils.isEmpty(t)) {
           return Collections.EMPTY_LIST;
        }
        return Collections.EMPTY_SET;

    }
}
