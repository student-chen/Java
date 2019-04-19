package com.MadeBy_shuangyulin_QQ287307421.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.MadeBy_shuangyulin_QQ287307421.dao.ColleageDAO;
import com.MadeBy_shuangyulin_QQ287307421.domain.Colleage;
import com.MadeBy_shuangyulin_QQ287307421.test.TestUtil;

public class ColleageAction extends ActionSupport {

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

    private int colleageId;
    public void setColleageId(int colleageId) {
        this.colleageId = colleageId;
    }
    public int getColleageId() {
        return colleageId;
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
    ColleageDAO colleageDAO = new ColleageDAO();

    /*待操作的Colleage对象*/
    private Colleage colleage;
    public void setColleage(Colleage colleage) {
        this.colleage = colleage;
    }
    public Colleage getColleage() {
        return this.colleage;
    }

    /*跳转到添加Colleage视图*/
    public String AddView() {
        ActionContext ctx = ActionContext.getContext();
        return "add_view";
    }

    /*添加Colleage信息*/
    @SuppressWarnings("deprecation")
    public String AddColleage() {
        ActionContext ctx = ActionContext.getContext();
        try {
            colleageDAO.AddColleage(colleage);
            ctx.put("message",  java.net.URLEncoder.encode("Colleage添加成功!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Colleage添加失败!"));
            return "error";
        }
    }

    /*查询Colleage信息*/
    public String QueryColleage() {
        if(currentPage == 0) currentPage = 1;
        List<Colleage> colleageList = colleageDAO.QueryColleageInfo(currentPage);
        /*计算总的页数和总的记录数*/
        colleageDAO.CalculateTotalPageAndRecordNumber();
        /*获取到总的页码数目*/
        totalPage = colleageDAO.getTotalPage();
        /*当前查询条件下总记录数*/
        recordNumber = colleageDAO.getRecordNumber();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("colleageList",  colleageList);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "query_view";
    }

    /*查询要修改的Colleage信息*/
    public String ModifyColleageQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*根据主键colleageId获取Colleage对象*/
        Colleage colleage = colleageDAO.GetColleageByColleageId(colleageId);

        ctx.put("colleage",  colleage);
        return "modify_view";
    }

    /*更新修改Colleage信息*/
    public String ModifyColleage() {
        ActionContext ctx = ActionContext.getContext();
        try {
            colleageDAO.UpdateColleage(colleage);
            ctx.put("message",  java.net.URLEncoder.encode("Colleage信息更新成功!"));
            return "modify_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Colleage信息更新失败!"));
            return "error";
       }
   }

    /*删除Colleage信息*/
    public String DeleteColleage() {
        ActionContext ctx = ActionContext.getContext();
        try { 
            colleageDAO.DeleteColleage(colleageId);
            ctx.put("message",  java.net.URLEncoder.encode("Colleage删除成功!"));
            return "delete_success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Colleage删除失败!"));
            return "error";
        }
    }

}
