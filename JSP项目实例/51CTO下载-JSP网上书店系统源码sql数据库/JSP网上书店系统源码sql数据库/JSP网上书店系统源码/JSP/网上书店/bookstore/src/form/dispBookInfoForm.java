package form;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
/**
 * @作者:邓子云
 * 录入书藉表单类
 */
public class dispBookInfoForm extends ActionForm{
    private String page=new String("1");
    private String bookname=new String("");
    /**
     * 重置所有属性的值
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        page=new String("1");
        bookname=new String("");
    }
    public String getPage() {
        return page;
    }
    public void setPage(String page) {
        this.page = page;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
