package form;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import bean.db.common.stringUtil;
/**
 * @作者:邓子云
 * 录入书藉表单类
 */
public class addBookForm extends ActionForm{
    private String bookname=null;
    private String typeid=null;
    private String author=null;
    private String publisher=null;
    private String price=null;
    private String price_rebate=null;
    private String publishdate=null;
    private String pagecount=null;
    private String format=null;
    private String simple_content=null;
    /**
     * 重置所有属性的值
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.bookname=null;
        this.bookname=null;
        this.typeid=null;
        this.author=null;
        this.publisher=null;
        this.price=null;
        this.price_rebate=null;
        this.publishdate=null;
        this.pagecount=null;
        this.format=null;
        this.simple_content=null;
    }
    /**
     * 验证属性的值
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors=new ActionErrors();
        //------书藉名校验------
        if(bookname==null||bookname.trim().length()<1)
            errors.add("bookname",new ActionMessage("book.bookNameNull"));
        //------书藉所属种类校验------
        if(typeid==null||typeid.trim().length()<1)
            errors.add("typeid",new ActionMessage("book.typeIdNull"));
        //------价格校验------
        if(price!=null&&price.trim().length()>=1){
            try{
                Float.parseFloat(price);
            }catch(Exception e){
                e.printStackTrace();
                errors.add("price",new ActionMessage("book.priceNotFloat"));
            }
        }else{
            price=new String("0");
        }
        //------折扣校验------
        if(price_rebate!=null&&price_rebate.trim().length()>=1){
            try{
                Float.parseFloat(price_rebate);
                if(Float.parseFloat(price_rebate)<0||Float.parseFloat(price_rebate)>10)
                    errors.add("price_rebate",new ActionMessage("book.priceRebateNotFloat"));
            }catch(Exception e){
                e.printStackTrace();
                errors.add("price_rebate",new ActionMessage("book.priceRebateNotFloat"));
            }
        }else{
            price_rebate=new String("10");
        }
        //------出版日期校验------
        if(publishdate!=null&&publishdate.trim().length()>=1){
            publishdate=publishdate.trim();
            String dateArray[]=publishdate.split("-");
            if(dateArray.length!=3)
                errors.add("publishdate",new ActionMessage("book.publishDateError"));
            else{
                try{
                    Integer.parseInt(dateArray[0]);
                    Integer.parseInt(dateArray[1]);
                    Integer.parseInt(dateArray[2]);
                }catch(Exception e){
                    e.printStackTrace();
                    errors.add("publishdate",new ActionMessage("book.publishDateError"));
                }
            }
        }else{
            publishdate=new String("");
        }
        //------页数检验------
        if(pagecount!=null&&pagecount.trim().length()>=1){
           try{
                Integer.parseInt(pagecount);
            }catch(Exception e){
                e.printStackTrace();
                errors.add("pagecount",new ActionMessage("book.pageCountError"));
            }
        }else{
            pagecount=new String("0");
        }
        //System.out.print(errors.size());
        return errors;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = stringUtil.codeToString(bookname);
    }
    public String getPagecount() {
        return pagecount;
    }
    public void setPagecount(String pagecount) {
        this.pagecount = stringUtil.codeToString(pagecount);
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = stringUtil.codeToString(price);
    }
    public String getPrice_rebate() {
        return price_rebate;
    }
    public void setPrice_rebate(String price_rebate) {
        this.price_rebate = stringUtil.codeToString(price_rebate);
    }
    public String getPublishdate() {
        return publishdate;
    }
    public void setPublishdate(String publishdate) {
        this.publishdate = stringUtil.codeToString(publishdate);
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = stringUtil.codeToString(publisher);
    }
    public String getSimple_content() {
        return simple_content;
    }
    public void setSimple_content(String simple_content) {
        this.simple_content = stringUtil.codeToString(simple_content);
    }
    public String getTypeid() {
        return typeid;
    }
    public void setTypeid(String typeid) {
        this.typeid = stringUtil.codeToString(typeid);
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = stringUtil.codeToString(author);
    }
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = stringUtil.codeToString(format);
    }
}