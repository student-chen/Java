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
 * @����:������
 * ���ɶ���,��������
 */
public class makeOrderFormAction extends Action{
    /**
     * �ڴ˷����д���HTTP�������ݣ�������Ӧ
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionErrors errors=new ActionErrors();
        orderFormOPBean orderFormOP=new orderFormOPBean();
        orderFormBean orderForm=new orderFormBean();
        //------�õ��û�ID�������µĶ���------
        long user_id=((Long)(request.getSession().getAttribute("user_id"))).longValue();
        int orderFormId=orderFormOP.newOrderForm(user_id);
        if(user_id==0||orderFormId==0){
            errors.add("newError",new ActionMessage("orderform.newError"));
            saveErrors(request,errors);
            return(new ActionForward(mapping.findForward("failure")));
        }
        //------��������д������------
        orderForm.setOrder_form_id(orderFormId); 
        orderForm.setUser_id(user_id);
        buyCar car=(buyCar) request.getSession().getAttribute("car");
        orderForm.setMyGoods(car.getMyGoods());
        orderFormOP.setOrderForm(orderForm);
        //------���涩��------
        int i=orderFormOP.saveOrderForm();
        if(i!=1){
            errors.add("saveError",new ActionMessage("orderform.saveError"));
            saveErrors(request,errors);
            return(new ActionForward(mapping.findForward("failure")));
        }
        request.removeAttribute(mapping.getAttribute());//ɾ��formBean
        request.getSession().setAttribute("car",null);//ɾ�����ﳵ�е�����
        return mapping.findForward("orderForm");  
    }
}
