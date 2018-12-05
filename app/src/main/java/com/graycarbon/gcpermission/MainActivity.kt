package com.graycarbon.gcpermission

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.graycarbon.lib.permission.annotation.PermissionRequest
import com.graycarbon.lib.permission.annotation.PermissionsCancel
import com.graycarbon.lib.permission.annotation.PermissionsDenied
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Create by GrayCarbon on 2018.12.5
 *
 * desc : 测试单权限申请
 */
class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermission.setOnClickListener { permissionRequest() }
        requestPermission1.setOnClickListener { permissionRequest1() }
        skip.setOnClickListener { skip() }
    }

    @PermissionRequest(Manifest.permission.CALL_PHONE)
    private fun permissionRequest() {
        Toast.makeText(this, "拨打电话权限通过", Toast.LENGTH_LONG).show()
    }

    @PermissionRequest(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private fun permissionRequest1() {
        Toast.makeText(this, "访问存储权限通过", Toast.LENGTH_LONG).show()
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
