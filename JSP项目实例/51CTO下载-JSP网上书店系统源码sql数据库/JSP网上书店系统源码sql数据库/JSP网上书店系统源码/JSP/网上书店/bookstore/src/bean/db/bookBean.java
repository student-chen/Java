package bean.db;
import java.sql.Date;
import bean.db.common.dbOpertaion;
/**
 * @author 邓子云
 * 封装book表的一条记录
 */
public class bookBean extends dbOpertaion{
    public long bookid=0;//书藉ID号
    private String bookname=null;//书名
    private int typeid=0;//所属类型的ID号
    private String author=null;//作者
    private String publisher=null;//出版社
    private float price=0;//价格
    private float price_rebate=0;//价格折扣率
    private Date publish_date;//出版日期
    private int pagecount=0;//总页数
    private String format=null;//开本
    private String simple_content=null;//内容简介 
    byte[] imageByteArray=null;//书藉的封面图片数据
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public long getBookid() {
        return bookid;
    }
    public void setBookid(long bookid) {
        this.bookid = bookid;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public int getPagecount() {
        return pagecount;
    }
    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public float getPrice_rebate() {
        return price_rebate;
    }
    public void setPrice_rebate(float price_rebate) {
        this.price_rebate = price_rebate;
    }
    public Date getPublish_date() {
        return publish_date;
    }
    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getSimple_content() {
        return simple_content;
    }
    public void setSimple_content(String simple_content) {
        this.simple_content =simple_content;
    }
    public int getTypeid() {
        return typeid;
    }
    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }
    public byte[] getImageByteArray() {
        return imageByteArray;
    }
    public void setImageByteArray(byte[] imageByteArray) {
        this.imageByteArray = imageByteArray;
    }
}
