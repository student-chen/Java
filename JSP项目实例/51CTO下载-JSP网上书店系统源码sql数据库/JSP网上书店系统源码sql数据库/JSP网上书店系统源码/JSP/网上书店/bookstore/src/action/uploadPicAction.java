package action;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import bean.db.common.dbconn;
import form.uploadPicForm;
/**
 * @作者:邓子云
 * 录入一本新书,控制器类
 */
public class uploadPicAction extends Action{
    /**
     * 在此方法中处理HTTP请求数据，并作响应
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        //------得到上传的图片文件对象------
        FormFile file=((uploadPicForm)form).getFile();
        //------得到输入流------
        InputStream in=file.getInputStream();
        //------得到书藉ID号------
        int bookid=0;
        try{
            bookid=Integer.parseInt(request.getParameter("bookid"));
        }catch(Exception e){
            e.printStackTrace();
        }
        //------将图片存入数据库表的相应字段中------
        try{        
            String sqlStr="update book set book_image=? where book_id="+bookid;
            dbconn conn=new dbconn();
            Connection connObject=conn.getDBConn();
            PreparedStatement pstmt=connObject.prepareStatement(sqlStr);
            pstmt.setBinaryStream(1,in,in.available());
            pstmt.execute();
        }catch(Exception e1){
            e1.printStackTrace();
        }
        //------关闭输入流------
        in.close();
        request.removeAttribute(mapping.getAttribute());//删除formBean
        return mapping.findForward("success");  
    }
}
