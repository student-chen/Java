package com.MadeBy_shuangyulin_QQ287307421.domain;

public class Score {
    /*成绩编号*/
    private int scoreId;
    public int getScoreId() {
        return scoreId;
    }
    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    /*学生对象*/
    private Student student;
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    /*学期信息*/
    private Term term;
    public Term getTerm() {
        return term;
    }
    public void setTerm(Term term) {
        this.term = term;
    }

    /*成绩得分*/
    private float score;
    public float getScore() {
        return score;
    }
    public void setScore(float score) {
        this.score = score;
    }

}