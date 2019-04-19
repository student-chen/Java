package com.MadeBy_shuangyulin_QQ287307421.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.MadeBy_shuangyulin_QQ287307421.dao.ClassInfoDAO;
import com.MadeBy_shuangyulin_QQ287307421.domain.ClassInfo;
import com.MadeBy_shuangyulin_QQ287307421.dao.ColleageDAO;
import com.MadeBy_shuangyulin_QQ287307421.domain.Colleage;
import com.MadeBy_shuangyulin_QQ287307421.test.TestUtil;

public class ClassInfoAction extends ActionSupport {

    /*�������Ҫ��ѯ������: �༶���*/
    private String classNumber;
    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }
    public String getClassNumber() {
        return this.classNumber;
    }

    /*�������Ҫ��ѯ������: �༶����*/
    private String className;
    public void setClassName(String className) {
        this.className = className;
    }
    public String getClassName() {
        return this.className;
    }

    /*�������Ҫ��ѯ������: ����ѧԺ*/
    private Colleage collleage;
    public void setCollleage(Colleage collleage) {
        this.collleage = collleage;
    }
    public Colleage getCollleage() {
        return this.collleage;
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
    ClassInfoDAO classInfoDAO = new ClassInfoDAO();

    /*��������ClassInfo����*/
    private ClassInfo classInfo;
    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }
    public ClassInfo getClassInfo() {
        return this.classInfo;
    }

    /*��ת�����ClassInfo��ͼ*/
    public String AddView() {
        ActionContext ctx = ActionContext.getContext();
        /*��ѯ���е�Colleage��Ϣ*/
        ColleageDAO colleageDAO = new ColleageDAO();
        List<Colleage> colleageList = colleageDAO.QueryAllColleageInfo();
        ctx.put("colleageList", colleageList);
        return "add_view";
    }

    /*���ClassInfo��Ϣ*/
    @SuppressWarnings("deprecation")
    public String AddClassInfo() {
        ActionContext ctx = ActionContext.getContext();
        /*��֤�༶����Ƿ��Ѿ�����*/
        String classNumber = classInfo.getClassNumber();
        ClassInfo db_classInfo = classInfoDAO.GetClassInfoByClassNumber(classNumber);
        if(null != db_classInfo) {
            ctx.put("error",  java.net.URLEncoder.encode("�ð༶����Ѿ�����!"));
            return "error";
        }
        try {
            ColleageDAO colleageDAO = new ColleageDAO();
            collleage = colleageDAO.GetColleageByColleageId(classInfo.getCollleage().getColleageId());
            classInfo.setCollleage(collleage);
            classInfoDAO.AddClassInfo(classInfo);
            ctx.put("message",  java.net.URLEncoder.encode("ClassInfo��ӳɹ�!"));
            return "add_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ClassInfo���ʧ��!"));
            return "error";
        }
    }

    /*��ѯClassInfo��Ϣ*/
    public String QueryClassInfo() {
        if(currentPage == 0) currentPage = 1;
        if(classNumber == null) classNumber = "";
        if(className == null) className = "";
        List<ClassInfo> classInfoList = classInfoDAO.QueryClassInfoInfo(classNumber, className, collleage, currentPage);
        /*�����ܵ�ҳ�����ܵļ�¼��*/
        classInfoDAO.CalculateTotalPageAndRecordNumber(classNumber, className, collleage);
        /*��ȡ���ܵ�ҳ����Ŀ*/
        totalPage = classInfoDAO.getTotalPage();
        /*��ǰ��ѯ�������ܼ�¼��*/
        recordNumber = classInfoDAO.getRecordNumber();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("classInfoList",  classInfoList);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        ctx.put("classNumber", classNumber);
        ctx.put("className", className);
        ctx.put("collleage", collleage);
        ColleageDAO colleageDAO = new ColleageDAO();
        List<Colleage> colleageList = colleageDAO.QueryAllColleageInfo();
        ctx.put("colleageList", colleageList);
        return "query_view";
    }

    /*��ѯҪ�޸ĵ�ClassInfo��Ϣ*/
    public String ModifyClassInfoQuery() {
        ActionContext ctx = ActionContext.getContext();
        /*��������classNumber��ȡClassInfo����*/
        ClassInfo classInfo = classInfoDAO.GetClassInfoByClassNumber(classNumber);

        ColleageDAO colleageDAO = new ColleageDAO();
        List<Colleage> colleageList = colleageDAO.QueryAllColleageInfo();
        ctx.put("colleageList", colleageList);
        ctx.put("classInfo",  classInfo);
        return "modify_view";
    }

    /*�����޸�ClassInfo��Ϣ*/
    public String ModifyClassInfo() {
        ActionContext ctx = ActionContext.getContext();
        try {
            ColleageDAO colleageDAO = new ColleageDAO();
            collleage = colleageDAO.GetColleageByColleageId(classInfo.getCollleage().getColleageId());
            classInfo.setCollleage(collleage);
            classInfoDAO.UpdateClassInfo(classInfo);
            ctx.put("message",  java.net.URLEncoder.encode("ClassInfo��Ϣ���³ɹ�!"));
            return "modify_success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ClassInfo��Ϣ����ʧ��!"));
            return "error";
       }
   }

    /*ɾ��ClassInfo��Ϣ*/
    public String DeleteClassInfo() {
        ActionContext ctx = ActionContext.getContext();
        try { 
            classInfoDAO.DeleteClassInfo(classNumber);
            ctx.put("message",  java.net.URLEncoder.encode("ClassInfoɾ���ɹ�!"));
            return "delete_success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ClassInfoɾ��ʧ��!"));
            return "error";
        }
    }

}
