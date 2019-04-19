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
 * @����:������
 * ��ע��һ���û�,��������
 */
public class addUserAction extends Action{
    /**
     * �ڴ˷����д���HTTP�������ݣ�������Ӧ
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionErrors errors=new ActionErrors();
        userOPBean userOP=new userOPBean();
        userBean user=new userBean();
        //------�õ��û�����------
        addUserForm userForm=(addUserForm)form;
        user.setUser_address(userForm.getUser_address());
        user.setUser_name(userForm.getUser_name());
        user.setUser_password(userForm.getUser_password());
        user.setUser_postalcode(userForm.getUser_postalcode());
        user.setUser_role(userForm.getUser_role());
        user.setUser_telephone(userForm.getUser_telephone());
        user.setUser_true_name(userForm.getUser_true_name());
        //------�����û�------
        int i=userOP.addUser(user);
        if(i!=1){
            errors.add("inserterror",new ActionMessage("user.insertError"));
            saveErrors(request,errors);
            return(new ActionForward(mapping.findForward("addusererror")));
        }
        request.removeAttribute(mapping.getAttribute());//ɾ��formBean
        return mapping.findForward("addusersuccess");  
    }
}
