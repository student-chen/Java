package com.MadeBy_shuangyulin_QQ287307421.domain;

public class Score {
    /*�ɼ����*/
    private int scoreId;
    public int getScoreId() {
        return scoreId;
    }
    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    /*ѧ������*/
    private Student student;
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    /*ѧ����Ϣ*/
    private Term term;
    public Term getTerm() {
        return term;
    }
    public void setTerm(Term term) {
        this.term = term;
    }

    /*�ɼ��÷�*/
    private float score;
    public float getScore() {
        return score;
    }
    public void setScore(float score) {
        this.score = score;
    }

}