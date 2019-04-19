package bean.db;
/**
 * @author 邓子云
 * 封装user表的一条记录
 */
public class userBean {
    long user_id=0;
    String user_name=null;
    String user_true_name=null;
    String user_address=null;
    String user_telephone=null;
    String user_postalcode=null;
    String user_role=null;
    String user_password=null;
    
    public String getUser_address() {
        return user_address;
    }
    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
    public long getUser_id() {
        return user_id;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_password() {
        return user_password;
    }
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    public String getUser_postalcode() {
        return user_postalcode;
    }
    public void setUser_postalcode(String user_postalcode) {
        this.user_postalcode = user_postalcode;
    }
    public String getUser_role() {
        return user_role;
    }
    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }
    public String getUser_telephone() {
        return user_telephone;
    }
    public void setUser_telephone(String user_telephone) {
        this.user_telephone = user_telephone;
    }
    public String getUser_true_name() {
        return user_true_name;
    }
    public void setUser_true_name(String user_true_name) {
        this.user_true_name = user_true_name;
    }
}
