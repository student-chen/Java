package action;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import form.dispBookInfoForm;
import bean.db.bookOPBean;
import bean.db.common.dataPage;
/**
 * @author 邓子云
 * 显示书藉信息的action
 */
public class dispBookInfoAction extends Action{
    /**
     * 在此方法中处理HTTP请求数据，并作响应
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        bookOPBean bookOP=new bookOPBean();
        //------得到记录集------
        String bookName=((dispBookInfoForm)form).getBookname();      
        ArrayList booksArray=bookOP.selectBook(bookName);
        //------得到当前页码------
        String currentPageStr=((dispBookInfoForm)form).getPage();
        int currentPageInt=0;
        try{
            currentPageInt=Integer.parseInt(currentPageStr);
        }catch(Exception e){
            e.printStackTrace();
            currentPageInt=0;
        }
        //------作分页处理------
        dataPage dataPageObject=new dataPage();
        dataPageObject.setCurrentPage(currentPageInt);
        dataPageObject.setDispartedArray(booksArray);
        dataPageObject.dataPageDispart();
        //------得到当前页的数据------
        ArrayList CurrentPageArray=dataPageObject.getCurrentPageArray();
        request.setAttribute("CurrentPageArray",CurrentPageArray);
        request.setAttribute("dataPageObject",dataPageObject);
        request.removeAttribute(mapping.getAttribute());//删除formBean
        return mapping.findForward("dispBooksInfo");  
    }
}