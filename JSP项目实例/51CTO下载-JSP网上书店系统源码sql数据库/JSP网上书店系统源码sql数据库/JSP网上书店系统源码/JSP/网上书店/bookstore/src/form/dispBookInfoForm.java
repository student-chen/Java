package form;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
/**
 * @����:������
 * ¼��������
 */
public class dispBookInfoForm extends ActionForm{
    private String page=new String("1");
    private String bookname=new String("");
    /**
     * �����������Ե�ֵ
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
