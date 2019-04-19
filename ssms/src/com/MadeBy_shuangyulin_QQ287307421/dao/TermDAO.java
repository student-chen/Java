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

import com.MadeBy_shuangyulin_QQ287307421.domain.Term;

public class TermDAO {

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
    public void AddTerm(Term term) throws Exception {
        Session s = null;
        Transaction tx = null;
        try { 
            s = HibernateUtil.getSession();
            tx = s.beginTransaction(); 
            s.save(term);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*查询Term信息*/
    public ArrayList<Term> QueryTermInfo(int currentPage) { 
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From Term term where 1=1";
            Query q = s.createQuery(hql);
            /*计算当前显示页码的开始记录*/
            int startIndex = (currentPage-1) * this.PAGE_SIZE;
            q.setFirstResult(startIndex);
            q.setMaxResults(this.PAGE_SIZE);
            List termList = q.list();
            return (ArrayList<Term>) termList;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*函数功能：查询所有的Term记录*/
    public ArrayList<Term> QueryAllTermInfo() {
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From Term";
            Query q = s.createQuery(hql);
            List termList = q.list();
            return (ArrayList<Term>) termList;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*计算总的页数和记录数*/
    public void CalculateTotalPageAndRecordNumber() {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            String hql = "From Term term where 1=1";
            Query q = s.createQuery(hql);
            List termList = q.list();
            recordNumber = termList.size();
            int mod = recordNumber % this.PAGE_SIZE;
            totalPage = recordNumber / this.PAGE_SIZE;
            if(mod != 0) totalPage++;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*根据主键获取对象*/
    public Term GetTermByTermId(int termId) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            Term term = (Term)s.get(Term.class, termId);
            return term;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*更新Term信息*/
    public void UpdateTerm(Term term) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.update(term);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
            	  tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*删除Term信息*/
    public void DeleteTerm (int termId) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            Object term = s.get(Term.class, termId);
            s.delete(term);
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
