package action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import bean.db.bookOPBean;
/**
 * @����:������
 * ¼��һ������,��������
 */
public class updateBookAction extends Action{
    /**
     * �ڴ˷����д���HTTP�������ݣ�������Ӧ
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionErrors errors=new ActionErrors();
        bookOPBean bookOP=new bookOPBean();
        String bookIdStr=request.getParameter("bookid");
        int bookId=0;
        try{
            bookId=Integer.parseInt(bookIdStr);
        }catch(Exception e){
            e.printStackTrace();
            bookId=0;
        }      
        int i=bookOP.updateBook(form,bookId);
        if(i!=1){
            errors.add("updateerror",new ActionMessage("updatebook.updateError"));
            saveErrors(request,errors);
            return(new ActionForward(mapping.findForward("failure")));
        }
        request.removeAttribute(mapping.getAttribute());//ɾ��formBean
        return mapping.findForward("success");  
    }
}
