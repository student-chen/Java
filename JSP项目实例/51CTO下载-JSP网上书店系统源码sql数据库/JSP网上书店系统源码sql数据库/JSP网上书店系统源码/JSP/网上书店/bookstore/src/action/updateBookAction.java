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
 * @作者:邓子云
 * 录入一本新书,控制器类
 */
public class updateBookAction extends Action{
    /**
     * 在此方法中处理HTTP请求数据，并作响应
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
        request.removeAttribute(mapping.getAttribute());//删除formBean
        return mapping.findForward("success");  
    }
}
