package omg.medved.whoshoutslouder;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by medvedomg on 05.05.16.
 */
public class Player implements Parcelable {

    public String getLOG_TAG_PLAYER() {
        return LOG_TAG_PLAYER;
    }

    private String mName = "Player";
    final String LOG_TAG_PLAYER = "tag";

    @Override
    public String toString() {
        return mName;
    }

    public Player() {

        Log.d(LOG_TAG_PLAYER, this.toString());
    }

    protected Player(Parcel in) {
        mName = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName.toString());
    }
}
