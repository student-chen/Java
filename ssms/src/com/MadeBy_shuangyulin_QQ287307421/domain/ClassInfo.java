package com.MadeBy_shuangyulin_QQ287307421.domain;

public class ClassInfo {
    /*班级编号*/
    private String classNumber;
    public String getClassNumber() {
        return classNumber;
    }
    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    /*班级名称*/
    private String className;
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    /*入学年份*/
    private int startYear;
    public int getStartYear() {
        return startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    /*班主任*/
    private String banzhuren;
    public String getBanzhuren() {
        return banzhuren;
    }
    public void setBanzhuren(String banzhuren) {
        this.banzhuren = banzhuren;
    }

    /*所属学院*/
    private Colleage collleage;
    public Colleage getCollleage() {
        return collleage;
    }
    public void setCollleage(Colleage collleage) {
        this.collleage = collleage;
    }

}