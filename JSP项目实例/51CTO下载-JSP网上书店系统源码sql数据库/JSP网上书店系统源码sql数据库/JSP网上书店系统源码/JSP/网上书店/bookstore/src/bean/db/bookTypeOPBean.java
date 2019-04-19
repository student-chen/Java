package bean.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.db.common.dbOpertaion;
/**
 * @author 邓子云
 * 封装对book_type表的操作
 */
public class bookTypeOPBean extends dbOpertaion{
    public ArrayList bookTypeArray=new ArrayList();
    public String bookTypeIdStr=new String("");
    /**
     * 构造函数,将所有书藉类型信息查询出来,并放入ArrayList中
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
     *通过书藉分类名称查找类型信息
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
     * 根据属性bookTypeIdStr查找书藉类型信息
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
     * 更新书藉分类
     * @param bookTypeId:类型ID号
     * @param bookTypeName:类型名称
     * @return int:返回更新的行数
     */
    public int updateBookType(int bookTypeId,String bookTypeName){
        if(bookTypeId==0||bookTypeName==null||bookTypeName.length()<=0)
            return 0;
        //------构造SQL语句------
        String sqlString="update book_type set type_name='"+bookTypeName +
        	"' where type_id="+bookTypeId;
        //------执行SQL语句------
        int i=this.executeUpdate(sqlString);
        return i;
    }
    /**
     * 新增一个书藉类型
     */
    public int insertBookType(String bookTypeName){
        int i=0;
        //------构造SQL语句------
        String sqlString="insert into book_type(type_name) values('"+bookTypeName+"')";
        //------执行SQL语句------
        i=this.executeUpdate(sqlString);
        return i;
    }
    /**
     * 删除一个书藉类型
     * @param bookTypeId:要删除的类型ID号
     * @return int:返回删除的类型个数
     */
    public int deleteBookType(int bookTypeId){
        int i=0;
        //------构造SQL语句------
        String sqlString="delete book_type where type_id="+bookTypeId;
        //------执行SQL语句------
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
  
