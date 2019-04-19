package action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import bean.db.buyCar;
/**
 * @����:������
 *�ӹ��ﳵ���ó�һ����,��������
 */
public class deleteBookFromCarAction extends Action{
    /**
     * �ڴ˷����д���HTTP�������ݣ�������Ӧ
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        //------����Ҫ�ӹ��ﳵ�ó������ID��------
        long book_id=0;
        try{
            book_id=Long.parseLong(request.getParameter("book_id"));
        }catch(Exception e){
            e.printStackTrace();
            book_id=0;
        }
        //------���빺�ﳵ------
        if(book_id!=0){
            buyCar car=(buyCar)request.getSession().getAttribute("car");
            if(car==null) car=new buyCar();
            car.minusGoods(new Long(book_id),1);
            request.getSession().setAttribute("car",car);
        }       
        return mapping.findForward("buycar");  
    }
}
