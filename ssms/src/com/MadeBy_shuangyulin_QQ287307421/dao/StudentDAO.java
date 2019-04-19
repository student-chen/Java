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

import com.MadeBy_shuangyulin_QQ287307421.domain.ClassInfo;
import com.MadeBy_shuangyulin_QQ287307421.domain.Student;

public class StudentDAO {

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
    public void AddStudent(Student student) throws Exception {
        Session s = null;
        Transaction tx = null;
        try { 
            s = HibernateUtil.getSession();
            tx = s.beginTransaction(); 
            s.save(student);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*��ѯStudent��Ϣ*/
    public ArrayList<Student> QueryStudentInfo(String studentNumber,String studentName,ClassInfo classInfo,int currentPage) { 
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From Student student where 1=1";
            if(!studentNumber.equals("")) hql = hql + " and student.studentNumber like '%" + studentNumber + "%'";
            if(!studentName.equals("")) hql = hql + " and student.studentName like '%" + studentName + "%'";
            if(null != classInfo && !classInfo.getClassNumber().equals("")) hql += " and student.classInfo.classNumber='" + classInfo.getClassNumber() + "'";
            Query q = s.createQuery(hql);
            /*���㵱ǰ��ʾҳ��Ŀ�ʼ��¼*/
            int startIndex = (currentPage-1) * this.PAGE_SIZE;
            q.setFirstResult(startIndex);
            q.setMaxResults(this.PAGE_SIZE);
            List studentList = q.list();
            return (ArrayList<Student>) studentList;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*�������ܣ���ѯ���е�Student��¼*/
    public ArrayList<Student> QueryAllStudentInfo() {
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From Student";
            Query q = s.createQuery(hql);
            List studentList = q.list();
            return (ArrayList<Student>) studentList;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*�����ܵ�ҳ���ͼ�¼��*/
    public void CalculateTotalPageAndRecordNumber(String studentNumber,String studentName,ClassInfo classInfo) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            String hql = "From Student student where 1=1";
            if(!studentNumber.equals("")) hql = hql + " and student.studentNumber like '%" + studentNumber + "%'";
            if(!studentName.equals("")) hql = hql + " and student.studentName like '%" + studentName + "%'";
            if(null != classInfo && !classInfo.getClassNumber().equals("")) hql += " and student.classInfo.classNumber='" + classInfo.getClassNumber() + "'";
            Query q = s.createQuery(hql);
            List studentList = q.list();
            recordNumber = studentList.size();
            int mod = recordNumber % this.PAGE_SIZE;
            totalPage = recordNumber / this.PAGE_SIZE;
            if(mod != 0) totalPage++;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*����������ȡ����*/
    public Student GetStudentByStudentNumber(String studentNumber) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            Student student = (Student)s.get(Student.class, studentNumber);
            return student;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*����Student��Ϣ*/
    public void UpdateStudent(Student student) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.update(student);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
            	  tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*ɾ��Student��Ϣ*/
    public void DeleteStudent (String studentNumber) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            Object student = s.get(Student.class, studentNumber);
            s.delete(student);
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
