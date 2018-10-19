package bbc.com.client.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;


/**
 * 权限申请
 * Created by Slingge on 2017/5/3 0003.
 */

public class PermissionUtil {


    /**
     * 读写内存卡及拍照
     * int result PermissionsResult返回标示符
     */
    public static boolean ApplyPermissionAlbum(Activity context, int result) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
                    , Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.RECORD_AUDIO}, result);
            return false;
        } else {
            return true;
        }
    }

    /**
     * 拍照
     * int result PermissionsResult返回标示符
     */
    public static boolean CameraAlbum(Activity context, int result) {

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.CAMERA,Manifest.permission.RECORD_AUDIO}, result);
            return false;
        } else {
            return true;
        }
    }


    /**
     * 定位
     * int result PermissionsResult返回标示符
     */
    public static boolean LocationPermissionAlbum(Activity context, int result) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_PHONE_STATE
            }, result);
            return false;
        } else {
            return true;
        }

    }

    /**
     * 获取手机状态
     */
    public static boolean PhoneStatePermissionAlbum(Activity context, int result) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.READ_PHONE_STATE}, result);
            return false;
        } else {
            return true;
        }
    }


    /**
     * 跳转选择图片
     * Activity context
     * int num 选择图片最大数量
     * int result onActivityResult 标示符
     * boolean isCamera 是否使用相机
     */
   /* public static void toPhotoPicker(Activity context, int num, int result, boolean isCamera) {
        PhotoPickerIntent intent = new PhotoPickerIntent(context);
        intent.setPhotoCount(num);
        intent.setShowCamera(isCamera);
        context.startActivityForResult(intent, result);
    }*/


    /**
     * 申请权限结果回调
     */
 /*   @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && requestCode == 0) {//询问结果
            image.setVisibility(View.INVISIBLE);
            gridView.setVisibility(View.VISIBLE);
            PermissionUtil.toPhotoPicker(this, 12, 303, true);
        } else {//禁止使用权限，询问是否设置允许
            new PermissionsDialog().dialog(this, "需要访问内存卡和拍照权限");
        }
    }*/


}
