package com.arr.apklistool.models;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
public class ApklisResponse {

    @SerializedName("last_release")
    public LastRelease lastRelease;
}
