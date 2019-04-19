package com.MadeBy_shuangyulin_QQ287307421.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.MadeBy_shuangyulin_QQ287307421.dao.StudentDAO;
import com.MadeBy_shuangyulin_QQ287307421.domain.Student;
import com.MadeBy_shuangyulin_QQ287307421.dao.ClassInfoDAO;
import com.MadeBy_shuangyulin_QQ287307421.domain.ClassInfo;
import com.MadeBy_shuangyulin_QQ287307421.test.TestUtil;

public class StudentAction extends ActionSupport {

    /*�������Ҫ��ѯ������: ѧ��ѧ��*/
    private String studentNumber;
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    public String getStudentNumber() {
        return this.studentNumber;
    }

    /*�������Ҫ��ѯ������: ѧ������*/
    private String studentName;
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentName() {
        return this.studentName;
    }

    /*�������Ҫ��ѯ������: ���ڰ༶*/
    private ClassInfo classInfo;
    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }
    public ClassInfo getClassInfo() {
        return this.classInfo;
    }

    /*��ǰ�ڼ�ҳ*/
    private int currentPage;
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getCurrentPage() {
        return currentPage;
    }

    /*һ������ҳ*/
    private int totalPage;
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalPage() {
        return totalPage;
    }

    /*��ǰ��ѯ���ܼ�¼��Ŀ*/
    private int recordNumber;
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    public int getRecordNumber() {
        return recordNumber;
    }

    /*ҵ������*/
    StudentDAO studentDAO = new StudentDAO();

    /*��������Student����*/
    private Student student;
    public void setStudent(Student student) {
        this.student = student;
    }
    public Student getStudent() {
        return this.student;
    }

    /*��ת�����Student��ͼ*/
    public String AddView() {
        ActionContext ctx = ActionContext.getContext();
        /*��ѯ���е�ClassInfo��Ϣ*/
        ClassInfoDAO classInfoDAO = new ClassInfoDAO();
        List<ClassInfo> classInfoList = classInfoDAO.QueryAllClassInfoInfo();
        ctx.put("classInfoList", classInfoList);
        return "add_view";
    }

    /*���Student��Ϣ*/
    @SuppressWarnings("deprecation")
    public String AddStudent() {
        ActionContext ctx = ActionContext.getContext();
        /*��֤ѧ��ѧ���Ƿ��Ѿ�����*/
        String studentNumber = student.getStudentNumber();
        Student db_student = studentDAO.GetStudentByStudentNumber(studentNumber);
        if(null != db_student) {
            ctx.put("error",  java.net.URLEncoder.encode("��ѧ��ѧ���Ѿ�����!"));
            return "error";
        }
        try {
            ClassInfoDAO classInfoDAO = new ClassInfoDAO();
            classInfo = classInfoDAO.GetClassInfoByClassNumber(student.getClassInfo().getClassNumber());
            student.setClassInfo(classInfo);
            studentDAO.AddStudent(student);
            ctx.put("message",  java.net.URLEncoder.encode("Student��ӳɹ�!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Student���ʧ��!"));
            return "error";
        }
    }

    /*��ѯStudent��Ϣ*/
    public String QueryStudent() {
        if(currentPage == 0) currentPage = 1;
        if(studentNumber == null) studentNumber = "";
        if(studentName == null) studentName = "";
        List<Student> studentList = studentDAO.QueryStudentInfo(studentNumber, studentName, classInfo, currentPage);
        /*�����ܵ�ҳ�����ܵļ�¼��*/
        studentDAO.CalculateTotalPageAndRecordNumber(studentNumber, studentName, classInfo);
        /*��ȡ���ܵ�ҳ����Ŀ*/
        totalPage = studentDAO.getTotalPage();
        /*��ǰ��ѯ�������ܼ�¼��*/
        recordNumber = studentDAO.getRecordNumber();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("studentList",  studentList);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        ctx.put("studentNumber", studentNumber);
        ctx.put("studentName", studentName);
        ctx.put("classInfo", classInfo);
        ClassInfoDAO classInfoDAO = new ClassInfoDAO();
        List<ClassInfo> classInfoList = classInfoDAO.QueryAllClassInfoInfo();
        ctx.put("classInfoList", classInfoList);
        return "query_view";
    }

    /*��ѯҪ�޸ĵ�Student��Ϣ*/
    public String ModifyStudentQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*��������studentNumber��ȡStudent����*/
        Student student = studentDAO.GetStudentByStudentNumber(studentNumber);

        ClassInfoDAO classInfoDAO = new ClassInfoDAO();
        List<ClassInfo> classInfoList = classInfoDAO.QueryAllClassInfoInfo();
        ctx.put("classInfoList", classInfoList);
        ctx.put("student",  student);
        return "modify_view";
    }

    /*�����޸�Student��Ϣ*/
    public String ModifyStudent() {
        ActionContext ctx = ActionContext.getContext();
        try {
            ClassInfoDAO classInfoDAO = new ClassInfoDAO();
            classInfo = classInfoDAO.GetClassInfoByClassNumber(student.getClassInfo().getClassNumber());
            student.setClassInfo(classInfo);
            studentDAO.UpdateStudent(student);
            ctx.put("message",  java.net.URLEncoder.encode("Student��Ϣ���³ɹ�!"));
            return "modify_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Student��Ϣ����ʧ��!"));
            return "error";
       }
   }

    /*ɾ��Student��Ϣ*/
    public String DeleteStudent() {
        ActionContext ctx = ActionContext.getContext();
        try { 
            studentDAO.DeleteStudent(studentNumber);
            ctx.put("message",  java.net.URLEncoder.encode("Studentɾ���ɹ�!"));
            return "delete_success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Studentɾ��ʧ��!"));
            return "error";
        }
    }

}
