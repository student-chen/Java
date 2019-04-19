package action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import bean.db.buyCar;
import bean.db.orderFormBean;
import bean.db.orderFormOPBean;
/**
 * @作者:邓子云
 * 生成订单,控制器类
 */
public class makeOrderFormAction extends Action{
    /**
     * 在此方法中处理HTTP请求数据，并作响应
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionErrors errors=new ActionErrors();
        orderFormOPBean orderFormOP=new orderFormOPBean();
        orderFormBean orderForm=new orderFormBean();
        //------得到用户ID和生成新的订单------
        long user_id=((Long)(request.getSession().getAttribute("user_id"))).longValue();
        int orderFormId=orderFormOP.newOrderForm(user_id);
        if(user_id==0||orderFormId==0){
            errors.add("newError",new ActionMessage("orderform.newError"));
            saveErrors(request,errors);
            return(new ActionForward(mapping.findForward("failure")));
        }
        //------往订单中写入数据------
        orderForm.setOrder_form_id(orderFormId); 
        orderForm.setUser_id(user_id);
        buyCar car=(buyCar) request.getSession().getAttribute("car");
        orderForm.setMyGoods(car.getMyGoods());
        orderFormOP.setOrderForm(orderForm);
        //------保存订单------
        int i=orderFormOP.saveOrderForm();
        if(i!=1){
            errors.add("saveError",new ActionMessage("orderform.saveError"));
            saveErrors(request,errors);
            return(new ActionForward(mapping.findForward("failure")));
        }
        request.removeAttribute(mapping.getAttribute());//删除formBean
        request.getSession().setAttribute("car",null);//删除购物车中的数据
        return mapping.findForward("orderForm");  
    }
}
