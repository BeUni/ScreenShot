package com.beuni.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.beuni.screenshot.CompressType;
import com.beuni.screenshot.Quality;
import com.beuni.screenshot.ScreenShot;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},00);

        Button btn = findViewById(R.id.btnScreenShot);
        final ConstraintLayout constraintLayout = findViewById(R.id.main_cons);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String address = new ScreenShot.Builder(getApplicationContext()).setQuality(Quality.HIGH)
                        .setView(constraintLayout)
                        .setPath(Environment.getExternalStorageDirectory()+"/testScreenShot")
                        .setFileCompressType(CompressType.JPEG)
                        .setFileNameWithExtension(System.currentTimeMillis()+".jpg")
                        .build().getScreenShotFileAddress();

                Log.e("Address Msg", address);
            }
        });


    }
}
