package tzl.com.awesomewanandroid.testExample.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

public class RemoteService extends Service {


    public RemoteService() {


    }


    private List<Person> mPersons = new ArrayList<>();


    private IBinder mBinder =  new RemoteServiceAidl.Stub(){

        @Override
        public void addPerson(Person person) throws RemoteException {
            mPersons.add(person);
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return mPersons;
        }
    };




    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
