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
 * @����:������
 * ������ѯ,��������
 */
public class viewOrderFormAction extends Action{
    /**
     * �ڴ˷����д���HTTP�������ݣ�������Ӧ
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        viewOrderForm dataForm=(viewOrderForm)form;
        if((dataForm.getStatus()==null||dataForm.getStatus().length()==0)&&(dataForm.getOrderformid()==null||dataForm.getOrderformid().length()==0))
            return mapping.findForward("orderformview");
        //------�õ���ǰҳ��------
        String currentPageStr=dataForm.getPage();
        int currentPageInt=0;
        try{
            currentPageInt=Integer.parseInt(currentPageStr);
        }catch(Exception e){
            e.printStackTrace();
            currentPageInt=0;
        }
        //------�õ���������е�״̬------
        String statusStr=dataForm.getStatus();
        int statusInt=0;
        try{
            statusInt=Integer.parseInt(statusStr);
        }catch(Exception e){
            e.printStackTrace();
            statusInt=0;
        }
        //------��ѯ������------
        orderFormOPBean orderFormOP=new orderFormOPBean();
        ArrayList orderForms=orderFormOP.getOrderForms(dataForm.getOrderformid(),statusInt);       
        //------����ҳ����------
        dataPage dataPageObject=new dataPage();
        dataPageObject.setPageRecordCount(2);
        dataPageObject.setCurrentPage(currentPageInt);
        dataPageObject.setDispartedArray(orderForms);
        dataPageObject.dataPageDispart();
        //------�õ���ǰҳ������------
        ArrayList CurrentPageArray=dataPageObject.getCurrentPageArray();
        request.setAttribute("CurrentPageArray",CurrentPageArray);
        request.setAttribute("dataPageObject",dataPageObject);
        request.setAttribute("status",statusStr);
        request.removeAttribute(mapping.getAttribute());//ɾ��formBean
        return mapping.findForward("orderformview");  
    }
}
