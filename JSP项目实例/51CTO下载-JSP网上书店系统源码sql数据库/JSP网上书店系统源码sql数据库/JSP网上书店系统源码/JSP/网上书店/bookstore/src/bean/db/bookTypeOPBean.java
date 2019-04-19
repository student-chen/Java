package bean.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.db.common.dbOpertaion;
/**
 * @author ������
 * ��װ��book_type��Ĳ���
 */
public class bookTypeOPBean extends dbOpertaion{
    public ArrayList bookTypeArray=new ArrayList();
    public String bookTypeIdStr=new String("");
    /**
     * ���캯��,���������������Ϣ��ѯ����,������ArrayList��
     */
    public bookTypeOPBean() {
        String sqlString="select * from book_type";
        ResultSet rs=this.executeQuery(sqlString);
        try{
            int i=0;
            while(rs.next()){
                bookTypeBean bookType=new bookTypeBean();
                bookType.setBookTypeId(rs.getInt("type_id"));
                bookType.setBookTypeName(rs.getString("type_name"));
                bookTypeArray.add(i,bookType);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            bookTypeArray=null;
        }
    }
    /**
     *ͨ�����������Ʋ���������Ϣ
     */
    public bookTypeBean selectBookTypeByName(String bookTypeName){
        if(bookTypeName==null) return null;
        bookTypeBean bookType=new bookTypeBean();
        String sqlString="select * from book_type where type_name='"+bookTypeName+"'";
        ResultSet rs=this.executeQuery(sqlString);
        try{
            int i=0;
            if(rs.next()){
                bookType.setBookTypeId(rs.getInt("type_id"));
                bookType.setBookTypeName(rs.getString("type_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return bookType;
    }
    /**
     * ��������bookTypeIdStr�������������Ϣ
     */
    public bookTypeBean selectBookTypeId(){
        int bookTypeId=0;
        if(bookTypeIdStr!=null&&bookTypeIdStr.length()>1)
            try{
                bookTypeId=Integer.parseInt(bookTypeIdStr);
            }catch (Exception e) {
                e.printStackTrace();
            }
        if(bookTypeId==0) return null;
        bookTypeBean bookType=new bookTypeBean();
        String sqlString="select * from book_type where type_id="+bookTypeId;
        ResultSet rs=this.executeQuery(sqlString);
        try{
            if(rs.next()){
                bookType.setBookTypeId(rs.getInt("type_id"));
                bookType.setBookTypeName(rs.getString("type_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return bookType;
    }
    /**
     * ����������
     * @param bookTypeId:����ID��
     * @param bookTypeName:��������
     * @return int:���ظ��µ�����
     */
    public int updateBookType(int bookTypeId,String bookTypeName){
        if(bookTypeId==0||bookTypeName==null||bookTypeName.length()<=0)
            return 0;
        //------����SQL���------
        String sqlString="update book_type set type_name='"+bookTypeName +
        	"' where type_id="+bookTypeId;
        //------ִ��SQL���------
        int i=this.executeUpdate(sqlString);
        return i;
    }
    /**
     * ����һ���������
     */
    public int insertBookType(String bookTypeName){
        int i=0;
        //------����SQL���------
        String sqlString="insert into book_type(type_name) values('"+bookTypeName+"')";
        //------ִ��SQL���------
        i=this.executeUpdate(sqlString);
        return i;
    }
    /**
     * ɾ��һ���������
     * @param bookTypeId:Ҫɾ��������ID��
     * @return int:����ɾ�������͸���
     */
    public int deleteBookType(int bookTypeId){
        int i=0;
        //------����SQL���------
        String sqlString="delete book_type where type_id="+bookTypeId;
        //------ִ��SQL���------
        i=this.executeUpdate(sqlString);
        return i;
    }
    public ArrayList getBookTypeArray() {
        return bookTypeArray;
    }
    public void setBookTypeArray(ArrayList bookTypeArray) {
        this.bookTypeArray = bookTypeArray;
    }
    public String getBookTypeIdStr() {
        return bookTypeIdStr;
    }
    public void setBookTypeIdStr(String bookTypeIdStr) {
        this.bookTypeIdStr = bookTypeIdStr;
    }
}
  
