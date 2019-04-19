package action;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import form.dispBookTypeForm;
import bean.db.bookTypeOPBean;
import bean.db.common.dataPage;
/**
 * @author 邓子云
 * 显示书藉类型信息的action
 */
public class dispBookTypeAction extends Action{
    /**
     * 在此方法中处理HTTP请求数据，并作响应
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String bookTypeName=((dispBookTypeForm)form).getBooktypename();
        bookTypeOPBean bookTypeOP=new bookTypeOPBean();
        ActionErrors errors=new ActionErrors();
        //------如果需要新增书藉类型,则作新增处理------
        if(bookTypeName!=null&&bookTypeName.length()>0){
            int i=bookTypeOP.insertBookType(bookTypeName);
            if(i!=1){
                errors.add("updateerror",new ActionMessage("bookType.insertError"));
                saveErrors(request,errors);
                return(new ActionForward(mapping.findForward("booktypeview")));
            }else{
                request.removeAttribute(mapping.getAttribute());//删除formBean
                return mapping.findForward("success"); 
            }           
        }
        //------得到记录集------      
        ArrayList bookTypesArray=bookTypeOP.getBookTypeArray();
        //------得到当前页码------
        String currentPageStr=((dispBookTypeForm)form).getPage();
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
        dataPageObject.setDispartedArray(bookTypesArray);
        dataPageObject.dataPageDispart();
        //------得到当前页的数据------
        ArrayList CurrentPageArray=dataPageObject.getCurrentPageArray();
        request.setAttribute("CurrentPageArray",CurrentPageArray);
        request.setAttribute("dataPageObject",dataPageObject);
        request.removeAttribute(mapping.getAttribute());//删除formBean
        return mapping.findForward("booktypeview");  
    }
}