package form;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import bean.db.bookTypeOPBean;
import bean.db.common.stringUtil;
/**
 * @作者:邓子云
 * 录入书藉分类表单类
 */
public class dispBookTypeForm extends ActionForm{
    private String page=new String("1");
    private String booktypename=new String("");
    /**
     * 重置所有属性的值
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        page=new String("1");
        booktypename=new String("");
    }
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors=new ActionErrors();
        //------书藉类型名校验------
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
