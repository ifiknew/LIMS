package businesslogic.loadbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.LoadDataService;
import dataservice.IdDataService;
import businesslogic.BusinessLogicUtil;
import businesslogic.userbl.LoginController;
import businesslogicservice.IdManager;

public class LoadIdManager implements IdManager{

    
    private IdDataService idDataService;
    private LoadDataService loadDataService;
    private final int ORDINAL_LENGTH = 6;
    
    public LoadIdManager() {
        try {
            idDataService = (IdDataService) Naming.lookup("rmi://localhost/IdData");
            loadDataService = (LoadDataService) Naming.lookup("rmi://localhost/LoadData");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };
    }
    
    @Override
    public String createNewId() {
        String tag = LoginController.getOrganizationId();
        String previousId = "";
        String id = "";
        String date = BusinessLogicUtil.getDate();
        try {
            previousId = idDataService.getLoadId(tag);
        } catch (RemoteException e) {
            e.printStackTrace();
        } 
        //�����ǰ��Id�������ڣ�ֱ�Ӵ���Id
        if(previousId == null || previousId.equals("")){
            id = tag+date+BusinessLogicUtil.formatByZero("0", ORDINAL_LENGTH);
        }else{
            String previousDate = previousId.substring(tag.length(), tag.length()+date.length());
           //�ж��Ƿ�Ϊͬһ��
            if(previousDate.equals(date)){
               String previousOrdinal = previousId.substring(tag.length()+date.length());
               int tempOrdinal = new Integer(previousOrdinal)+1;
               int divisor = (int) Math.pow(10, ORDINAL_LENGTH);
               for(int i=tempOrdinal%divisor;;i++){
                   id = tag+date+BusinessLogicUtil.formatByZero(""+i, ORDINAL_LENGTH);
                   try {
                       if(loadDataService.find(id) == null)
                           break;
                   } catch (RemoteException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                   }
               }
            }else{
                //�µ�һ�죬ֱ�Ӵ���Id
                id = tag+date+BusinessLogicUtil.formatByZero("0", ORDINAL_LENGTH);
            }
        }
        try {
            idDataService.updateLoadId(tag, id);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return id;
    }

}