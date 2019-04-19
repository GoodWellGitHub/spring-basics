package com.org.load;

public class StaticInnerMain {
    public static void main(String[] args) {
        System.out.println("外层初始化开始.......");
       // StaticInnerMain staticInnerMain = StaticInnerMain.getInstance();
       // System.out.println("内部类的属性：" + staticInnerMain);
    }

    private StaticInnerMain() {
        System.out.println("外部类的实例化........");
    }

    public static StaticInnerMain getInstance() {
        return StaticInnerClass.getInstance();
    }

    static class StaticInnerClass {
        private static StaticInnerMain main;

        static {
            System.out.println("StaticInnerClass 初始化........");
            main = new StaticInnerMain();
        }

        public static StaticInnerMain getInstance() {
            return main;
        }


    }

    static {
        System.out.println("外部类静态代码块执行........");
    }
}
