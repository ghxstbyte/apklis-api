package com.arr.apklistool;

import com.arr.apklistool.models.ApklisResponse;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApklisClient {

    @GET("application/{packageName}")
    Single<ApklisResponse> getAppInfo(@Path("packageName") String packageName);
}
