package bean.db.common;
public class stringUtil {
   static public String codeToString(String str)
    {//处理中文字符串的函数
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
