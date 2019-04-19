package com.org.list;

import com.google.common.collect.Maps;
import com.org.domain.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SubList {
    public static void main(String[] args) {
        removeforeach();


    }

    public static void removeforeach() {
        List<String> xs = new ArrayList(Arrays.asList("ab", "cd", "ef"));
        xs.forEach(x -> {
            if (x.equals("cd"))
                xs.remove(x);
        });

/*        for (String xx : xs) {
            if (xx.equals("ab"))
                xs.remove(xx);
        }*/

    }
}
