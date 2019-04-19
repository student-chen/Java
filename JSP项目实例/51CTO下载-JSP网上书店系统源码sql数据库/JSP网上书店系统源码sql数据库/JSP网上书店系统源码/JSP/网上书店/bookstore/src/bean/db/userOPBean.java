package bean.db;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.db.common.dbOpertaion;
/**
 * @author ������
 * ��װ���û���Ĳ���
 */
public class userOPBean extends dbOpertaion{
    /**
     * ����һ���û�
     */  
    public int addUser(userBean user){
        int i=0;
        //------Ϊ�������ժҪ------
        String codeMD5=null;
        try{
            MessageDigest MD=MessageDigest.getInstance("MD5");
            MD.update((user.getUser_name()+user.getUser_password()).getBytes("UTF8"));
            byte[] passwordMD5Byte=MD.digest();
            codeMD5=new String(passwordMD5Byte);
            codeMD5=new String(codeMD5.getBytes("iso-8859-1"));
        }catch(Exception e){
    		e.printStackTrace();
    		i=0;
        }
        //------����SQL���------
        String sqlString="insert into netuser(user_name,user_true_name,user_address,"+
            "user_telephone,user_postalcode,user_role,user_password) values('"+
            user.getUser_name()+"','"+user.getUser_true_name()+"','"+user.getUser_address()+
            "','"+user.getUser_telephone()+"','"+user.getUser_postalcode()+"',"+
            user.getUser_role()+",?)";
        Connection conn=openDB();
        try{
            PreparedStatement preSQLInsert=conn.prepareStatement(sqlString);
            preSQLInsert.setString(1,codeMD5);
            i=preSQLInsert.executeUpdate();
        }catch(Exception e){
    		e.printStackTrace();
    		i=0;
        }
        closeDB(conn);
        return i;
    }
    /**
     * �û�����,���ʧ�ܷ���0,����ɹ������û���ID��
     */
    public long certUser(String user_name,String user_password){
        long i=0;
        //------Ϊ�������ժҪ------
        String codeMD5=null;
        try{
            MessageDigest MD=MessageDigest.getInstance("MD5");
            MD.update((user_name+user_password).getBytes("UTF8"));
            byte[] passwordMD5Byte=MD.digest();
            codeMD5=new String(passwordMD5Byte);
            codeMD5=new String(codeMD5.getBytes("iso-8859-1"));
        }catch(Exception e){
    		e.printStackTrace();
        }
        //------����SQL���------
        String sqlString="select * from netuser where user_name='"+
        	user_name+"' and user_password=?";
        //------��ѯ������------
        Connection conn=openDB();
        try{
            PreparedStatement preSQLSelect=conn.prepareStatement(sqlString);
            preSQLSelect.setString(1,codeMD5);
            ResultSet rs=preSQLSelect.executeQuery();
            if(rs.next())
                i=rs.getLong("user_id");
        }catch(Exception e){
    		e.printStackTrace();
        }
        closeDB(conn);
        return i;     
    }
}
