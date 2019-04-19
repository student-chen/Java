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
 * @����:������
 * ¼��һ������,��������
 */
public class uploadPicAction extends Action{
    /**
     * �ڴ˷����д���HTTP�������ݣ�������Ӧ
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        //------�õ��ϴ���ͼƬ�ļ�����------
        FormFile file=((uploadPicForm)form).getFile();
        //------�õ�������------
        InputStream in=file.getInputStream();
        //------�õ����ID��------
        int bookid=0;
        try{
            bookid=Integer.parseInt(request.getParameter("bookid"));
        }catch(Exception e){
            e.printStackTrace();
        }
        //------��ͼƬ�������ݿ�����Ӧ�ֶ���------
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
        //------�ر�������------
        in.close();
        request.removeAttribute(mapping.getAttribute());//ɾ��formBean
        return mapping.findForward("success");  
    }
}
