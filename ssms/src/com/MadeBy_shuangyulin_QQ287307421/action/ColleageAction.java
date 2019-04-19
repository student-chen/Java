package com.MadeBy_shuangyulin_QQ287307421.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.MadeBy_shuangyulin_QQ287307421.dao.ColleageDAO;
import com.MadeBy_shuangyulin_QQ287307421.domain.Colleage;
import com.MadeBy_shuangyulin_QQ287307421.test.TestUtil;

public class ColleageAction extends ActionSupport {

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

    private int colleageId;
    public void setColleageId(int colleageId) {
        this.colleageId = colleageId;
    }
    public int getColleageId() {
        return colleageId;
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
    ColleageDAO colleageDAO = new ColleageDAO();

    /*��������Colleage����*/
    private Colleage colleage;
    public void setColleage(Colleage colleage) {
        this.colleage = colleage;
    }
    public Colleage getColleage() {
        return this.colleage;
    }

    /*��ת�����Colleage��ͼ*/
    public String AddView() {
        ActionContext ctx = ActionContext.getContext();
        return "add_view";
    }

    /*���Colleage��Ϣ*/
    @SuppressWarnings("deprecation")
    public String AddColleage() {
        ActionContext ctx = ActionContext.getContext();
        try {
            colleageDAO.AddColleage(colleage);
            ctx.put("message",  java.net.URLEncoder.encode("Colleage��ӳɹ�!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Colleage���ʧ��!"));
            return "error";
        }
    }

    /*��ѯColleage��Ϣ*/
    public String QueryColleage() {
        if(currentPage == 0) currentPage = 1;
        List<Colleage> colleageList = colleageDAO.QueryColleageInfo(currentPage);
        /*�����ܵ�ҳ�����ܵļ�¼��*/
        colleageDAO.CalculateTotalPageAndRecordNumber();
        /*��ȡ���ܵ�ҳ����Ŀ*/
        totalPage = colleageDAO.getTotalPage();
        /*��ǰ��ѯ�������ܼ�¼��*/
        recordNumber = colleageDAO.getRecordNumber();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("colleageList",  colleageList);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "query_view";
    }

    /*��ѯҪ�޸ĵ�Colleage��Ϣ*/
    public String ModifyColleageQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*��������colleageId��ȡColleage����*/
        Colleage colleage = colleageDAO.GetColleageByColleageId(colleageId);

        ctx.put("colleage",  colleage);
        return "modify_view";
    }

    /*�����޸�Colleage��Ϣ*/
    public String ModifyColleage() {
        ActionContext ctx = ActionContext.getContext();
        try {
            colleageDAO.UpdateColleage(colleage);
            ctx.put("message",  java.net.URLEncoder.encode("Colleage��Ϣ���³ɹ�!"));
            return "modify_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Colleage��Ϣ����ʧ��!"));
            return "error";
       }
   }

    /*ɾ��Colleage��Ϣ*/
    public String DeleteColleage() {
        ActionContext ctx = ActionContext.getContext();
        try { 
            colleageDAO.DeleteColleage(colleageId);
            ctx.put("message",  java.net.URLEncoder.encode("Colleageɾ���ɹ�!"));
            return "delete_success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("Colleageɾ��ʧ��!"));
            return "error";
        }
    }

}
