package bean.db;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.struts.action.ActionForm;
import form.addBookForm;
import bean.db.common.dbOpertaion;
/**
 * @author 邓子云
 * 封装对book表的操作
 */
public class bookOPBean extends dbOpertaion{
    private int bookid=0;
    private bookBean book=new bookBean();
    private int bookTypeId=0;
    /**
     * 查询出书藉资料
     */
    public ArrayList selectBook(String bookname){
        //------构造SQL语句------
        String sqlString=null;
        if(bookname==null||bookname.trim().length()<=0)
            sqlString=new String("select * from book");
        else
            sqlString=new String("select * from book where book_name like '%"+bookname+"%'");
        sqlString=sqlString+" order by add_time desc";
        //------查询出数据------
        ArrayList rsArrayList=selectBookBySQL(sqlString);
        return rsArrayList;
    }
    /**
     * 查询出最近的100本书
     */
    public ArrayList selectBook100(){
        String sqlString=new String("select top 100 * from book order by add_time desc");
        ArrayList rsArrayList=selectBookBySQL(sqlString);
        return rsArrayList;
    }
    /**
     * 查询出特价书藉的前7本，5折用其以下的
     */
    public ArrayList selectBookMiniPriceTop7(){
        String sqlString=new String("select top 7 * from book where price_rebate<=5 order by add_time desc");
        ArrayList rsArrayList=selectBookBySQL(sqlString);
        return rsArrayList;
    }
    /**
     * 查询出特价书藉的前6本，5折用其以下的
     */
    public ArrayList selectBookMiniPriceTop6(){
        String sqlString=new String("select top 6 * from book where price_rebate<=5 order by add_time desc");
        ArrayList rsArrayList=selectBookBySQL(sqlString);
        return rsArrayList;
    }
    /**
     * 查询出所有特价书藉，5折用其以下的
     */
    public ArrayList selectBookMiniPrice(){
        String sqlString=new String("select * from book where price_rebate<=5 order by add_time desc");
        ArrayList rsArrayList=selectBookBySQL(sqlString);
        return rsArrayList;
    }
    /**
     * 查询出最近录入的6本新书
     */
    public ArrayList selectBookTop6(){
        //------构造SQL语句------
        String sqlString=new String("select top 6 * from book order by add_time desc");
        //------查询出数据------
        ArrayList rsArrayList=selectBookBySQL(sqlString);
        return rsArrayList;
    }
    /**
     * 查询出某个分类的前6本书藉,并按时间排序
     */
    public ArrayList selectBookByTypeTop6(){
        //------构造SQL语句------
        String sqlString=new String("select top 6 * from book where type_id="+
                bookTypeId+ " order by add_time desc");
        //------查询出数据------
        ArrayList rsArrayList=selectBookBySQL(sqlString);
        return rsArrayList;
    }
    /**
     * 查询出某个分类的书藉的数据,并按时间排序
     */
    public ArrayList selectBookByType(){
        //------构造SQL语句------
        String sqlString=new String("select * from book where type_id="+
                bookTypeId+ " order by add_time desc");
        //------查询出数据------
        ArrayList rsArrayList=selectBookBySQL(sqlString);
        return rsArrayList;
    }
    /**
     * 根据SQL语句查询出书藉,并放入ArrayList
     */
    public ArrayList selectBookBySQL(String sqlString){
        ResultSet rs=this.executeQuery(sqlString);
        //------将查询出的数据放入ArrayList中------
        ArrayList rsArrayList=new ArrayList();
        try{
            int i=0;
            while(rs.next()){
                rsArrayList.add(i,dealARecord(rs));
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            rsArrayList=null;
        }
        return rsArrayList;
    }
    /**
     * 一条记录的处理,私有方法
     */
    private bookBean dealARecord(ResultSet rs){
        bookBean book=new bookBean();
        try{
            book.setBookid(rs.getLong("book_id"));
            book.setBookname(rs.getString("book_name"));
            book.setAuthor(rs.getString("author"));
            book.setPublisher(rs.getString("publisher"));
            book.setPrice(rs.getFloat("price"));
            book.setPrice_rebate(rs.getFloat("price_rebate"));
            book.setPublish_date(rs.getDate("publish_date"));
            book.setPagecount(rs.getInt("pagecount"));
            book.setFormat(rs.getString("format"));
            book.setSimple_content(rs.getString("simple_content"));
            book.setTypeid(rs.getInt("type_id")); 
            //------图片处理------
            InputStream in=rs.getBinaryStream("book_image");
            if(in!=null){
                try{
                    int len = 10*1024*1024;
                    byte[] P_Buf = new byte[len];
                    int j;
                    while ((j = in.read(P_Buf)) != -1) {
                        byte[] oldByteArray=book.getImageByteArray();
                        byte[] newByteArray=null;
                        if(oldByteArray!=null){
                            newByteArray=new byte[oldByteArray.length+j];
                            for(int k=0;k<j;k++)
                                newByteArray[oldByteArray.length+k]=P_Buf[k];
                        }else{
                            newByteArray=new byte[j];
                            for(int k=0;k<j;k++)
                                newByteArray[k]=P_Buf[k];
                        }  
                        book.setImageByteArray(newByteArray);
                    }
                }catch(NullPointerException e1){
                    e1.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
    /**
     * 根据ID号查询出一本书藉的资料
     */
    public bookBean selectBookById(int bookid){
        //------构造SQL语句------
        String sqlString="select * from book where book_id="+bookid;
        //------查询出数据------
        ResultSet rs=this.executeQuery(sqlString);
        //------将查询出的数据放入bookBean中------
        bookBean book=new bookBean();
        try{
            if(rs.next()){      
                book=dealARecord(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            book=null;
        }
        return book;
    }
    /**
     * 新书上架
     */
    public int insertBook(ActionForm form){
        int i=0;
        //------从ActionForm对象中得到数据------
        String bookname=((addBookForm)form).getBookname();
        String typeid=((addBookForm)form).getTypeid();
        String author=((addBookForm)form).getAuthor();
        String publisher=((addBookForm)form).getPublisher();
        String price=((addBookForm)form).getPrice();
        String price_rebate=((addBookForm)form).getPrice_rebate();
        String publishdate=((addBookForm)form).getPublishdate();
        String pagecount=((addBookForm)form).getPagecount();
        String format=((addBookForm)form).getFormat();
        String simple_content=((addBookForm)form).getSimple_content();
        //------构造SQL语句------
        String sqlString="insert into book(book_name,author,publisher"
            +",price,price_rebate,publish_date,pagecount,format,simple_content"
            +",type_id) values('"+bookname+"','"+author+"','"+publisher
            +"',"+price+","+price_rebate+",'"+publishdate+"',"+pagecount
            +",'"+format+"','"+simple_content+"',"+typeid+")";
        //System.out.println(sqlString);
        //------执行SQL语句------
        i=this.executeUpdate(sqlString);
        return i;
    }
    /**
     * 删除一本书
     */
    public int deleteBook(int bookid){
        int i=0;
        if(bookid<=0) return i;
        String sqlString="delete from book where book_id="+bookid;
        i=this.executeUpdate(sqlString);
        return i;
    }
    /**
     * 更新一本书的书藉信息
     */
    public int updateBook(ActionForm form,int bookid){
        int i=0;
        //------从ActionForm对象中得到数据------
        String bookname=((addBookForm)form).getBookname();
        String typeid=((addBookForm)form).getTypeid();
        String author=((addBookForm)form).getAuthor();
        String publisher=((addBookForm)form).getPublisher();
        String price=((addBookForm)form).getPrice();
        String price_rebate=((addBookForm)form).getPrice_rebate();
        String publishdate=((addBookForm)form).getPublishdate();
        String pagecount=((addBookForm)form).getPagecount();
        String format=((addBookForm)form).getFormat();
        String simple_content=((addBookForm)form).getSimple_content();
        //------构造SQL语句------
        String sqlString="update book set book_name='" +bookname+"',author='" +
        	author+"',publisher='"+publisher+"',price="+price+",price_rebate=" +
        	price_rebate+",publish_date='"+publishdate+"',pagecount=" +
        	pagecount+",format='"+format+"',simple_content='"+simple_content+
        	"',type_id="+typeid+" where book_id="+bookid;
        //System.out.println(sqlString);
        //------执行SQL语句------
        i=this.executeUpdate(sqlString);
        return i;
    }
    public int getBookid() {
        return bookid;
    }
    public void setBookid(int bookid) {
        this.bookid = bookid;
        this.book=this.selectBookById(bookid);     
    }
    public bookBean getBook() {
        return book;
    }
    public void setBook(bookBean book) {
        this.book = book;
    }
    public int getBookTypeId() {
        return bookTypeId;
    }
    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }
}
