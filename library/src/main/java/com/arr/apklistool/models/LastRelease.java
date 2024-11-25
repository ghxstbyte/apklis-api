package com.arr.apklistool.models;

import com.google.gson.annotations.SerializedName;

public class LastRelease {
    
    @SerializedName("version_name")
    public String versionName;

    @SerializedName("version_code")
    public int versionCode;

    @SerializedName("app_name")
    public String appName;

    @SerializedName("changelog")
    public String changelog;

    @SerializedName("size")
    public int size;

    @SerializedName("sha256")
    public String sha;
}
