package com.MadeBy_shuangyulin_QQ287307421.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.MadeBy_shuangyulin_QQ287307421.dao.ScoreDAO;
import com.MadeBy_shuangyulin_QQ287307421.domain.Score;
import com.MadeBy_shuangyulin_QQ287307421.dao.StudentDAO;
import com.MadeBy_shuangyulin_QQ287307421.domain.Student;
import com.MadeBy_shuangyulin_QQ287307421.dao.TermDAO;
import com.MadeBy_shuangyulin_QQ287307421.domain.Term;
import com.MadeBy_shuangyulin_QQ287307421.test.TestUtil;

public class ScoreAction extends ActionSupport {

    /*界面层需要查询的属性: 学生对象*/
    private Student student;
    public void setStudent(Student student) {
        this.student = student;
    }
    public Student getStudent() {
        return this.student;
    }

    /*界面层需要查询的属性: 学期信息*/
    private Term term;
    public void setTerm(Term term) {
        this.term = term;
    }
    public Term getTerm() {
        return this.term;
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
    ScoreDAO scoreDAO = new ScoreDAO();

    /*待操作的Score对象*/
    private Score score;
    public void setScore(Score score) {
        this.score = score;
    }
    public Score getScore() {
        return this.score;
    }

    /*跳转到添加Score视图*/
    public String AddView() {
        ActionContext ctx = ActionContext.getContext();
        /*查询所有的Student信息*/
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.QueryAllStudentInfo();
        ctx.put("studentList", studentList);
        /*查询所有的Term信息*/
        TermDAO termDAO = new TermDAO();
        List<Term> termList = termDAO.QueryAllTermInfo();
        ctx.put("termList", termList);
        return "add_view";
    }

    /*添加Score信息*/
    @SuppressWarnings("deprecation")
    public String AddScore() {
        ActionContext ctx = ActionContext.getContext();
        try {
            StudentDAO studentDAO = new StudentDAO();
            student = studentDAO.GetStudentByStudentNumber(score.getStudent().getStudentNumber());
            score.setStudent(student);
            TermDAO termDAO = new TermDAO();
            term = termDAO.GetTermByTermId(score.getTerm().getTermId());
            score.setTerm(term);
            scoreDAO.AddScore(score);
            ctx.put("message",  java.net.URLEncoder.encode("Score添加成功!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Score添加失败!"));
            return "error";
        }
    }

    /*查询Score信息*/
    public String QueryScore() {
        if(currentPage == 0) currentPage = 1;
        List<Score> scoreList = scoreDAO.QueryScoreInfo(student, term, currentPage);
        /*计算总的页数和总的记录数*/
        scoreDAO.CalculateTotalPageAndRecordNumber(student, term);
        /*获取到总的页码数目*/
        totalPage = scoreDAO.getTotalPage();
        /*当前查询条件下总记录数*/
        recordNumber = scoreDAO.getRecordNumber();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("scoreList",  scoreList);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        ctx.put("student", student);
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.QueryAllStudentInfo();
        ctx.put("studentList", studentList);
        ctx.put("term", term);
        TermDAO termDAO = new TermDAO();
        List<Term> termList = termDAO.QueryAllTermInfo();
        ctx.put("termList", termList);
        return "query_view";
    }

    /*查询要修改的Score信息*/
    public String ModifyScoreQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*根据主键scoreId获取Score对象*/
        Score score = scoreDAO.GetScoreByScoreId(scoreId);

        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.QueryAllStudentInfo();
        ctx.put("studentList", studentList);
        TermDAO termDAO = new TermDAO();
        List<Term> termList = termDAO.QueryAllTermInfo();
        ctx.put("termList", termList);
        ctx.put("score",  score);
        return "modify_view";
    }

    /*更新修改Score信息*/
    public String ModifyScore() {
        ActionContext ctx = ActionContext.getContext();
        try {
            StudentDAO studentDAO = new StudentDAO();
            student = studentDAO.GetStudentByStudentNumber(score.getStudent().getStudentNumber());
            score.setStudent(student);
            TermDAO termDAO = new TermDAO();
            term = termDAO.GetTermByTermId(score.getTerm().getTermId());
            score.setTerm(term);
            scoreDAO.UpdateScore(score);
            ctx.put("message",  java.net.URLEncoder.encode("Score信息更新成功!"));
            return "modify_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Score信息更新失败!"));
            return "error";
       }
   }

    /*删除Score信息*/
    public String DeleteScore() {
        ActionContext ctx = ActionContext.getContext();
        try { 
            scoreDAO.DeleteScore(scoreId);
            ctx.put("message",  java.net.URLEncoder.encode("Score删除成功!"));
            return "delete_success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Score删除失败!"));
            return "error";
        }
    }

}
