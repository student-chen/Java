package bean.db.common;
public class stringUtil {
   static public String codeToString(String str)
    {//���������ַ����ĺ���
      String s=str;
      try{
        byte tempB[]=s.getBytes("ISO-8859-1");
        s=new String(tempB);
        return s;
       }catch(Exception e){
        return s;
       }  
    }
}
