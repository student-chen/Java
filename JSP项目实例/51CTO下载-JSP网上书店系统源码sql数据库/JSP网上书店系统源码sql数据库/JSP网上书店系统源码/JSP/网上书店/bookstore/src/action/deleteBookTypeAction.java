package action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import bean.db.bookTypeOPBean;
/**
 * @author 邓子云
 * 删除书藉类型信息的action
 */
public class deleteBookTypeAction extends Action{
    /**
     * 在此方法中处理HTTP请求数据，并作响应
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String bookTypeIdStr=request.getParameter("booktypeid");
        int bookTypeId=0;
        bookTypeOPBean bookTypeOP=new bookTypeOPBean();
        try{
            bookTypeId=Integer.parseInt(bookTypeIdStr);
        }catch(Exception e){
            e.printStackTrace();
            bookTypeId=0;
        }                    
        int i=bookTypeOP.deleteBookType(bookTypeId);
        if(i!=0)
            return mapping.findForward("success");
        else
            return mapping.findForward("failure");
    }
}