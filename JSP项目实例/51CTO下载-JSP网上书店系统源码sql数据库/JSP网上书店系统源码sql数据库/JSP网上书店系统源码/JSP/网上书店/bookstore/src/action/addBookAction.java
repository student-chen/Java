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
public class addBookAction extends Action{
    /**
     * 在此方法中处理HTTP请求数据，并作响应
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionErrors errors=new ActionErrors();
        bookOPBean bookOP=new bookOPBean();
        int i=bookOP.insertBook(form);
        if(i!=1){
            errors.add("inserterror",new ActionMessage("addbook.insertError"));
            saveErrors(request,errors);
            return(new ActionForward(mapping.findForward("failure")));
        }
        request.removeAttribute(mapping.getAttribute());//删除formBean
        return mapping.findForward("success");  
    }
}
