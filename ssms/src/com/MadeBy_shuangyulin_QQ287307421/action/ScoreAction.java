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

    /*�������Ҫ��ѯ������: ѧ������*/
    private Student student;
    public void setStudent(Student student) {
        this.student = student;
    }
    public Student getStudent() {
        return this.student;
    }

    /*�������Ҫ��ѯ������: ѧ����Ϣ*/
    private Term term;
    public void setTerm(Term term) {
        this.term = term;
    }
    public Term getTerm() {
        return this.term;
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
    ScoreDAO scoreDAO = new ScoreDAO();

    /*��������Score����*/
    private Score score;
    public void setScore(Score score) {
        this.score = score;
    }
    public Score getScore() {
        return this.score;
    }

    /*��ת�����Score��ͼ*/
    public String AddView() {
        ActionContext ctx = ActionContext.getContext();
        /*��ѯ���е�Student��Ϣ*/
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.QueryAllStudentInfo();
        ctx.put("studentList", studentList);
        /*��ѯ���е�Term��Ϣ*/
        TermDAO termDAO = new TermDAO();
        List<Term> termList = termDAO.QueryAllTermInfo();
        ctx.put("termList", termList);
        return "add_view";
    }

    /*���Score��Ϣ*/
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
            ctx.put("message",  java.net.URLEncoder.encode("Score��ӳɹ�!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Score���ʧ��!"));
            return "error";
        }
    }

    /*��ѯScore��Ϣ*/
    public String QueryScore() {
        if(currentPage == 0) currentPage = 1;
        List<Score> scoreList = scoreDAO.QueryScoreInfo(student, term, currentPage);
        /*�����ܵ�ҳ�����ܵļ�¼��*/
        scoreDAO.CalculateTotalPageAndRecordNumber(student, term);
        /*��ȡ���ܵ�ҳ����Ŀ*/
        totalPage = scoreDAO.getTotalPage();
        /*��ǰ��ѯ�������ܼ�¼��*/
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

    /*��ѯҪ�޸ĵ�Score��Ϣ*/
    public String ModifyScoreQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*��������scoreId��ȡScore����*/
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

    /*�����޸�Score��Ϣ*/
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
            ctx.put("message",  java.net.URLEncoder.encode("Score��Ϣ���³ɹ�!"));
            return "modify_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Score��Ϣ����ʧ��!"));
            return "error";
       }
   }

    /*ɾ��Score��Ϣ*/
    public String DeleteScore() {
        ActionContext ctx = ActionContext.getContext();
        try { 
            scoreDAO.DeleteScore(scoreId);
            ctx.put("message",  java.net.URLEncoder.encode("Scoreɾ���ɹ�!"));
            return "delete_success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Scoreɾ��ʧ��!"));
            return "error";
        }
    }

}
