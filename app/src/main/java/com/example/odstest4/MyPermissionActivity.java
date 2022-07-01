package com.example.odstest4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MyPermissionActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 101;
    public static final int All_REQUEST_CODE=201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_permission);
    }

    public void multiple(View view) {

        if(ContextCompat.checkSelfPermission(MyPermissionActivity.this, Manifest.permission.READ_CALL_LOG)+
                ContextCompat.checkSelfPermission(MyPermissionActivity.this, Manifest.permission.READ_CONTACTS)+
                ContextCompat.checkSelfPermission(MyPermissionActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MyPermissionActivity.this,new String[]{Manifest.permission.READ_CALL_LOG,Manifest.permission.READ_CONTACTS,Manifest.permission.READ_EXTERNAL_STORAGE},All_REQUEST_CODE);
        }
        else
        {

            multiMethod();
        }
    }

    private void multiMethod() {

        Toast.makeText(this, "Open Multiple Apps", Toast.LENGTH_SHORT).show();

    }

    public void single(View view) {

        if(ContextCompat.checkSelfPermission(MyPermissionActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MyPermissionActivity.this,new String[]{Manifest.permission.CAMERA},CAMERA_REQUEST_CODE);
        }
        else
        {

            openCamera();
        }
    }

    private void openCamera() {

        Toast.makeText(this, "Open Camera", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case CAMERA_REQUEST_CODE:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    openCamera();

                }
                else
                {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
                break;

            case All_REQUEST_CODE:
                if(grantResults.length>0&&grantResults[0]+grantResults[1]+grantResults[2]==PackageManager.PERMISSION_GRANTED)
                {
                    multiMethod();
                }
                else
                {
                    Toast.makeText(this, "Multiple Permission Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}