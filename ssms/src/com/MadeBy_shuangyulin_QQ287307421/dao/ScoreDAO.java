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

    /*ÿҳ��ʾ��¼��Ŀ*/
    private final int PAGE_SIZE = 10;

    /*�����ѯ���ܵ�ҳ��*/
    private int totalPage;
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalPage() {
        return totalPage;
    }

    /*�����ѯ�����ܼ�¼��*/
    private int recordNumber;
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    public int getRecordNumber() {
        return recordNumber;
    }

    /*���ͼ����Ϣ*/
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

    /*��ѯScore��Ϣ*/
    public ArrayList<Score> QueryScoreInfo(Student student,Term term,int currentPage) { 
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From Score score where 1=1";
            if(null != student && !student.getStudentNumber().equals("")) hql += " and score.student.studentNumber='" + student.getStudentNumber() + "'";
            if(null != term && term.getTermId()!=0) hql += " and score.term.termId=" + term.getTermId();
            Query q = s.createQuery(hql);
            /*���㵱ǰ��ʾҳ��Ŀ�ʼ��¼*/
            int startIndex = (currentPage-1) * this.PAGE_SIZE;
            q.setFirstResult(startIndex);
            q.setMaxResults(this.PAGE_SIZE);
            List scoreList = q.list();
            return (ArrayList<Score>) scoreList;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*�������ܣ���ѯ���е�Score��¼*/
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

    /*�����ܵ�ҳ���ͼ�¼��*/
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

    /*����������ȡ����*/
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

    /*����Score��Ϣ*/
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

    /*ɾ��Score��Ϣ*/
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
