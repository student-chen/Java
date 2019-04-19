package bean.db.common;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbOpertaion {
    /**
     * ִ��SQL��ѯ���
     */
    public ResultSet executeQuery(String sqlString){
        if(sqlString==null) return null;
        Connection conn=openDB();
        ResultSet rs=null;//�����¼��
        Statement sql=null;//SQL������
        try{
            sql=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=sql.executeQuery(sqlString);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            rs=null;
        }
        closeDB(conn);
        return rs;
    }
    /**
     * ִ��SQL�������,����Ӱ�������
     */
    public int executeUpdate(String sqlString){
        if(sqlString==null) return 0;
        Connection conn=openDB();
        Statement sql=null;//SQL������
        int i=0;//Ӱ�������
        try{
            sql=conn.createStatement();
            i=sql.executeUpdate(sqlString);
        } catch (SQLException e) {
            e.printStackTrace();
            i=0;
        }
        closeDB(conn);
        return i;
    }
    /**
     * �����ݿ�����
     */
    public Connection openDB(){
        dbconn dbconnOBject=new dbconn();//���ݿ����Ӷ���
        Connection dbconn=dbconnOBject.getDBConn();//�õ����ݿ�����
        return dbconn;
    }
    /**
     * �ر����ݿ�����
     */
    public void closeDB(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
