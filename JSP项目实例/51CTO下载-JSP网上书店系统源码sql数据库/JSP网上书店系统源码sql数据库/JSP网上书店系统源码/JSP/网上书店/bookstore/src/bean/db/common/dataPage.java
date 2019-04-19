package bean.db.common;
import java.util.ArrayList;
/**
 * @author 邓子云
 * 数据分页处理的类,使用时,必须设置dispartedArray、currentPage
 */
public class dataPage {
    ArrayList dispartedArray=new ArrayList();//要分页处理的记录集
    int pageRecordCount=10;//每页记录数
    int currentPage=1;//当前页码
    int pageCount=0;//总页数
    //------作分页处理------
    public void dataPageDispart() {
       if(dispartedArray.size()==0) return;
       if(dispartedArray.size()%pageRecordCount==0){
           pageCount=dispartedArray.size()/pageRecordCount;
       }else{
           pageCount=(int)(dispartedArray.size()/pageRecordCount)+1;
       }
    }
    //------得到所需页码的数据------
    public ArrayList getCurrentPageArray(){
        int startPosition=(currentPage-1)*pageRecordCount;
        int endPosition=currentPage*pageRecordCount-1;
        ArrayList currentPageArray=new ArrayList();
        for(int i=startPosition,j=0;i<=endPosition&&i<dispartedArray.size();i++,j++){
            currentPageArray.add(j,dispartedArray.get(i));
        }
        return currentPageArray;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public ArrayList getDispartedArray() {
        return dispartedArray;
    }
    public void setDispartedArray(ArrayList dispartedArray) {
        this.dispartedArray = dispartedArray;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public int getPageRecordCount() {
        return pageRecordCount;
    }
    public void setPageRecordCount(int pageRecordCount) {
        this.pageRecordCount = pageRecordCount;
    }
}
