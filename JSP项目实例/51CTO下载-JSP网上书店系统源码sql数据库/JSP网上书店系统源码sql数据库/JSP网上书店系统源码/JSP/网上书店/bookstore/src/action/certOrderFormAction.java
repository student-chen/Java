package action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import bean.db.orderFormOPBean;
/**
 * @作者:邓子云
 * 确认订单,控制器类
 */
public class certOrderFormAction extends Action{
    /**
     * 在此方法中处理HTTP请求数据，并作响应
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        //------接收要取消的订单号------
        long order_form_id=0;
        try{
            order_form_id=Long.parseLong(request.getParameter("order_form_id"));
        }catch(Exception e){
            e.printStackTrace();
        }
        //------确认订单------
        orderFormOPBean orderFormOP=new orderFormOPBean();
        orderFormOP.modiOrderFormStatus(order_form_id,1);
        return mapping.findForward("orderForm");  
    }
}
