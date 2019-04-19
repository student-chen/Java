package form;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import bean.db.userOPBean;
import bean.db.common.stringUtil;
/**
 * @����:������
 * �û���¼����
 */
public class userLoginForm extends ActionForm{
    String user_name=null;
    String user_password=null;
    String certCode=null;
    /**
     * �����������Ե�ֵ
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        user_name=null;
        certCode=null;
        user_password=null;
    }
    /**
     * ��֤���Ե�ֵ
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors=new ActionErrors();
        //------�û���У��------
        if(user_name==null||user_name.trim().length()<1)
            errors.add("username",new ActionMessage("user.userNameNull"));
        //------�û�����У��------
        if(user_password==null||user_password.trim().length()<1)
            errors.add("user_password",new ActionMessage("user.userPasswordNull"));
        //------��֤�����------
        if(!certCode.equals((String)(request.getSession().getAttribute("certCode"))))
            errors.add("certCodeError",new ActionMessage("user.certCodeError"));
        //------�����ݿ��м���------
        userOPBean userOP=new userOPBean();
        long user_id=0;
        if((user_id=userOP.certUser(user_name,user_password))==0)
            errors.add("userError",new ActionMessage("user.userError"));
        //------�����֤ͨ��,���û�ID���û���д��session------
        if(errors.size()==0){
            request.getSession().setAttribute("user_id",new Long(user_id));
            request.getSession().setAttribute("user_name",user_name);
        }
        return errors;
    }
    public String getCertCode() {
        return certCode;
    }
    public void setCertCode(String certCode) {
        this.certCode = stringUtil.codeToString(certCode);
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
}