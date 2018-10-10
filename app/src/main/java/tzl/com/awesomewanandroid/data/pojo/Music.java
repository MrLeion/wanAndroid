package tzl.com.awesomewanandroid.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author: tangzenglei
 * created on: 2018/10/10 下午5:22
 * description:
 */
public class Music implements Parcelable {

    protected Music(Parcel in) {
    }

    public static final Creator<Music> CREATOR = new Creator<Music>() {
        @Override
        public Music createFromParcel(Parcel in) {
            return new Music(in);
        }

        @Override
        public Music[] newArray(int size) {
            return new Music[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;


    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
