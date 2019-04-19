package action;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.viewOrderForm;
import bean.db.orderFormOPBean;
import bean.db.common.dataPage;
/**
 * @作者:邓子云
 * 订单查询,控制器类
 */
public class viewOrderFormAction extends Action{
    /**
     * 在此方法中处理HTTP请求数据，并作响应
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        viewOrderForm dataForm=(viewOrderForm)form;
        if((dataForm.getStatus()==null||dataForm.getStatus().length()==0)&&(dataForm.getOrderformid()==null||dataForm.getOrderformid().length()==0))
            return mapping.findForward("orderformview");
        //------得到当前页码------
        String currentPageStr=dataForm.getPage();
        int currentPageInt=0;
        try{
            currentPageInt=Integer.parseInt(currentPageStr);
        }catch(Exception e){
            e.printStackTrace();
            currentPageInt=0;
        }
        //------得到请求参数中的状态------
        String statusStr=dataForm.getStatus();
        int statusInt=0;
        try{
            statusInt=Integer.parseInt(statusStr);
        }catch(Exception e){
            e.printStackTrace();
            statusInt=0;
        }
        //------查询出数据------
        orderFormOPBean orderFormOP=new orderFormOPBean();
        ArrayList orderForms=orderFormOP.getOrderForms(dataForm.getOrderformid(),statusInt);       
        //------作分页处理------
        dataPage dataPageObject=new dataPage();
        dataPageObject.setPageRecordCount(2);
        dataPageObject.setCurrentPage(currentPageInt);
        dataPageObject.setDispartedArray(orderForms);
        dataPageObject.dataPageDispart();
        //------得到当前页的数据------
        ArrayList CurrentPageArray=dataPageObject.getCurrentPageArray();
        request.setAttribute("CurrentPageArray",CurrentPageArray);
        request.setAttribute("dataPageObject",dataPageObject);
        request.setAttribute("status",statusStr);
        request.removeAttribute(mapping.getAttribute());//删除formBean
        return mapping.findForward("orderformview");  
    }
}
