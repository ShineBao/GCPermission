package com.graycarbon.gcpermission;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.graycarbon.lib.permission.annotation.PermissionRequest;
import com.graycarbon.lib.permission.annotation.PermissionsCancel;
import com.graycarbon.lib.permission.annotation.PermissionsDenied;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
    }

    @PermissionRequest(Manifest.permission.ACCESS_COARSE_LOCATION)
    private void click() {
        Toast.makeText(this, "权限通过", Toast.LENGTH_LONG).show();
    }

    @PermissionsCancel
    private void cancel(String[] p) {
        Toast.makeText(this, "权限取消", Toast.LENGTH_SHORT).show();
    }

    @PermissionsDenied
    private void denied(String[] p) {
        Toast.makeText(this, "权限拒绝", Toast.LENGTH_SHORT).show();
    }
}
