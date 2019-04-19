package bean.db.common;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbOpertaion {
    /**
     * 执行SQL查询语句
     */
    public ResultSet executeQuery(String sqlString){
        if(sqlString==null) return null;
        Connection conn=openDB();
        ResultSet rs=null;//结果记录集
        Statement sql=null;//SQL语句对象
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
     * 执行SQL更新语句,返回影响的行数
     */
    public int executeUpdate(String sqlString){
        if(sqlString==null) return 0;
        Connection conn=openDB();
        Statement sql=null;//SQL语句对象
        int i=0;//影响的行数
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
     * 打开数据库连接
     */
    public Connection openDB(){
        dbconn dbconnOBject=new dbconn();//数据库连接对象
        Connection dbconn=dbconnOBject.getDBConn();//得到数据库连接
        return dbconn;
    }
    /**
     * 关闭数据库连接
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
