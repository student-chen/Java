package form;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
/**
 * @作者:邓子云
 * 订单查询类
 */
public class viewOrderForm extends ActionForm{
    private String page=new String("1");
    private String orderformid=new String("");
    private String status=new String("");
    /**
     * 重置所有属性的值
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        page=new String("1");
        orderformid=new String("");
        status=new String("");
    }
    public String getPage() {
        return page;
    }
    public void setPage(String page) {
        this.page = page;
    }
    public String getOrderformid() {
        return orderformid;
    }
    public void setOrderformid(String orderformid) {
        this.orderformid = orderformid;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
