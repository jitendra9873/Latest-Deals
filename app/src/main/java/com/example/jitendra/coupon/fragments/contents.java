package com.example.jitendra.coupon.fragments;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jitendra on 20/4/17.
 */

public class contents implements Parcelable {
    public static final Parcelable.Creator<contents> CREATOR =
            new Parcelable.Creator<contents>() {

                @Override
                public contents createFromParcel(Parcel source) {
                    return new contents(source);
                }

                @Override
                public contents[] newArray(int size) {
                    return new contents[size];
                }

            };
    private String name;
    private String desc;
    private String code;
    private int thumbnail;
    private String link;

    public contents() {
    }

    public contents(String name, String desc, String code, int thumbnail, String link) {
        this.name = name;
        this.desc = desc;
        this.thumbnail = thumbnail;
        this.code = code;
        this.link = link;

    }

    private contents(Parcel in) {
        name = in.readString();
        desc = in.readString();
        thumbnail = in.readInt();
        code = in.readString();
        link = in.readString();

    }

    // Getters and setters

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeInt(thumbnail);
        dest.writeString(code);
        dest.writeString(link);


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

/*

*/
/*
package com.example.jitendra.coupon.fragments;

import android.os.Parcel;
import android.os.Parcelable;

*/
/**
 * Created by jitendra on 20/4/17.
 *//*


public class contents implements Parcelable {
    private String name;
    private String desc;
    private String code;
    private int thumbnail;
    private String link;

    public contents() {
    }
    public contents(String name,String desc,String code,int thumbnail,String link){
        this.name=name;
        this.desc=desc;
        this.thumbnail=thumbnail;
        this.code=code;
        this.link=link;

    }
    private contents(Parcel in) {
        name = in.readString();
        desc = in.readString();
        thumbnail = in.readInt();
        code = in.readString();
        link = in.readString();

    }

    public static final Parcelable.Creator<contents> CREATOR =
            new Parcelable.Creator<contents>() {

                @Override
                public contents createFromParcel(Parcel source) {
                    return new contents(source);
                }

                @Override
                public contents[] newArray(int size) {
                    return new contents[size];
                }

            };

    // Getters and setters

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeInt(thumbnail);
        dest.writeString(code);
        dest.writeString(link);


    }


    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getLink() {
        return link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
*//*

 */
