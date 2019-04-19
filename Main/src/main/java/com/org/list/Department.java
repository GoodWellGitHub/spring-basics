package com.org.list;

import com.org.domain.Member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Department {
    private String name;

    private List<Member> memberSheet;

    public Department(String name) {
        this.name = name;
    }

    public void addMemer(Member member) {
        if (memberSheet == null) {
            memberSheet = new ArrayList<Member>();
        }

        memberSheet.add(member);
    }

    public void printMemberSheet() {
        System.out.println("----部门" + name + "人员名单---");

        for (Member member : memberSheet) {
            System.out.println(member);
        }
    }

    /**
     * 里面的四个清除过程请分别独立执行
     */
    public void removeYoungerFromMemberSheet() {
        // 遍历一:这个处理会抛出java.util.ConcurrentModificationException
        for (Member member : memberSheet) {
            if (member.getAge() < 30) {
                memberSheet.remove(member);
            }
        }

        // 遍历二:这个处理也会抛出java.util.ConcurrentModificationException
        for (Iterator it = memberSheet.iterator(); it.hasNext(); ) {
            Member member = (Member) it.next();

            if (member.getAge() < 30) {
                memberSheet.remove(member);
            }
        }

        // 遍历三:这个处理调用Iterator 本身的方法 remove(),会正常执行
        for (Iterator it = memberSheet.iterator(); it.hasNext(); ) {
            Member member = (Member) it.next();

            if (member.getAge() < 30) {
                it.remove();
            }
        }

        // 遍历四:这个处理不依赖Iterator,也会正常执行
        for (int i = memberSheet.size() - 1; i >= 0; i--) {
            Member member = memberSheet.get(i);

            if (member.getAge() < 30) {
                memberSheet.remove(member);
            }
        }
    }

        public String toString() {
            return name;
        }

        public String getName () {
            return name;
        }

        public static void main (String[]args){
            Department resarchDept = new Department("研发部门");
            resarchDept.addMemer(new Member("张三", 38));
            resarchDept.addMemer(new Member("李四", 24));
            resarchDept.addMemer(new Member("王五", 30));
            resarchDept.addMemer(new Member("钱七", 22));
            resarchDept.addMemer(new Member("孙八", 39));
            resarchDept.addMemer(new Member("周九", 30));

            resarchDept.removeYoungerFromMemberSheet();
            resarchDept.printMemberSheet();
        }
    }
