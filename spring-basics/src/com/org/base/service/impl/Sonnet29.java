package com.org.base.service.impl;

import com.org.base.service.Poem;

public class Sonnet29 implements Poem {
    private static String[] LINES = {
            "when", "i", "am"
    };

    @Override
    public void recite() {
        for (int i = 0; i < LINES.length; i++) {
            System.out.println(LINES[i]);
        }
    }
}
