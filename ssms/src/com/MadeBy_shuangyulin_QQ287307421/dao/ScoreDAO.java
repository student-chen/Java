package com.MadeBy_shuangyulin_QQ287307421.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mysql.jdbc.Statement;
import com.MadeBy_shuangyulin_QQ287307421.utils.HibernateUtil;

import com.MadeBy_shuangyulin_QQ287307421.domain.Student;
import com.MadeBy_shuangyulin_QQ287307421.domain.Term;
import com.MadeBy_shuangyulin_QQ287307421.domain.Score;

public class ScoreDAO {

    /*每页显示记录数目*/
    private final int PAGE_SIZE = 10;

    /*保存查询后总的页数*/
    private int totalPage;
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalPage() {
        return totalPage;
    }

    /*保存查询到的总记录数*/
    private int recordNumber;
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    public int getRecordNumber() {
        return recordNumber;
    }

    /*添加图书信息*/
    public void AddScore(Score score) throws Exception {
        Session s = null;
        Transaction tx = null;
        try { 
            s = HibernateUtil.getSession();
            tx = s.beginTransaction(); 
            s.save(score);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*查询Score信息*/
    public ArrayList<Score> QueryScoreInfo(Student student,Term term,int currentPage) { 
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From Score score where 1=1";
            if(null != student && !student.getStudentNumber().equals("")) hql += " and score.student.studentNumber='" + student.getStudentNumber() + "'";
            if(null != term && term.getTermId()!=0) hql += " and score.term.termId=" + term.getTermId();
            Query q = s.createQuery(hql);
            /*计算当前显示页码的开始记录*/
            int startIndex = (currentPage-1) * this.PAGE_SIZE;
            q.setFirstResult(startIndex);
            q.setMaxResults(this.PAGE_SIZE);
            List scoreList = q.list();
            return (ArrayList<Score>) scoreList;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*函数功能：查询所有的Score记录*/
    public ArrayList<Score> QueryAllScoreInfo() {
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From Score";
            Query q = s.createQuery(hql);
            List scoreList = q.list();
            return (ArrayList<Score>) scoreList;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*计算总的页数和记录数*/
    public void CalculateTotalPageAndRecordNumber(Student student,Term term) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            String hql = "From Score score where 1=1";
            if(null != student && !student.getStudentNumber().equals("")) hql += " and score.student.studentNumber='" + student.getStudentNumber() + "'";
            if(null != term && term.getTermId()!=0) hql += " and score.term.termId=" + term.getTermId();
            Query q = s.createQuery(hql);
            List scoreList = q.list();
            recordNumber = scoreList.size();
            int mod = recordNumber % this.PAGE_SIZE;
            totalPage = recordNumber / this.PAGE_SIZE;
            if(mod != 0) totalPage++;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*根据主键获取对象*/
    public Score GetScoreByScoreId(int scoreId) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            Score score = (Score)s.get(Score.class, scoreId);
            return score;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*更新Score信息*/
    public void UpdateScore(Score score) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.update(score);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
            	  tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*删除Score信息*/
    public void DeleteScore (int scoreId) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            Object score = s.get(Score.class, scoreId);
            s.delete(score);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
            	  tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

}
