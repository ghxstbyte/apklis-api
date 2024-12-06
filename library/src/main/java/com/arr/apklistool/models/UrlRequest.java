package com.arr.apklistool.models;
import androidx.annotation.Keep;

@Keep
public class UrlRequest {

    private String release;

    public UrlRequest(String release) {
        this.release = release;
    }
}
