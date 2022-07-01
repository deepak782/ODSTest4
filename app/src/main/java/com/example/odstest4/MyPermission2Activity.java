
package com.example.odstest4;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

public class MyPermission2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_permission2);
    }

    public void single(View view) {
        Dexter.withContext(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {
                        Toast.makeText(MyPermission2Activity.this, "Granted  "+response.getPermissionName(), Toast.LENGTH_SHORT).show();
                    }
                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {/* ... */
                        Toast.makeText(MyPermission2Activity.this, "Denied  "+response.getPermissionName(), Toast.LENGTH_SHORT).show();

                    }
                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {/* ... */
                    token.continuePermissionRequest();
                    Toast.makeText(MyPermission2Activity.this, "Rationale permissions  "+permission.getName(), Toast.LENGTH_SHORT).show();
                    }
                }).check();
    }

    public void multiple(View view) {

        Dexter.withContext(this)
                .withPermissions(
                        Manifest.permission.READ_CALL_LOG,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                ).withListener(new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */
            report.areAllPermissionsGranted();
            }
            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */
                token.continuePermissionRequest();
                Toast.makeText(MyPermission2Activity.this, "Rationale permissions  "+permissions.get(0), Toast.LENGTH_SHORT).show();
            }
        }).check();
    }
}