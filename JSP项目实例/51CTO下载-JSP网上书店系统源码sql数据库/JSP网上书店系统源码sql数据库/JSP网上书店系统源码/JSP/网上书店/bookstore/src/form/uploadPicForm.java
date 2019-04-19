package form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;
/**
 * @author 邓子云
 * 文件上传的Form类
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
