package form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;
/**
 * @author ������
 * �ļ��ϴ���Form��
 */
public class uploadPicForm  extends ActionForm{
    private FormFile file;
   
    public FormFile getFile() {
        return file;
    }
    public void setFile(FormFile file) {
        this.file = file;
    }
}
