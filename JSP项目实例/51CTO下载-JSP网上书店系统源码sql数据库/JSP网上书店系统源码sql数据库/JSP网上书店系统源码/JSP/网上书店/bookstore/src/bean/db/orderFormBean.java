package bean.db;

import java.util.Hashtable;

/**
 * @author ������
 * ��װһ�Ŷ���
 */
public class orderFormBean {
    long order_form_id=0;//����ID��
    long user_id=0;//���������û�ID��
    int status=0;//��������״̬
    Hashtable myGoods=new Hashtable();//�����е�����
    
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
