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

    /*界面层需要查询的属性: 学生学号*/
    private String studentNumber;
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    public String getStudentNumber() {
        return this.studentNumber;
    }

    /*界面层需要查询的属性: 学生姓名*/
    private String studentName;
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentName() {
        return this.studentName;
    }

    /*界面层需要查询的属性: 所在班级*/
    private ClassInfo classInfo;
    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }
    public ClassInfo getClassInfo() {
        return this.classInfo;
    }

    /*当前第几页*/
    private int currentPage;
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getCurrentPage() {
        return currentPage;
    }

    /*一共多少页*/
    private int totalPage;
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalPage() {
        return totalPage;
    }

    /*当前查询的总记录数目*/
    private int recordNumber;
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    public int getRecordNumber() {
        return recordNumber;
    }

    /*业务层对象*/
    StudentDAO studentDAO = new StudentDAO();

    /*待操作的Student对象*/
    private Student student;
    public void setStudent(Student student) {
        this.student = student;
    }
    public Student getStudent() {
        return this.student;
    }

    /*跳转到添加Student视图*/
    public String AddView() {
        ActionContext ctx = ActionContext.getContext();
        /*查询所有的ClassInfo信息*/
        ClassInfoDAO classInfoDAO = new ClassInfoDAO();
        List<ClassInfo> classInfoList = classInfoDAO.QueryAllClassInfoInfo();
        ctx.put("classInfoList", classInfoList);
        return "add_view";
    }

    /*添加Student信息*/
    @SuppressWarnings("deprecation")
    public String AddStudent() {
        ActionContext ctx = ActionContext.getContext();
        /*验证学生学号是否已经存在*/
        String studentNumber = student.getStudentNumber();
        Student db_student = studentDAO.GetStudentByStudentNumber(studentNumber);
        if(null != db_student) {
            ctx.put("error",  java.net.URLEncoder.encode("该学生学号已经存在!"));
            return "error";
        }
        try {
            ClassInfoDAO classInfoDAO = new ClassInfoDAO();
            classInfo = classInfoDAO.GetClassInfoByClassNumber(student.getClassInfo().getClassNumber());
            student.setClassInfo(classInfo);
            studentDAO.AddStudent(student);
            ctx.put("message",  java.net.URLEncoder.encode("Student添加成功!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Student添加失败!"));
            return "error";
        }
    }

    /*查询Student信息*/
    public String QueryStudent() {
        if(currentPage == 0) currentPage = 1;
        if(studentNumber == null) studentNumber = "";
        if(studentName == null) studentName = "";
        List<Student> studentList = studentDAO.QueryStudentInfo(studentNumber, studentName, classInfo, currentPage);
        /*计算总的页数和总的记录数*/
        studentDAO.CalculateTotalPageAndRecordNumber(studentNumber, studentName, classInfo);
        /*获取到总的页码数目*/
        totalPage = studentDAO.getTotalPage();
        /*当前查询条件下总记录数*/
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

    /*查询要修改的Student信息*/
    public String ModifyStudentQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*根据主键studentNumber获取Student对象*/
        Student student = studentDAO.GetStudentByStudentNumber(studentNumber);

        ClassInfoDAO classInfoDAO = new ClassInfoDAO();
        List<ClassInfo> classInfoList = classInfoDAO.QueryAllClassInfoInfo();
        ctx.put("classInfoList", classInfoList);
        ctx.put("student",  student);
        return "modify_view";
    }

    /*更新修改Student信息*/
    public String ModifyStudent() {
        ActionContext ctx = ActionContext.getContext();
        try {
            ClassInfoDAO classInfoDAO = new ClassInfoDAO();
            classInfo = classInfoDAO.GetClassInfoByClassNumber(student.getClassInfo().getClassNumber());
            student.setClassInfo(classInfo);
            studentDAO.UpdateStudent(student);
            ctx.put("message",  java.net.URLEncoder.encode("Student信息更新成功!"));
            return "modify_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Student信息更新失败!"));
            return "error";
       }
   }

    /*删除Student信息*/
    public String DeleteStudent() {
        ActionContext ctx = ActionContext.getContext();
        try { 
            studentDAO.DeleteStudent(studentNumber);
            ctx.put("message",  java.net.URLEncoder.encode("Student删除成功!"));
            return "delete_success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Student删除失败!"));
            return "error";
        }
    }

}
