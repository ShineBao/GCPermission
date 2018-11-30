package com.graycarbon.gcpermission

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.graycarbon.lib.permission.annotation.PermissionRequest
import com.graycarbon.lib.permission.annotation.PermissionsCancel
import com.graycarbon.lib.permission.annotation.PermissionsDenied
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermission.setOnClickListener { permissionRequest() }
        skip.setOnClickListener { skip() }
    }

    @PermissionRequest(Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private fun permissionRequest() {
        Toast.makeText(this, "权限通过", Toast.LENGTH_LONG).show()
        val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"/test/ertyu")
        val flag = file.mkdirs()
        Log.i("xiaoming","$flag")
    }

    @PermissionsCancel
    private fun permissionCancel(permissions: Array<String>) {
        Toast.makeText(this, "权限被取消", Toast.LENGTH_LONG).show()
        for (permission in permissions)
            Log.i(TAG, "被取消的权限：$permission")
    }

    @PermissionsDenied
    private fun permissionDenied(permissions: Array<String>) {
        Toast.makeText(this, "权限被拒绝", Toast.LENGTH_LONG).show()
        for (permission in permissions)
            Log.i(TAG, "被拒绝的权限：$permission")
    }

    private fun skip() {
        startActivity(Intent(this, Main2Activity::class.java))
    }
}
