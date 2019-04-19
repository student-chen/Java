package com.MadeBy_shuangyulin_QQ287307421.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.MadeBy_shuangyulin_QQ287307421.dao.TermDAO;
import com.MadeBy_shuangyulin_QQ287307421.domain.Term;
import com.MadeBy_shuangyulin_QQ287307421.test.TestUtil;

public class TermAction extends ActionSupport {

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

    private int termId;
    public void setTermId(int termId) {
        this.termId = termId;
    }
    public int getTermId() {
        return termId;
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
    TermDAO termDAO = new TermDAO();

    /*��������Term����*/
    private Term term;
    public void setTerm(Term term) {
        this.term = term;
    }
    public Term getTerm() {
        return this.term;
    }

    /*��ת�����Term��ͼ*/
    public String AddView() {
        ActionContext ctx = ActionContext.getContext();
        return "add_view";
    }

    /*���Term��Ϣ*/
    @SuppressWarnings("deprecation")
    public String AddTerm() {
        ActionContext ctx = ActionContext.getContext();
        try {
            termDAO.AddTerm(term);
            ctx.put("message",  java.net.URLEncoder.encode("Term��ӳɹ�!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Term���ʧ��!"));
            return "error";
        }
    }

    /*��ѯTerm��Ϣ*/
    public String QueryTerm() {
        if(currentPage == 0) currentPage = 1;
        List<Term> termList = termDAO.QueryTermInfo(currentPage);
        /*�����ܵ�ҳ�����ܵļ�¼��*/
        termDAO.CalculateTotalPageAndRecordNumber();
        /*��ȡ���ܵ�ҳ����Ŀ*/
        totalPage = termDAO.getTotalPage();
        /*��ǰ��ѯ�������ܼ�¼��*/
        recordNumber = termDAO.getRecordNumber();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("termList",  termList);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "query_view";
    }

    /*��ѯҪ�޸ĵ�Term��Ϣ*/
    public String ModifyTermQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*��������termId��ȡTerm����*/
        Term term = termDAO.GetTermByTermId(termId);

        ctx.put("term",  term);
        return "modify_view";
    }

    /*�����޸�Term��Ϣ*/
    public String ModifyTerm() {
        ActionContext ctx = ActionContext.getContext();
        try {
            termDAO.UpdateTerm(term);
            ctx.put("message",  java.net.URLEncoder.encode("Term��Ϣ���³ɹ�!"));
            return "modify_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Term��Ϣ����ʧ��!"));
            return "error";
       }
   }

    /*ɾ��Term��Ϣ*/
    public String DeleteTerm() {
        ActionContext ctx = ActionContext.getContext();
        try { 
            termDAO.DeleteTerm(termId);
            ctx.put("message",  java.net.URLEncoder.encode("Termɾ���ɹ�!"));
            return "delete_success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Termɾ��ʧ��!"));
            return "error";
        }
    }

}
