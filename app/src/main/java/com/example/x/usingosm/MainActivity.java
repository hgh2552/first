package com.example.x.usingosm;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_PERMISSION_PHONE_STATE=1;
    private final int REQUEST_PERMISSION_ACCESS_FINE_LOCATION=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showPhoneStatePermission1();
        Toast.makeText(MainActivity.this, "method 1", Toast.LENGTH_SHORT).show();
        showPhoneStatePermission();
        Toast.makeText(MainActivity.this, "method 2", Toast.LENGTH_SHORT).show();


//        ActivityCompat.requestPermissions(MainActivity.this,
//                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                1);


        // Here, thisActivity is the current activity
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.READ_CONTACTS)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            // Permission is not granted
//            // Should we show an explanation?
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.READ_CONTACTS)) {
//                // Show an explanation to the user *asynchronously* -- don't block
//                // this thread waiting for the user's response! After the user
//                // sees the explanation, try again to request the permission.
//            } else {
//                // No explanation needed; request the permission
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.READ_CONTACTS},
//                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
//
//                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
//                // app-defined int constant. The callback method gets the
//                // result of the request.
//            }
//        } else {
//            // Permission has already been granted
//        }


//        int MyVersion = Build.VERSION.SDK_INT;
//        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
//
//
//            if (!checkIfAlreadyhavePermission()) {
//                Toast.makeText(MainActivity.this, "in if oncreate", Toast.LENGTH_SHORT).show();
//                requestForSpecificPermission();
//            }
//        }


    }

    private void showPhoneStatePermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_PHONE_STATE);

//        int permissionCheck1 = ContextCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED ) {


//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.ACCESS_FINE_LOCATION)) {
//                Toast.makeText(MainActivity.this, " in if 2!", Toast.LENGTH_SHORT).show();
//                showExplanation("مجوز دسترسی", "برنامه نیاز دارد به موقعیت شما دسترسی داشته باشد", Manifest.permission.ACCESS_FINE_LOCATION,REQUEST_PERMISSION_ACCESS_FINE_LOCATION);
//            } else {
//                requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_PERMISSION_ACCESS_FINE_LOCATION);
//            }



            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_PHONE_STATE)) {
                showExplanation("مجوز دسترسی", "برنامه نیاز دارد به مخاطبین شما دسترسی داشته باشد", Manifest.permission.READ_PHONE_STATE, REQUEST_PERMISSION_PHONE_STATE);
            } else {
                requestPermission(Manifest.permission.READ_PHONE_STATE, REQUEST_PERMISSION_PHONE_STATE);
            }



//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.ACCESS_FINE_LOCATION)) {
//                showExplanation("مجوز دسترسی", "برنامه نیاز دارد به موقعیت شما دسترسی داشته باشد", Manifest.permission.ACCESS_FINE_LOCATION,REQUEST_PERMISSION_ACCESS_FINE_LOCATION);
//            } else {
//                requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_PERMISSION_ACCESS_FINE_LOCATION);
//            }

        } else {
            Toast.makeText(MainActivity.this, "Permission (already) Granted!", Toast.LENGTH_SHORT).show();
        }



//        if (permissionCheck1 != PackageManager.PERMISSION_GRANTED) {
//
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.ACCESS_FINE_LOCATION)) {
//                showExplanation("مجوز دسترسی", "برنامه نیاز دارد به موقعیت شما دسترسی داشته باشد", Manifest.permission.ACCESS_FINE_LOCATION,REQUEST_PERMISSION_ACCESS_FINE_LOCATION);
//            } else {
//                requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_PERMISSION_ACCESS_FINE_LOCATION);
//            }
//
//        } else {
//            Toast.makeText(MainActivity.this, "Permission (already) Granted!", Toast.LENGTH_SHORT).show();
//        }
    }


    private void showPhoneStatePermission1() {


        int permissionCheck1 = ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION);

        if ( permissionCheck1 != PackageManager.PERMISSION_GRANTED) {


            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(MainActivity.this, " in if 2!", Toast.LENGTH_SHORT).show();
                showExplanation("مجوز دسترسی", "برنامه نیاز دارد به موقعیت شما دسترسی داشته باشد", Manifest.permission.ACCESS_FINE_LOCATION,REQUEST_PERMISSION_ACCESS_FINE_LOCATION);
            } else {
                requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_PERMISSION_ACCESS_FINE_LOCATION);
            }

        } else {
            Toast.makeText(MainActivity.this, "Permission (already) Granted!", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            String permissions[],
            int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_PHONE_STATE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Permission Granted!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Permission Denied!", Toast.LENGTH_SHORT).show();
                }
            case REQUEST_PERMISSION_ACCESS_FINE_LOCATION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Permission Granted!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Permission Denied!", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void showExplanation(String title,
                                 String message,
                                 final String permission,
                                 final int permissionRequestCode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("باشه", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        requestPermission(permission, permissionRequestCode);
                    }
                });
        builder.create().show();
    }

    private void requestPermission(String permissionName, int permissionRequestCode) {
        ActivityCompat.requestPermissions(this,
                new String[]{permissionName}, permissionRequestCode);
    }


    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }


    private void requestForSpecificPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
    }





//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           String permissions[], int[] grantResults) {
////        switch (requestCode) {
////            case 1: {
////
////                // If request is cancelled, the result arrays are empty.
////                if (grantResults.length > 0
////                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
////
////                    // permission was granted, yay! Do the
////                    // contacts-related task you need to do.
////                } else {
////
////                    // permission denied, boo! Disable the
////                    // functionality that depends on this permission.
////                    Toast.makeText(MainActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
////                }
////                return;
////            }
////
////        }
//
//
//        switch (requestCode) {
//            case 101:
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    //granted
//                    Toast.makeText(MainActivity.this, "granted", Toast.LENGTH_SHORT).show();
//                } else {
//                    //not granted
//                    Toast.makeText(MainActivity.this, "not granted", Toast.LENGTH_SHORT).show();
//
//                }
//                break;
//            default:
//                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        }
//    }
}




