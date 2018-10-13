package tzl.com.awesomewanandroid.testExample.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;

import tzl.com.awesomewanandroid.R;
import tzl.com.awesomewanandroid.base.WBaseActivity;

public class ClientActivity extends WBaseActivity {

    private TextView mResult;

    @Override
    public int getLayoutId() {
        return R.layout.activity_client;
    }





    @Override
    public void initView() {
        mResult = findViewById(R.id.result);

        bindService(new Intent(this, RemoteService.class), mServiceConnection, BIND_AUTO_CREATE);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }

    public void addPerson(View view) {


        try {
            mRemoteServiceAidl.addPerson(new Person("tzl"));
            mResult.setText(mRemoteServiceAidl.getPersonList().toString());

        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }


    private RemoteServiceAidl mRemoteServiceAidl;



    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mRemoteServiceAidl = RemoteServiceAidl.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mRemoteServiceAidl = null;
        }
    };
}
