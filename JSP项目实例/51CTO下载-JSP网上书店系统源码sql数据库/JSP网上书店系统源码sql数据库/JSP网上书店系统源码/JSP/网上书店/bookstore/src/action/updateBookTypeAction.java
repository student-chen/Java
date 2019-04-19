package action;
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
/**
 * @����:������
 * ¼��һ������,��������
 */
public class updateBookTypeAction extends Action{
    /**
     * �ڴ˷����д���HTTP�������ݣ�������Ӧ
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionErrors errors=new ActionErrors();
        bookTypeOPBean bookTypeOP=new bookTypeOPBean();
        String bookTypeIdStr=request.getParameter("booktypeid");
        String bookTypeStr=((dispBookTypeForm)form).getBooktypename();
        int bookTypeId=0;
        try{
            bookTypeId=Integer.parseInt(bookTypeIdStr);
        }catch(Exception e){
            e.printStackTrace();
            bookTypeId=0;
        }      
        int i=bookTypeOP.updateBookType(bookTypeId,bookTypeStr);
        if(i!=1){
            errors.add("updateerror",new ActionMessage("booktype.updateError"));
            saveErrors(request,errors);
            return(new ActionForward(mapping.findForward("updatebooktypeerror")));
        }
        request.removeAttribute(mapping.getAttribute());//ɾ��formBean
        return mapping.findForward("success");  
    }
}
