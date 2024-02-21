package com.hgm.springiocxml.ditest;

/**
 * 员工类
 */
public class Emp {
    private String ename;
    private Integer age;

    private Dept dept;// 员工属于某个部门

    public void work() {
        System.out.println(ename+ " emp working..." + age);
        dept.info();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
