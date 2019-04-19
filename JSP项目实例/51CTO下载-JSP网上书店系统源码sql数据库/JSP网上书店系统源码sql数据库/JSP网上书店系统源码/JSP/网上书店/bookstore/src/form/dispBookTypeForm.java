package form;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import bean.db.bookTypeOPBean;
import bean.db.common.stringUtil;
/**
 * @����:������
 * ¼�����������
 */
public class dispBookTypeForm extends ActionForm{
    private String page=new String("1");
    private String booktypename=new String("");
    /**
     * �����������Ե�ֵ
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        page=new String("1");
        booktypename=new String("");
    }
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors=new ActionErrors();
        //------���������У��------
        if(booktypename!=null&&booktypename.trim().length()>1){
            booktypename=booktypename.trim();
            bookTypeOPBean bookTypeOP=new bookTypeOPBean();
            if(bookTypeOP.selectBookTypeByName(booktypename)==null){
                errors.add("booktyehaved",new ActionMessage("bookType.bookTypeHaved"));;
            }
        }      
        return errors;
    }
    public String getPage() {
        return page;
    }
    public void setPage(String page) {
        this.page = page;
    }

    public String getBooktypename() {
        return booktypename;
    }
    public void setBooktypename(String booktypename) {
        this.booktypename = stringUtil.codeToString(booktypename);
    }
}
