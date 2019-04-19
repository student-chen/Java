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

import com.MadeBy_shuangyulin_QQ287307421.domain.Colleage;

public class ColleageDAO {

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
    public void AddColleage(Colleage colleage) throws Exception {
        Session s = null;
        Transaction tx = null;
        try { 
            s = HibernateUtil.getSession();
            tx = s.beginTransaction(); 
            s.save(colleage);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*��ѯColleage��Ϣ*/
    public ArrayList<Colleage> QueryColleageInfo(int currentPage) { 
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From Colleage colleage where 1=1";
            Query q = s.createQuery(hql);
            /*���㵱ǰ��ʾҳ��Ŀ�ʼ��¼*/
            int startIndex = (currentPage-1) * this.PAGE_SIZE;
            q.setFirstResult(startIndex);
            q.setMaxResults(this.PAGE_SIZE);
            List colleageList = q.list();
            return (ArrayList<Colleage>) colleageList;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*�������ܣ���ѯ���е�Colleage��¼*/
    public ArrayList<Colleage> QueryAllColleageInfo() {
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From Colleage";
            Query q = s.createQuery(hql);
            List colleageList = q.list();
            return (ArrayList<Colleage>) colleageList;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*�����ܵ�ҳ���ͼ�¼��*/
    public void CalculateTotalPageAndRecordNumber() {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            String hql = "From Colleage colleage where 1=1";
            Query q = s.createQuery(hql);
            List colleageList = q.list();
            recordNumber = colleageList.size();
            int mod = recordNumber % this.PAGE_SIZE;
            totalPage = recordNumber / this.PAGE_SIZE;
            if(mod != 0) totalPage++;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*����������ȡ����*/
    public Colleage GetColleageByColleageId(int colleageId) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            Colleage colleage = (Colleage)s.get(Colleage.class, colleageId);
            return colleage;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*����Colleage��Ϣ*/
    public void UpdateColleage(Colleage colleage) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.update(colleage);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
            	  tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*ɾ��Colleage��Ϣ*/
    public void DeleteColleage (int colleageId) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            Object colleage = s.get(Colleage.class, colleageId);
            s.delete(colleage);
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
