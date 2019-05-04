package com.org.forcontinue;

public class Retry {
    public static void main(String[] args) {
        System.out.println("#########break############");
        breakTest();
        System.out.println("###########continue########");
        continueTest();
        System.out.println("#############retry#########");
        retryTest();
    }

    static void breakTest() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(j);
                if (j == 3) {
                    break;
                }
            }
        }
    }

    static void continueTest() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(j);
                if (j == 3) {
                    continue;
                }
            }
        }
    }

    static void retryTest() {
        retry:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(j);
                if (j == 3) {
                    continue retry;
                }
            }
        }
    }
}
