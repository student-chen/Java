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
 * @author ������
 * ��ʾ�����Ϣ��action
 */
public class dispBookInfoAction extends Action{
    /**
     * �ڴ˷����д���HTTP�������ݣ�������Ӧ
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        bookOPBean bookOP=new bookOPBean();
        //------�õ���¼��------
        String bookName=((dispBookInfoForm)form).getBookname();      
        ArrayList booksArray=bookOP.selectBook(bookName);
        //------�õ���ǰҳ��------
        String currentPageStr=((dispBookInfoForm)form).getPage();
        int currentPageInt=0;
        try{
            currentPageInt=Integer.parseInt(currentPageStr);
        }catch(Exception e){
            e.printStackTrace();
            currentPageInt=0;
        }
        //------����ҳ����------
        dataPage dataPageObject=new dataPage();
        dataPageObject.setCurrentPage(currentPageInt);
        dataPageObject.setDispartedArray(booksArray);
        dataPageObject.dataPageDispart();
        //------�õ���ǰҳ������------
        ArrayList CurrentPageArray=dataPageObject.getCurrentPageArray();
        request.setAttribute("CurrentPageArray",CurrentPageArray);
        request.setAttribute("dataPageObject",dataPageObject);
        request.removeAttribute(mapping.getAttribute());//ɾ��formBean
        return mapping.findForward("dispBooksInfo");  
    }
}