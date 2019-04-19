package action;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import form.dispBookTypeForm;
import bean.db.bookTypeOPBean;
import bean.db.common.dataPage;
/**
 * @author ������
 * ��ʾ���������Ϣ��action
 */
public class dispBookTypeAction extends Action{
    /**
     * �ڴ˷����д���HTTP�������ݣ�������Ӧ
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String bookTypeName=((dispBookTypeForm)form).getBooktypename();
        bookTypeOPBean bookTypeOP=new bookTypeOPBean();
        ActionErrors errors=new ActionErrors();
        //------�����Ҫ�����������,������������------
        if(bookTypeName!=null&&bookTypeName.length()>0){
            int i=bookTypeOP.insertBookType(bookTypeName);
            if(i!=1){
                errors.add("updateerror",new ActionMessage("bookType.insertError"));
                saveErrors(request,errors);
                return(new ActionForward(mapping.findForward("booktypeview")));
            }else{
                request.removeAttribute(mapping.getAttribute());//ɾ��formBean
                return mapping.findForward("success"); 
            }           
        }
        //------�õ���¼��------      
        ArrayList bookTypesArray=bookTypeOP.getBookTypeArray();
        //------�õ���ǰҳ��------
        String currentPageStr=((dispBookTypeForm)form).getPage();
        int currentPageInt=0;
        try{
            currentPageInt=Integer.parseInt(currentPageStr);
        }catch(Exception e){
            e.printStackTrace();
            currentPageInt=0;
        }
        //------����ҳ����------
        dataPage dataPageObject=new dataPage();
        dataPageObject.setCurrentPage(currentPageInt);
        dataPageObject.setDispartedArray(bookTypesArray);
        dataPageObject.dataPageDispart();
        //------�õ���ǰҳ������------
        ArrayList CurrentPageArray=dataPageObject.getCurrentPageArray();
        request.setAttribute("CurrentPageArray",CurrentPageArray);
        request.setAttribute("dataPageObject",dataPageObject);
        request.removeAttribute(mapping.getAttribute());//ɾ��formBean
        return mapping.findForward("booktypeview");  
    }
}