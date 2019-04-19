package action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import bean.db.bookOPBean;
/**
 * @author 邓子云
 * 删除书藉信息的action
 */
public class deleteBookAction extends Action{
    /**
     * 在此方法中处理HTTP请求数据，并作响应
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String bookIdStr=request.getParameter("bookid");
        int bookId=0;
        bookOPBean bookOP=new bookOPBean();
        try{
            bookId=Integer.parseInt(bookIdStr);
        }catch(Exception e){
            e.printStackTrace();
            bookId=0;
        }                    
        int i=bookOP.deleteBook(bookId);
        if(i!=0)
            return mapping.findForward("success");
        else
            return mapping.findForward("failure");
    }
}