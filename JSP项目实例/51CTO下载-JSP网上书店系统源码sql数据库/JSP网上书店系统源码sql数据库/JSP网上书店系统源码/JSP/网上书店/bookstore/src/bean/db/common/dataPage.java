package bean.db.common;
import java.util.ArrayList;
/**
 * @author ������
 * ���ݷ�ҳ�������,ʹ��ʱ,��������dispartedArray��currentPage
 */
public class dataPage {
    ArrayList dispartedArray=new ArrayList();//Ҫ��ҳ����ļ�¼��
    int pageRecordCount=10;//ÿҳ��¼��
    int currentPage=1;//��ǰҳ��
    int pageCount=0;//��ҳ��
    //------����ҳ����------
    public void dataPageDispart() {
       if(dispartedArray.size()==0) return;
       if(dispartedArray.size()%pageRecordCount==0){
           pageCount=dispartedArray.size()/pageRecordCount;
       }else{
           pageCount=(int)(dispartedArray.size()/pageRecordCount)+1;
       }
    }
    //------�õ�����ҳ�������------
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
