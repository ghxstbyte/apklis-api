package com.arr.apklisexample;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.arr.apklisexample.databinding.ActivityMainBinding;
import com.arr.apklistool.ApklisTool;
import com.arr.apklistool.callback.UpdateCallback;
import com.arr.apklistool.models.LastRelease;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // set content view to binding's root
        setContentView(binding.getRoot());

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
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}
