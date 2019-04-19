package com.shuangyulin.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;
import org.apache.struts2.ServletActionContext;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shuangyulin.dao.ScoreInfoDAO;
import com.shuangyulin.dao.StudentSelectCourseInfoDAO;
import com.shuangyulin.domain.ScoreInfo;
import com.shuangyulin.domain.StudentSelectCourseInfo;
import com.shuangyulin.dao.StudentDAO;
import com.shuangyulin.domain.Student;
import com.shuangyulin.dao.CourseInfoDAO;
import com.shuangyulin.domain.CourseInfo;
import com.shuangyulin.test.TestUtil;

public class ScoreInfoAction extends ActionSupport {

    /*界面层需要查询的属性: 学生对象*/
    private Student studentNumber;
    public void setStudentNumber(Student studentNumber) {
        this.studentNumber = studentNumber;
    }
    public Student getStudentNumber() {
        return this.studentNumber;
    }

    /*界面层需要查询的属性: 课程对象*/
    private CourseInfo courseNumber;
    public void setCourseNumber(CourseInfo courseNumber) {
        this.courseNumber = courseNumber;
    }
    public CourseInfo getCourseNumber() {
        return this.courseNumber;
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

    private int scoreId;
    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }
    public int getScoreId() {
        return scoreId;
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
    ScoreInfoDAO scoreInfoDAO = new ScoreInfoDAO();

    /*待操作的ScoreInfo对象*/
    private ScoreInfo scoreInfo;
    public void setScoreInfo(ScoreInfo scoreInfo) {
        this.scoreInfo = scoreInfo;
    }
    public ScoreInfo getScoreInfo() {
        return this.scoreInfo;
    }

    /*跳转到添加ScoreInfo视图*/
    public String AddView() {
        ActionContext ctx = ActionContext.getContext();
        /*查询所有的Student信息*/
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.QueryAllStudentInfo();
        ctx.put("studentList", studentList);
        /*查询所有的CourseInfo信息*/
        CourseInfoDAO courseInfoDAO = new CourseInfoDAO();
        List<CourseInfo> courseInfoList = courseInfoDAO.QueryAllCourseInfoInfo();
        ctx.put("courseInfoList", courseInfoList);
        return "add_view";
    }
    
    /*跳转到教师添加ScoreInfo视图*/
    public String TeacherAddView() {
        ActionContext ctx = ActionContext.getContext();
        /*查询所有的Student信息*/
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.QueryAllStudentInfo();
        ctx.put("studentList", studentList);
        /*查询所有的CourseInfo信息*/
        CourseInfoDAO courseInfoDAO = new CourseInfoDAO();
        List<CourseInfo> courseInfoList = courseInfoDAO.QueryAllCourseInfoInfo();
        ctx.put("courseInfoList", courseInfoList);
        return "teacher_add_view";
    }

    /*添加ScoreInfo信息*/
    @SuppressWarnings("deprecation")
    public String AddScoreInfo() {
        ActionContext ctx = ActionContext.getContext();
        try {
            if(true) {
            StudentDAO studentDAO = new StudentDAO();
            Student studentNumber = studentDAO.GetStudentByStudentNumber(scoreInfo.getStudentNumber().getStudentNumber());
            scoreInfo.setStudentNumber(studentNumber);
            }
            if(true) {
            CourseInfoDAO courseInfoDAO = new CourseInfoDAO();
            CourseInfo courseNumber = courseInfoDAO.GetCourseInfoByCourseNumber(scoreInfo.getCourseNumber().getCourseNumber());
            scoreInfo.setCourseNumber(courseNumber);
            }
            scoreInfoDAO.AddScoreInfo(scoreInfo);
            ctx.put("message",  java.net.URLEncoder.encode("ScoreInfo添加成功!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ScoreInfo添加失败!"));
            return "error";
        }
    }
    
    
    /*教师添加成绩信息*/
    @SuppressWarnings("deprecation")
    public String TeacherAddScoreInfo() {
        ActionContext ctx = ActionContext.getContext();
        try { 
        	
        	/*判断该门课程是否被老师课程*/
        	CourseInfoDAO courseInfoDAO = new CourseInfoDAO();
            CourseInfo courseObj = courseInfoDAO.GetCourseInfoByCourseNumber(scoreInfo.getCourseNumber().getCourseNumber());
            scoreInfo.setCourseNumber(courseObj);
            
            if(!courseObj.getCourseTeacher().getTeacherNumber().equals((String)ctx.getSession().get("username"))) {
            	ctx.put("error",  java.net.URLEncoder.encode("你并没有教授该门课程！"));
                return "error";
            }
        	
            StudentDAO studentDAO = new StudentDAO();
            Student studentNumber = studentDAO.GetStudentByStudentNumber(scoreInfo.getStudentNumber().getStudentNumber());
            scoreInfo.setStudentNumber(studentNumber);
            
            StudentSelectCourseInfoDAO studentSelectCourseInfoDAO = new StudentSelectCourseInfoDAO();
            ArrayList<StudentSelectCourseInfo> selectList = studentSelectCourseInfoDAO.QueryStudentSelectCourseInfoInfo(studentNumber, courseObj, 1);
        	if(selectList.size() == 0) {
        		ctx.put("error",  java.net.URLEncoder.encode("该学生并没有选择这门课程！"));
                return "error";
        	} 
             
        	//查询该学生的成绩是否已经添加
        	if(scoreInfoDAO.QueryScoreInfoInfo(studentNumber, courseObj, 1).size() > 0) {
        		ctx.put("error",  java.net.URLEncoder.encode("该学生该门课程成绩已经添加！"));
                return "error";
        	}
        	
            scoreInfoDAO.AddScoreInfo(scoreInfo);
            ctx.put("message",  java.net.URLEncoder.encode("成绩添加成功!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ScoreInfo添加失败!"));
            return "error";
        }
    }

    
    

    /*查询ScoreInfo信息*/
    public String QueryScoreInfo() {
        if(currentPage == 0) currentPage = 1;
        List<ScoreInfo> scoreInfoList = scoreInfoDAO.QueryScoreInfoInfo(studentNumber, courseNumber, currentPage);
        /*计算总的页数和总的记录数*/
        scoreInfoDAO.CalculateTotalPageAndRecordNumber(studentNumber, courseNumber);
        /*获取到总的页码数目*/
        totalPage = scoreInfoDAO.getTotalPage();
        /*当前查询条件下总记录数*/
        recordNumber = scoreInfoDAO.getRecordNumber();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("scoreInfoList",  scoreInfoList);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        ctx.put("studentNumber", studentNumber);
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.QueryAllStudentInfo();
        ctx.put("studentList", studentList);
        ctx.put("courseNumber", courseNumber);
        CourseInfoDAO courseInfoDAO = new CourseInfoDAO();
        List<CourseInfo> courseInfoList = courseInfoDAO.QueryAllCourseInfoInfo();
        ctx.put("courseInfoList", courseInfoList);
        return "query_view";
    }

    
    /*学生查询自己的成绩信息*/
    public String StudentQueryScoreInfo() { 
    	ActionContext ctx = ActionContext.getContext();
        List<ScoreInfo> scoreInfoList = scoreInfoDAO.StudentQueryScoreInfoInfo((String)ctx.getSession().get("username")); 
        ctx.put("scoreInfoList",  scoreInfoList);
         
        return "student_query_view";
    }
    
    
    /*前台查询ScoreInfo信息*/
    public String FrontQueryScoreInfo() {
        if(currentPage == 0) currentPage = 1;
        List<ScoreInfo> scoreInfoList = scoreInfoDAO.QueryScoreInfoInfo(studentNumber, courseNumber, currentPage);
        /*计算总的页数和总的记录数*/
        scoreInfoDAO.CalculateTotalPageAndRecordNumber(studentNumber, courseNumber);
        /*获取到总的页码数目*/
        totalPage = scoreInfoDAO.getTotalPage();
        /*当前查询条件下总记录数*/
        recordNumber = scoreInfoDAO.getRecordNumber();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("scoreInfoList",  scoreInfoList);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        ctx.put("studentNumber", studentNumber);
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.QueryAllStudentInfo();
        ctx.put("studentList", studentList);
        ctx.put("courseNumber", courseNumber);
        CourseInfoDAO courseInfoDAO = new CourseInfoDAO();
        List<CourseInfo> courseInfoList = courseInfoDAO.QueryAllCourseInfoInfo();
        ctx.put("courseInfoList", courseInfoList);
        return "front_query_view";
    }

    /*查询要修改的ScoreInfo信息*/
    public String ModifyScoreInfoQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*根据主键scoreId获取ScoreInfo对象*/
        ScoreInfo scoreInfo = scoreInfoDAO.GetScoreInfoByScoreId(scoreId);

        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.QueryAllStudentInfo();
        ctx.put("studentList", studentList);
        CourseInfoDAO courseInfoDAO = new CourseInfoDAO();
        List<CourseInfo> courseInfoList = courseInfoDAO.QueryAllCourseInfoInfo();
        ctx.put("courseInfoList", courseInfoList);
        ctx.put("scoreInfo",  scoreInfo);
        return "modify_view";
    }

