package action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import bean.db.orderFormOPBean;
/**
 * @����:������
 * ȷ�϶���,��������
 */
public class certOrderFormAction extends Action{
    /**
     * �ڴ˷����д���HTTP�������ݣ�������Ӧ
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        //------����Ҫȡ���Ķ�����------
        long order_form_id=0;
        try{
            order_form_id=Long.parseLong(request.getParameter("order_form_id"));
        }catch(Exception e){
            e.printStackTrace();
        }
        //------ȷ�϶���------
        orderFormOPBean orderFormOP=new orderFormOPBean();
        orderFormOP.modiOrderFormStatus(order_form_id,1);
        return mapping.findForward("orderForm");  
    }
}
