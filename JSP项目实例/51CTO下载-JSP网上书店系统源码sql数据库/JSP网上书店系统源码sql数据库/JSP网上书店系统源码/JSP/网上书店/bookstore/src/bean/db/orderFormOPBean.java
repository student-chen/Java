package bean.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import bean.db.common.dbOpertaion;
/**
 * @author 邓子云
 * 封装对订单的操作
 */
public class orderFormOPBean  extends dbOpertaion{
    private orderFormBean orderForm=new orderFormBean();
    /**
     * 生成一张新的订单,返回订单号
     */
    public int newOrderForm(long userId){
        int i=0;
        //------构造SQL语句------
        String sqlString="insert into order_form(user_id) values("+userId+")";
        //------执行SQL语句------
        i=this.executeUpdate(sqlString);
        if(i!=1) return 0;
        else{
            sqlString="select * from order_form where user_id="+userId;
            ResultSet rs=this.executeQuery(sqlString);
            try{
                if(rs.next()){
                    rs.last();
                    orderForm.order_form_id=rs.getLong("order_form_id");
                    orderForm.user_id=userId;
                    return rs.getInt("order_form_id");
                }else
                    return 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return 0;
            } 
        }           
    }
    /**
     * 从数据库中取出已有订单中的数据
     */
    public orderFormBean initOrderForm(long order_form_id){
        String sqlString="select * from order_form where order_form_id="+order_form_id;
        ResultSet rs=this.executeQuery(sqlString);
        try{
            if(rs.next()){//如果存在,则取出数据
                orderFormBean theOrderForm=new orderFormBean();
                theOrderForm.setOrder_form_id(order_form_id);
                theOrderForm.setUser_id(rs.getInt("user_id"));
                theOrderForm.setStatus(rs.getInt("status"));
                //------取出订单中的书藉订购信息------
                sqlString="select * from order_form_book where order_form_id="+
                	order_form_id;
                ResultSet rsBook=this.executeQuery(sqlString);
                while(rsBook.next()){
                    int Temp_Count=rsBook.getInt("book_count");
                    long Goods_id=rsBook.getLong("book_id");                   
                    theOrderForm.myGoods.put(new Long(Goods_id),new Integer(Temp_Count));
                }
                return theOrderForm;
            }else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 得到某用户的所有订单
     */
    public ArrayList getUserOrderForms(long user_id){
        String sqlString="select * from order_form where user_id="+user_id+" order by add_time desc";
        ResultSet rs=this.executeQuery(sqlString);
        try{
            ArrayList orderFormBeans=new ArrayList();
            while(rs.next()){
                orderFormBean theOrderForm=initOrderForm(rs.getLong("order_form_id"));
                orderFormBeans.add(theOrderForm);
            }
            return orderFormBeans;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 根据订单号和订单状态这两个条件查询出订单
     */
    public ArrayList getOrderForms(String order_form_id,int status){
        String sqlString=new String("");
        if(order_form_id==null||order_form_id.length()==0)
            sqlString="select * from order_form where status="+status+" order by add_time desc";
        else
            sqlString="select * from order_form where order_form_id="+order_form_id
              +" and status="+status+" order by add_time desc";
        ResultSet rs=this.executeQuery(sqlString);
        try{
            ArrayList orderFormBeans=new ArrayList();
            while(rs.next()){
                orderFormBean theOrderForm=initOrderForm(rs.getLong("order_form_id"));
                orderFormBeans.add(theOrderForm);
            }
            return orderFormBeans;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 保存订单到数据库中
     */
    public int saveOrderForm(){
        int i=1;
        //------订单尚未生成------
        if(orderForm.order_form_id==0) return 0;;
        //------订单已生成,则保存订单------
        Hashtable myGoods=orderForm.getMyGoods();
        Enumeration enum=myGoods.keys();
        while(enum.hasMoreElements()){
            Long Goods_id=(Long)enum.nextElement();
            String sqlString="select * from order_form_book where order_form_id="+
            	orderForm.order_form_id+" and book_id="+Goods_id.longValue();
            ResultSet rs=this.executeQuery(sqlString);
            try{
                if(!rs.next()){//如果不存在,则作插入处理
                   int book_count=((Integer)myGoods.get(Goods_id)).intValue();
                    sqlString="insert into order_form_book(order_form_id,book_id,book_count)"+
                    	" values("+orderForm.order_form_id+","+Goods_id.longValue()+
                    	","+book_count+")";
                    this.executeUpdate(sqlString);
                }else{//如果存在,则作更新操作
                    int book_count=((Integer)myGoods.get(Goods_id)).intValue();
                    sqlString="update order_form_book set book_count="+book_count
                    	+" where order_form_id="+orderForm.order_form_id+" and "
                    	+"book_id="+Goods_id.longValue();
                    this.executeUpdate(sqlString);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                i=0;
            }      
        } 
        return i;
    }
    /**
     * 取消订单
     */
    public void deleteOrderForm(long order_form_id){
        String sqlString1="delete from order_form_book where order_form_id="+order_form_id;
        String sqlString2="delete from order_form where order_form_id="+order_form_id;
        this.executeUpdate(sqlString1);
        this.executeUpdate(sqlString2);
    }
    /**
     * 修改订单状态
     */
    public boolean modiOrderFormStatus(long order_form_id,int newStatus){
        String sqlString=new String(""); 
        if(newStatus==0) return false;//新订单状态为0，此状态不可逆转
        orderFormBean orderForm=initOrderForm(order_form_id);
        switch(newStatus){
        	case 1://只能是0-->1
        	    if(orderForm.getStatus()!=0) return false;
        	    else
        	        sqlString="update order_form set status=1 where order_form_id="+order_form_id;
        	    break;
        	case 2://只能是1-->2
        	    if(orderForm.getStatus()!=1) return false;
        	    else
        	        sqlString="update order_form set status=2 where order_form_id="+order_form_id;
        	    break;
        	case 3://只能是2-->3
        	    if(orderForm.getStatus()!=2) return false;
        	    else
        	        sqlString="update order_form set status=3 where order_form_id="+order_form_id;
        	    break;
        	case 4://只能是2-->4
        	    if(orderForm.getStatus()!=2) return false;
        	    else
        	        sqlString="update order_form set status=4 where order_form_id="+order_form_id;
        	    break;
        	default:
        	    return false;
        }
        int i=this.executeUpdate(sqlString);
        if(i==1) return true;
        else return false;
    }
    
    public orderFormBean getOrderForm() {
        return orderForm;
    }
    public void setOrderForm(orderFormBean orderForm) {
        this.orderForm = orderForm;
    }
}
