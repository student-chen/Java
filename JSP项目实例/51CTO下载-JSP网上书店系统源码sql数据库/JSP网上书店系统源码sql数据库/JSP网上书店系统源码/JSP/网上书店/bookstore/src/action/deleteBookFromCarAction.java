package action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import bean.db.buyCar;
/**
 * @作者:邓子云
 *从购物车中拿出一本书,控制器类
 */
public class deleteBookFromCarAction extends Action{
    /**
     * 在此方法中处理HTTP请求数据，并作响应
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        //------接收要从购物车拿出的书藉ID号------
        long book_id=0;
        try{
            book_id=Long.parseLong(request.getParameter("book_id"));
        }catch(Exception e){
            e.printStackTrace();
            book_id=0;
        }
        //------放入购物车------
        if(book_id!=0){
            buyCar car=(buyCar)request.getSession().getAttribute("car");
            if(car==null) car=new buyCar();
            car.minusGoods(new Long(book_id),1);
            request.getSession().setAttribute("car",car);
        }       
        return mapping.findForward("buycar");  
    }
}
