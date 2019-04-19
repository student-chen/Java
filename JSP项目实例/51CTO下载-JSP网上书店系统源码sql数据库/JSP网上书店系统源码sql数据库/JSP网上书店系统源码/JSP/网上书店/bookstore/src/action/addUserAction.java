package action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import form.addUserForm;
import bean.db.userBean;
import bean.db.userOPBean;

/**
 * @作者:邓子云
 * 新注册一个用户,控制器类
 */
public class addUserAction extends Action{
    /**
     * 在此方法中处理HTTP请求数据，并作响应
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionErrors errors=new ActionErrors();
        userOPBean userOP=new userOPBean();
        userBean user=new userBean();
        //------得到用户对象------
        addUserForm userForm=(addUserForm)form;
        user.setUser_address(userForm.getUser_address());
        user.setUser_name(userForm.getUser_name());
        user.setUser_password(userForm.getUser_password());
        user.setUser_postalcode(userForm.getUser_postalcode());
        user.setUser_role(userForm.getUser_role());
        user.setUser_telephone(userForm.getUser_telephone());
        user.setUser_true_name(userForm.getUser_true_name());
        //------增加用户------
        int i=userOP.addUser(user);
        if(i!=1){
            errors.add("inserterror",new ActionMessage("user.insertError"));
            saveErrors(request,errors);
            return(new ActionForward(mapping.findForward("addusererror")));
        }
        request.removeAttribute(mapping.getAttribute());//删除formBean
        return mapping.findForward("addusersuccess");  
    }
}
