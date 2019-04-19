package bean.db;
/**
 * @author 邓子云
 * 封装book_type表的一条记录
 */
public class bookTypeBean {
    private int bookTypeId=0;//书藉类型ID号
    private String bookTypeName=null;//书藉类型名称
    public int getBookTypeId() {
        return bookTypeId;
    }
    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }
    public String getBookTypeName() {
        return bookTypeName;
    }
    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }
}
