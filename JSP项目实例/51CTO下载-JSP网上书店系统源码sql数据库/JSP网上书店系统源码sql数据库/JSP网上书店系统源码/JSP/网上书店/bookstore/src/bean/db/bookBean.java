package bean.db;
import java.sql.Date;
import bean.db.common.dbOpertaion;
/**
 * @author ������
 * ��װbook���һ����¼
 */
public class bookBean extends dbOpertaion{
    public long bookid=0;//���ID��
    private String bookname=null;//����
    private int typeid=0;//�������͵�ID��
    private String author=null;//����
    private String publisher=null;//������
    private float price=0;//�۸�
    private float price_rebate=0;//�۸��ۿ���
    private Date publish_date;//��������
    private int pagecount=0;//��ҳ��
    private String format=null;//����
    private String simple_content=null;//���ݼ�� 
    byte[] imageByteArray=null;//���ķ���ͼƬ����
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