    /*查询要修改的ScoreInfo信息*/
    public String FrontShowScoreInfoQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*根据主键scoreId获取ScoreInfo对象*/
        ScoreInfo scoreInfo = scoreInfoDAO.GetScoreInfoByScoreId(scoreId);

        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.QueryAllStudentInfo();
        ctx.put("studentList", studentList);
        CourseInfoDAO courseInfoDAO = new CourseInfoDAO();
        List<CourseInfo> courseInfoList = courseInfoDAO.QueryAllCourseInfoInfo();
        ctx.put("courseInfoList", courseInfoList);
        ctx.put("scoreInfo",  scoreInfo);
        return "front_show_view";
    }

    /*更新修改ScoreInfo信息*/
    public String ModifyScoreInfo() {
        ActionContext ctx = ActionContext.getContext();
        try {
            if(true) {
            StudentDAO studentDAO = new StudentDAO();
            Student studentNumber = studentDAO.GetStudentByStudentNumber(scoreInfo.getStudentNumber().getStudentNumber());
            scoreInfo.setStudentNumber(studentNumber);
            }
            if(true) {
            CourseInfoDAO courseInfoDAO = new CourseInfoDAO();
            CourseInfo courseNumber = courseInfoDAO.GetCourseInfoByCourseNumber(scoreInfo.getCourseNumber().getCourseNumber());
            scoreInfo.setCourseNumber(courseNumber);
            }
            scoreInfoDAO.UpdateScoreInfo(scoreInfo);
            ctx.put("message",  java.net.URLEncoder.encode("ScoreInfo信息更新成功!"));
            return "modify_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ScoreInfo信息更新失败!"));
            return "error";
       }
   }

    /*删除ScoreInfo信息*/
    public String DeleteScoreInfo() {
        ActionContext ctx = ActionContext.getContext();
        try { 
            scoreInfoDAO.DeleteScoreInfo(scoreId);
            ctx.put("message",  java.net.URLEncoder.encode("ScoreInfo删除成功!"));
            return "delete_success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ScoreInfo删除失败!"));
            return "error";
        }
    }

}
