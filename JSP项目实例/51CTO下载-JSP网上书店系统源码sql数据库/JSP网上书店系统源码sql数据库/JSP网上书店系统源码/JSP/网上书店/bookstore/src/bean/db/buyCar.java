package bean.db;
import java.util.*;
import java.io.*;
public class buyCar implements Serializable
{  
  public Hashtable myGoods=new Hashtable();
  public void addGoods(Long Goods_id,int Goods_Count)
   { //����Ʒ���빺�ﳵ
    if(myGoods.containsKey(Goods_id))
    {//���ﳵ�д��ڴ���Ʒ���ۼӸ���
      int Temp_Count=((Integer)myGoods.get(Goods_id)).intValue();
      Temp_Count=Temp_Count+Goods_Count;
      myGoods.put(Goods_id,new Integer(Temp_Count));
    }else
    {//���ﳵ�в����ڴ���Ʒ
      myGoods.put(Goods_id,new Integer(Goods_Count));
     }
   }
   public boolean minusGoods(Long Goods_id,int Goods_Count)
   { //����Ʒ�ӹ��ﳵ���ó�
    if(myGoods.containsKey(Goods_id))
    {//���ﳵ�д��ڴ���Ʒ����ٸ���
      int Temp_Count=((Integer)myGoods.get(Goods_id)).intValue();
      Temp_Count=Temp_Count-Goods_Count;
      if(Temp_Count<=0)  
        deleteGoods(Goods_id);
      else
        myGoods.put(Goods_id,new Integer(Temp_Count));
      return true;
    } else
    {//���ﳵ�в����ڴ���Ʒ
      return false;
     }
   }
  public Hashtable listMyGoods()
   {//�õ����ﳵ��������Ʒ
     return myGoods;
   } 
  public boolean deleteGoods(Long Goods_id)
   {//�ӹ��ﳵ��ɾ��һ����Ʒ
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
