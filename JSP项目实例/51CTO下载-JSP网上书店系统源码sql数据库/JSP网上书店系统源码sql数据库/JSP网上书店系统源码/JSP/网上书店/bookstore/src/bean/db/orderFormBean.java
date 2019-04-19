package bean.db;

import java.util.Hashtable;

/**
 * @author 邓子云
 * 封装一张订单
 */
public class orderFormBean {
    long order_form_id=0;//订单ID号
    long user_id=0;//订单所属用户ID号
    int status=0;//订单处理状态
    Hashtable myGoods=new Hashtable();//订单中的数据
    
    public long getOrder_form_id() {
        return order_form_id;
    }
    public void setOrder_form_id(long order_form_id) {
        this.order_form_id = order_form_id;
    }
    public long getUser_id() {
        return user_id;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public Hashtable getMyGoods() {
        return myGoods;
    }
    public void setMyGoods(Hashtable myGoods) {
        this.myGoods = new Hashtable(myGoods);
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
