package tzl.com.awesomewanandroid.testExample.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * author: tangzenglei
 * created on: 2018/10/15 下午5:08
 * description:
 */
public interface IRemoteService extends IInterface {




    void addPerson(Person person) throws RemoteException;

    List<Person> getPersonList() throws RemoteException;


    /**
     * 让服务端自定义用户操作
     */
    abstract class Stub extends Binder implements IRemoteService{


      public static final int TRANSACTION_addPerson     = IBinder.FIRST_CALL_TRANSACTION + 1;
      public static final int TRANSACTION_getPersonList = IBinder.FIRST_CALL_TRANSACTION + 2;
      private static final String DESCRIPTOR          = "tzl.com.awesomewanandroid.testExample.aidl.IRemoteService";


        public Stub() {
            this.attachInterface(this,DESCRIPTOR);
        }


        public static IRemoteService asInterface(IBinder binder) {


            if (null == binder) {
                return null;
            }

            IInterface iin = binder.queryLocalInterface(DESCRIPTOR);

            if ((null!=iin)&&(iin instanceof IInterface)) {
                return (IRemoteService) iin;
            }

            return new Proxy(binder);

        }






        /**
         * 处理客户端请求
         * @param code
         * @param data
         * @param reply
         * @param flags
         * @return
         * @throws RemoteException
         */
        @Override
        protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {

            switch (code) {
                case FIRST_CALL_TRANSACTION:{
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_addPerson: {
                    data.enforceInterface(DESCRIPTOR);
                    Person _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = Person.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.addPerson(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getPersonList: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<Person> _result = this.getPersonList();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
            }

            return super.onTransact(code, data, reply, flags);
        }





        @Override
        public IBinder asBinder() {
            return this;
        }






       private static class Proxy  implements IRemoteService{


            private IBinder mRemote;


           public Proxy(IBinder remote) {
               mRemote = remote;
           }


           @Override
           public IBinder asBinder() {
               return mRemote;
           }

           @Override
            public void addPerson(Person person) throws RemoteException {

                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

               try {

                   _data.writeInterfaceToken(DESCRIPTOR);
                   if (null!=person) {
                       _data.writeInt(1);
                       person.writeToParcel(_data,0);
                   }else{
                       _data.writeInt(0);
                   }
                   mRemote.transact(Stub.TRANSACTION_addPerson,_data,_reply,0);
                   _reply.readException();

               }finally {
                   _data.recycle();
                   _reply.recycle();
               }



            }

            @Override
            public List<Person> getPersonList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                java.util.List<Person> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(RemoteServiceAidl.Stub.TRANSACTION_getPersonList, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(Person.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }


        }



    }





}
