package com.org.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.org.domain.Student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TableDemo {
    public static void main(String[] args) {
        Table<String, Integer, List<Student>> table = HashBasedTable.create();
        table.put("001", 12, Student.getStudentList());
        table.put("002", 12, Student.getStudentList());

        System.out.println(table.rowKeySet());
        System.out.println(table.row("001"));
        Map<String, Long> zb = Maps.newHashMap();
        Long a = zb.get("a");
        List<String> strings = Lists.newArrayList();

        Date date = new Date(1559288995000l);

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(sd.format(date));


        //System.out.println(a);

        System.out.println(table.columnKeySet());

    }
}
