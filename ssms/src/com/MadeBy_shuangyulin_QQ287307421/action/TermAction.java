package com.MadeBy_shuangyulin_QQ287307421.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.MadeBy_shuangyulin_QQ287307421.dao.TermDAO;
import com.MadeBy_shuangyulin_QQ287307421.domain.Term;
import com.MadeBy_shuangyulin_QQ287307421.test.TestUtil;

public class TermAction extends ActionSupport {

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

    private int termId;
    public void setTermId(int termId) {
        this.termId = termId;
    }
    public int getTermId() {
        return termId;
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
    TermDAO termDAO = new TermDAO();

    /*待操作的Term对象*/
    private Term term;
    public void setTerm(Term term) {
        this.term = term;
    }
    public Term getTerm() {
        return this.term;
    }

    /*跳转到添加Term视图*/
    public String AddView() {
        ActionContext ctx = ActionContext.getContext();
        return "add_view";
    }

    /*添加Term信息*/
    @SuppressWarnings("deprecation")
    public String AddTerm() {
        ActionContext ctx = ActionContext.getContext();
        try {
            termDAO.AddTerm(term);
            ctx.put("message",  java.net.URLEncoder.encode("Term添加成功!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Term添加失败!"));
            return "error";
        }
    }

    /*查询Term信息*/
    public String QueryTerm() {
        if(currentPage == 0) currentPage = 1;
        List<Term> termList = termDAO.QueryTermInfo(currentPage);
        /*计算总的页数和总的记录数*/
        termDAO.CalculateTotalPageAndRecordNumber();
        /*获取到总的页码数目*/
        totalPage = termDAO.getTotalPage();
        /*当前查询条件下总记录数*/
        recordNumber = termDAO.getRecordNumber();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("termList",  termList);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "query_view";
    }

    /*查询要修改的Term信息*/
    public String ModifyTermQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*根据主键termId获取Term对象*/
        Term term = termDAO.GetTermByTermId(termId);

        ctx.put("term",  term);
        return "modify_view";
    }

    /*更新修改Term信息*/
    public String ModifyTerm() {
        ActionContext ctx = ActionContext.getContext();
        try {
            termDAO.UpdateTerm(term);
            ctx.put("message",  java.net.URLEncoder.encode("Term信息更新成功!"));
            return "modify_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Term信息更新失败!"));
            return "error";
       }
   }

    /*删除Term信息*/
    public String DeleteTerm() {
        ActionContext ctx = ActionContext.getContext();
        try { 
            termDAO.DeleteTerm(termId);
            ctx.put("message",  java.net.URLEncoder.encode("Term删除成功!"));
            return "delete_success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Term删除失败!"));
            return "error";
        }
    }

}
