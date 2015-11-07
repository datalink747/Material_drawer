package material_design.soussi.com.material_drawer.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Soussi on 06/11/2015.
 */
public class Events implements Parcelable{

    private String text;
    private String imageUrl;

    protected Events(Parcel in) {
        text = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Events> CREATOR = new Creator<Events>() {
        @Override
        public Events createFromParcel(Parcel in) {
            return new Events(in);
        }

        @Override
        public Events[] newArray(int size) {
            return new Events[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(imageUrl);
    }

    // getter and setter here


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    //constructeur here


    public Events() {
    }

    public Events(String text, String imageUrl) {
        this.text = text;
        this.imageUrl = imageUrl;
    }
}
