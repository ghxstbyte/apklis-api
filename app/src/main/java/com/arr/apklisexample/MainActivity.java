package com.arr.apklisexample;

import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.arr.apklisexample.databinding.ActivityMainBinding;
import com.arr.apklistool.ApklisClient;
import com.arr.apklistool.ApklisRetrofit;
import com.arr.apklistool.ApklisTool;
import com.arr.apklistool.callback.UpdateCallback;
import com.arr.apklistool.models.LastRelease;
import com.arr.apklistool.models.UrlRequest;
import com.arr.apklistool.models.UrlResponse;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    ApklisClient apiClient;
    private String urlString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // set content view to binding's root
        setContentView(binding.getRoot());

        apiClient = ApklisRetrofit.auth();

        ApklisTool api = new ApklisTool.Builder().build();
        api.hasUpdate(
                this,
                new UpdateCallback() {
                    @Override
                    public void lastRelease(LastRelease response) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Versión: ").append(response.versionName);
                        sb.append("Cambios: ").append(response.changelog);

                        new MaterialAlertDialogBuilder(MainActivity.this)
                                .setTitle("Actualización")
                                .setMessage(sb.toString())
                                .setPositiveButton("Ok", null)
                                .show();

                        setUrl(response.sha);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        binding.textUrl.setText(urlString);
    }

    private void setUrl(String sha) {
        UrlRequest body = new UrlRequest(sha);
        Single<UrlResponse> url = apiClient.getUrl(body);
        url.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        resp -> {
                            urlString = resp.url;
                            Log.e("Link", resp.url + " " + urlString);
                        },
                        error -> {
                            //
                        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}
