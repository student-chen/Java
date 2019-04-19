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
public class addUserForm extends ActionForm{
    String user_name=null;//用户名
    String user_true_name=null;//用户真实姓名
    String user_address=null;//用户住址
    String user_telephone=null;//联系电话
    String user_postalcode=null;//邮政编码
    String user_role=null;//用户角色
    String user_password=null;//用户密码
    String re_user_password=null;//再一次输入的用户密码
    /**
     * 重置所有属性的值
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        user_name=null;
        user_true_name=null;
        user_address=null;
        user_telephone=null;
        user_postalcode=null;
        user_role=null;
        user_password=null;
        re_user_password=null;
    }
    /**
     * 验证属性的值
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors=new ActionErrors();
        //------用户名校验------
        if(user_name==null||user_name.trim().length()<1)
            errors.add("username",new ActionMessage("user.userNameNull"));
        //------用户密码校验------
        if(user_password==null||user_password.trim().length()<1)
            errors.add("user_password",new ActionMessage("user.userPasswordNull"));
        //------两次输入的密码是否一致------
        if(!user_password.equals(re_user_password))
            errors.add("passwordNotEqual",new ActionMessage("user.passwordNotEqual"));
        return errors;
    }
    public String getUser_address() {
        return user_address;
    }
    public void setUser_address(String user_address) {
        this.user_address = stringUtil.codeToString(user_address);
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = stringUtil.codeToString(user_name);
    }
    public String getUser_password() {
        return user_password;
    }
    public void setUser_password(String user_password) {
        this.user_password = stringUtil.codeToString(user_password);
    }
    public String getUser_postalcode() {
        return user_postalcode;
    }
    public void setUser_postalcode(String user_postalcode) {
        this.user_postalcode = stringUtil.codeToString(user_postalcode);
    }
    public String getUser_role() {
        return user_role;
    }
    public void setUser_role(String user_role) {
        this.user_role = stringUtil.codeToString(user_role);
    }
    public String getUser_telephone() {
        return user_telephone;
    }
    public void setUser_telephone(String user_telephone) {
        this.user_telephone = stringUtil.codeToString(user_telephone);
    }
    public String getUser_true_name() {
        return user_true_name;
    }
    public void setUser_true_name(String user_true_name) {
        this.user_true_name = stringUtil.codeToString(user_true_name);
    }
    public String getRe_user_password() {
        return re_user_password;
    }
    public void setRe_user_password(String re_user_password) {
        this.re_user_password = stringUtil.codeToString(re_user_password);
    }
}