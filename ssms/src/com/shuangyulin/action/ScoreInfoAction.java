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

    /*�������Ҫ��ѯ������: ѧ������*/
    private Student studentNumber;
    public void setStudentNumber(Student studentNumber) {
        this.studentNumber = studentNumber;
    }
    public Student getStudentNumber() {
        return this.studentNumber;
    }

    /*�������Ҫ��ѯ������: �γ̶���*/
    private CourseInfo courseNumber;
    public void setCourseNumber(CourseInfo courseNumber) {
        this.courseNumber = courseNumber;
    }
    public CourseInfo getCourseNumber() {
        return this.courseNumber;
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

    private int scoreId;
    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }
    public int getScoreId() {
        return scoreId;
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
    ScoreInfoDAO scoreInfoDAO = new ScoreInfoDAO();

    /*��������ScoreInfo����*/
    private ScoreInfo scoreInfo;
    public void setScoreInfo(ScoreInfo scoreInfo) {
        this.scoreInfo = scoreInfo;
    }
    public ScoreInfo getScoreInfo() {
        return this.scoreInfo;
    }

    /*��ת�����ScoreInfo��ͼ*/
    public String AddView() {
        ActionContext ctx = ActionContext.getContext();
        /*��ѯ���е�Student��Ϣ*/
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.QueryAllStudentInfo();
        ctx.put("studentList", studentList);
        /*��ѯ���е�CourseInfo��Ϣ*/
        CourseInfoDAO courseInfoDAO = new CourseInfoDAO();
        List<CourseInfo> courseInfoList = courseInfoDAO.QueryAllCourseInfoInfo();
        ctx.put("courseInfoList", courseInfoList);
        return "add_view";
    }
    
    /*��ת����ʦ���ScoreInfo��ͼ*/
    public String TeacherAddView() {
        ActionContext ctx = ActionContext.getContext();
        /*��ѯ���е�Student��Ϣ*/
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.QueryAllStudentInfo();
        ctx.put("studentList", studentList);
        /*��ѯ���е�CourseInfo��Ϣ*/
        CourseInfoDAO courseInfoDAO = new CourseInfoDAO();
        List<CourseInfo> courseInfoList = courseInfoDAO.QueryAllCourseInfoInfo();
        ctx.put("courseInfoList", courseInfoList);
        return "teacher_add_view";
    }

    /*���ScoreInfo��Ϣ*/
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
            ctx.put("message",  java.net.URLEncoder.encode("ScoreInfo��ӳɹ�!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ScoreInfo���ʧ��!"));
            return "error";
        }
    }
    
    
    /*��ʦ��ӳɼ���Ϣ*/
    @SuppressWarnings("deprecation")
    public String TeacherAddScoreInfo() {
        ActionContext ctx = ActionContext.getContext();
        try { 
        	
        	/*�жϸ��ſγ��Ƿ���ʦ�γ�*/
        	CourseInfoDAO courseInfoDAO = new CourseInfoDAO();
            CourseInfo courseObj = courseInfoDAO.GetCourseInfoByCourseNumber(scoreInfo.getCourseNumber().getCourseNumber());
            scoreInfo.setCourseNumber(courseObj);
            
            if(!courseObj.getCourseTeacher().getTeacherNumber().equals((String)ctx.getSession().get("username"))) {
            	ctx.put("error",  java.net.URLEncoder.encode("�㲢û�н��ڸ��ſγ̣�"));
                return "error";
            }
        	
            StudentDAO studentDAO = new StudentDAO();
            Student studentNumber = studentDAO.GetStudentByStudentNumber(scoreInfo.getStudentNumber().getStudentNumber());
            scoreInfo.setStudentNumber(studentNumber);
            
            StudentSelectCourseInfoDAO studentSelectCourseInfoDAO = new StudentSelectCourseInfoDAO();
            ArrayList<StudentSelectCourseInfo> selectList = studentSelectCourseInfoDAO.QueryStudentSelectCourseInfoInfo(studentNumber, courseObj, 1);
        	if(selectList.size() == 0) {
        		ctx.put("error",  java.net.URLEncoder.encode("��ѧ����û��ѡ�����ſγ̣�"));
                return "error";
        	} 
             
        	//��ѯ��ѧ���ĳɼ��Ƿ��Ѿ����
        	if(scoreInfoDAO.QueryScoreInfoInfo(studentNumber, courseObj, 1).size() > 0) {
        		ctx.put("error",  java.net.URLEncoder.encode("��ѧ�����ſγ̳ɼ��Ѿ���ӣ�"));
                return "error";
        	}
        	
            scoreInfoDAO.AddScoreInfo(scoreInfo);
            ctx.put("message",  java.net.URLEncoder.encode("�ɼ���ӳɹ�!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ScoreInfo���ʧ��!"));
            return "error";
        }
    }

    
    

    /*��ѯScoreInfo��Ϣ*/
    public String QueryScoreInfo() {
        if(currentPage == 0) currentPage = 1;
        List<ScoreInfo> scoreInfoList = scoreInfoDAO.QueryScoreInfoInfo(studentNumber, courseNumber, currentPage);
        /*�����ܵ�ҳ�����ܵļ�¼��*/
        scoreInfoDAO.CalculateTotalPageAndRecordNumber(studentNumber, courseNumber);
        /*��ȡ���ܵ�ҳ����Ŀ*/
        totalPage = scoreInfoDAO.getTotalPage();
        /*��ǰ��ѯ�������ܼ�¼��*/
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

    
    /*ѧ����ѯ�Լ��ĳɼ���Ϣ*/
    public String StudentQueryScoreInfo() { 
    	ActionContext ctx = ActionContext.getContext();
        List<ScoreInfo> scoreInfoList = scoreInfoDAO.StudentQueryScoreInfoInfo((String)ctx.getSession().get("username")); 
        ctx.put("scoreInfoList",  scoreInfoList);
         
        return "student_query_view";
    }
    
    
    /*ǰ̨��ѯScoreInfo��Ϣ*/
    public String FrontQueryScoreInfo() {
        if(currentPage == 0) currentPage = 1;
        List<ScoreInfo> scoreInfoList = scoreInfoDAO.QueryScoreInfoInfo(studentNumber, courseNumber, currentPage);
        /*�����ܵ�ҳ�����ܵļ�¼��*/
        scoreInfoDAO.CalculateTotalPageAndRecordNumber(studentNumber, courseNumber);
        /*��ȡ���ܵ�ҳ����Ŀ*/
        totalPage = scoreInfoDAO.getTotalPage();
        /*��ǰ��ѯ�������ܼ�¼��*/
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

    /*��ѯҪ�޸ĵ�ScoreInfo��Ϣ*/
    public String ModifyScoreInfoQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*��������scoreId��ȡScoreInfo����*/
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

    /*��ѯҪ�޸ĵ�ScoreInfo��Ϣ*/
    public String FrontShowScoreInfoQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*��������scoreId��ȡScoreInfo����*/
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

    /*�����޸�ScoreInfo��Ϣ*/
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
            ctx.put("message",  java.net.URLEncoder.encode("ScoreInfo��Ϣ���³ɹ�!"));
            return "modify_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ScoreInfo��Ϣ����ʧ��!"));
            return "error";
       }
   }

    /*ɾ��ScoreInfo��Ϣ*/
    public String DeleteScoreInfo() {
        ActionContext ctx = ActionContext.getContext();
        try { 
            scoreInfoDAO.DeleteScoreInfo(scoreId);
            ctx.put("message",  java.net.URLEncoder.encode("ScoreInfoɾ���ɹ�!"));
            return "delete_success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ScoreInfoɾ��ʧ��!"));
            return "error";
        }
    }

}
