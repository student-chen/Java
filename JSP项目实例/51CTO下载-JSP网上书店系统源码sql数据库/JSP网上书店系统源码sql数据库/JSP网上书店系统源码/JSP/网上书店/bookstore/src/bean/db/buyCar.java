package bean.db;
import java.util.*;
import java.io.*;
public class buyCar implements Serializable
{  
  public Hashtable myGoods=new Hashtable();
  public void addGoods(Long Goods_id,int Goods_Count)
   { //把商品加入购物车
    if(myGoods.containsKey(Goods_id))
    {//购物车中存在此商品则累加个数
      int Temp_Count=((Integer)myGoods.get(Goods_id)).intValue();
      Temp_Count=Temp_Count+Goods_Count;
      myGoods.put(Goods_id,new Integer(Temp_Count));
    }else
    {//购物车中不存在此商品
      myGoods.put(Goods_id,new Integer(Goods_Count));
     }
   }
   public boolean minusGoods(Long Goods_id,int Goods_Count)
   { //把商品从购物车中拿出
    if(myGoods.containsKey(Goods_id))
    {//购物车中存在此商品则减少个数
      int Temp_Count=((Integer)myGoods.get(Goods_id)).intValue();
      Temp_Count=Temp_Count-Goods_Count;
      if(Temp_Count<=0)  
        deleteGoods(Goods_id);
      else
        myGoods.put(Goods_id,new Integer(Temp_Count));
      return true;
    } else
    {//购物车中不存在此商品
      return false;
     }
   }
  public Hashtable listMyGoods()
   {//得到购物车中所有商品
     return myGoods;
   } 
  public boolean deleteGoods(Long Goods_id)
   {//从购物车中删除一件商品
     if(myGoods.remove(Goods_id)==null)
       return false;
     else
       return true;
   }  
public Hashtable getMyGoods() {
    return myGoods;
}
public void setMyGoods(Hashtable myGoods) {
    this.myGoods = myGoods;
}
}
