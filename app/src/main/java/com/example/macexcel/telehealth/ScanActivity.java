package com.example.macexcel.telehealth;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.zxing.Result;

import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView mScannerView;
    private String personal_info;
    private static String dataString;

    static String lastname;
    static String firstname;
    static String gender;
    static String age;
    static String birthday;
    static String bloodtype;
    static String weight;
    static String height;
    static String temp;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // @TODO something with the result here
        // Log.v("tag", rawResult.getText()); // Prints scan results
        // Log.v("tag", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)
        dataString = rawResult.getText().toString();
        if (dataString.charAt(0) == '1') { // CAME FROM COMPUTER
            QR.tvresult.setText(dataString);
            personal_info = dataString.substring(2);
            temp = personal_info.substring(0, personal_info.indexOf(','));
            lastname = temp;
            personal_info = personal_info.substring(personal_info.indexOf(',')+1);
            temp = personal_info.substring(0, personal_info.indexOf(','));
            firstname = temp;

            personal_info = personal_info.substring(personal_info.indexOf(',')+1);
            if (personal_info.charAt(0) == 'M'){
                temp = "Male";
            }
            else if (personal_info.charAt(0) == 'F'){
                temp = "Female";
            }
            else{
                temp = "ERROR!";
            }
            gender = temp;
            personal_info = personal_info.substring(personal_info.indexOf(',')+1);
            temp = personal_info.substring(0, personal_info.indexOf(','));
            age = temp;
            personal_info = personal_info.substring(personal_info.indexOf(',')+1);
            temp = personal_info.substring(0,personal_info.indexOf(','));
            birthday = temp;
            personal_info = personal_info.substring(personal_info.indexOf(',')+1);
            temp = personal_info.substring(0, personal_info.indexOf(','));
            bloodtype = temp;
            personal_info = personal_info.substring(personal_info.indexOf(',')+1);
            temp = personal_info.substring(0, personal_info.indexOf(','));
            weight = temp;
            personal_info = personal_info.substring(personal_info.indexOf(',')+1);
            temp = personal_info.substring(0);
            height = temp;

            QR.datatext.setText("Patient Name: " + lastname + ", " + firstname + "\nGender: " + gender + "\nAge: " + age + "\nBirthday: " + birthday + "\nBlood Type: " + bloodtype + "\nWeight: " + weight + "\nHeight: " + height);

//                    Tab1_PatientInfo.patientname.setText(lastname + "," +firstname);
//                    Tab1_PatientInfo.gender.setText(gender);
//                    Tab1_PatientInfo.age.setText(age);
//                    Tab1_PatientInfo.birthday.setText(birthday);
//                    Tab1_PatientInfo.bloodtype.setText(bloodtype);
//                    Tab1_PatientInfo.weight.setText(weight);
//                    Tab1_PatientInfo.height.setText(height);
                    onBackPressed();

        }
        else if (dataString.charAt(0) == '0') { // CAME FROM PHONE
            QR.tvresult.setText("Error! Unable to Read From Another Device!");
            //Snackbar.make(findViewById(R.id.constraintLayout), "Unable to Read From Another Device", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            onBackPressed();
        }
        else {
            QR.tvresult.setText("Error! Wrong QR Format"); // URL
            //Snackbar.make(findViewById(R.id.constraintLayout), "Wrong QR Format", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            onBackPressed();
        }
        onBackPressed();

        // If you would like to resume scanning, call this method below:
        //mScannerView.resumeCameraPreview(this);
    }
}