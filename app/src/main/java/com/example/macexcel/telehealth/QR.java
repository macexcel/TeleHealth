package com.example.macexcel.telehealth;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;




public class QR extends AppCompatActivity {

    public final static int QRcodeWidth = 500 ;
    private static final String IMAGE_DIRECTORY = "/QRcodeDemonuts";
    Bitmap bitmap ;
    String etqr = "lerit luis jose,M,22,12/25/95,B-,55,65";
    private ImageView iv;
    private Button Generate;
    private Button Scan;


    String temp_allergies = "", temp_reaction;
    public static TextView tvresult;
    public static TextView datatext;

    String S_Patient_Name;
    char S_Gender;
    String S_Age;
    String S_Birthday;
    String S_Blood_Type;
    String S_Weight;
    String S_Height;
    int data=12;



    //@TODO
    // SUMMARIZE ALL DATA VARIABLES IN AN ARRAY


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        Utility coder = new Utility();



    LayoutInflater factory = getLayoutInflater();
    View PatientInfo = factory.inflate(R.layout.tab1_patientinfo, null);
    TextView T_Patient_Name = (TextView) PatientInfo.findViewById(R.id.in_patient);
    String S_Patient_Name = T_Patient_Name.getText().toString();

    TextView T_Gender = (TextView) PatientInfo.findViewById(R.id.in_gender);
    char S_Gender = T_Patient_Name.getText().toString().charAt(0);

    TextView T_Age = (TextView) PatientInfo.findViewById(R.id.in_age);
    String S_Age = T_Patient_Name.getText().toString();

    TextView T_Birthday= (TextView) PatientInfo.findViewById(R.id.in_bday);
    String S_Birthday = T_Patient_Name.getText().toString();

    TextView T_Blood_Type = (TextView) PatientInfo.findViewById(R.id.in_blood);
    String S_Blood_Type = T_Patient_Name.getText().toString();

    TextView T_Weight = (TextView) PatientInfo.findViewById(R.id.in_weight);
    String S_Weight = T_Patient_Name.getText().toString();

    TextView T_Height = (TextView) PatientInfo.findViewById(R.id.in_height);
    String S_Height = T_Patient_Name.getText().toString();



    View Aller = factory.inflate(R.layout.tab3_allergies, null);
    ArrayList<String> Allergies = new ArrayList<String>();
    ArrayList<String> Reactions = new ArrayList<String>();

    Allergies.add("Penicillin");
    Reactions.add("Type II");
    Allergies.add("Poultry");
    Reactions.add("Type IV");

    for (int i=0;i<Allergies.size();i++){
        if (Reactions.get(i) == "Type I"){
            temp_reaction = "1";
            temp_allergies = temp_allergies + Allergies.get(i) + "," + temp_reaction + ",";
        }
        else if (Reactions.get(i) == "Type II"){
            temp_reaction = "2";
            temp_allergies = temp_allergies + Allergies.get(i) + "," + temp_reaction + ",";
        }
        else if (Reactions.get(i) == "Type III"){
            temp_reaction = "3";
            temp_allergies = temp_allergies + Allergies.get(i) + "," + temp_reaction + ",";
        }
        else if (Reactions.get(i) == "Type IV"){
            temp_reaction = "4";
            temp_allergies = temp_allergies + Allergies.get(i) + "," + temp_reaction + ",";
        }
        else{
            temp_allergies = temp_allergies + Allergies.get(i) + "Err";
        }
        }

    /*TableLayout table = (TableLayout) Aller.findViewById(R.id.myTableLayout);
        for(int i=0;i<Allergies.size();i++)
        {
            TableRow row=new TableRow(this);
            TextView textAllergies =new TextView(this);
            textAllergies.setText(Allergies.get(i).toString());
            TextView textReactions =new TextView(this);
            textReactions.setText(Reactions.get(i).toString());
            row.addView(textAllergies);
            row.addView(textReactions);
            table.addView(row);
        }*/



        String PD_Array = S_Patient_Name + "," + S_Gender + "," + S_Age + "," + S_Birthday + "," + S_Blood_Type + "," + S_Weight + "," + S_Height + ",";
        String Hx_Array = "NULL" + ",";
        String Aller_Array = temp_allergies;

        final String Data_Array = "0," + PD_Array;
        //final String Data_Array = coder.encrypt(Temp_Array, 3);



        iv = (ImageView) findViewById(R.id.iv);

        Generate = (Button) findViewById(R.id.Generate);
        Scan = (Button) findViewById(R.id.Scan);
        tvresult = (TextView) findViewById(R.id.tvresult);
        datatext = (TextView) findViewById(R.id.datatext);


        Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Data_Array.length() == 0){
                    Toast.makeText(QR.this, "Error! No Data!", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        if(Tab1_PatientInfo.patientname.getText() == " "){
                            bitmap = TextToImageEncode(Data_Array);
                        }
                        else{
                            bitmap = TextToImageEncode(tvresult.getText().toString());
                        }

                        iv.setImageBitmap(bitmap);
                        String path = saveImage(bitmap);  //give read write permission
                        Toast.makeText(QR.this, "QR Code Generated ", Toast.LENGTH_SHORT).show();
                        if (Tab1_PatientInfo.patientname.getText() == " "){
                            tvresult.setText(Data_Array);
                        }
                        else{
                            tvresult.setText(tvresult.getText().toString());
                        }



                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QR.this, ScanActivity.class);
                startActivity(intent);


                AlertDialog.Builder alt = new AlertDialog.Builder(QR.this);
                alt.setIcon(R.drawable.ic_qr);
                alt.setTitle("Data Detected");
                alt.setMessage("Update Data? \n" + datatext.getText());

                alt.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tab1_PatientInfo.patientname.setText(ScanActivity.lastname + "," +ScanActivity.firstname);
                        Tab1_PatientInfo.gender.setText(ScanActivity.gender);
                        Tab1_PatientInfo.age.setText(ScanActivity.age);
                        Tab1_PatientInfo.birthday.setText(ScanActivity.birthday);
                        Tab1_PatientInfo.bloodtype.setText(ScanActivity.bloodtype);
                        Tab1_PatientInfo.weight.setText(ScanActivity.weight);
                        Tab1_PatientInfo.height.setText(ScanActivity.height);
                    }
                });

                alt.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });
                alt.show();
            }
        });



    }


    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.

        if (!wallpaperDirectory.exists()) {
            Log.d("dirrrrrr", "" + wallpaperDirectory.mkdirs());
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();   //give read write permission
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";

    }
    private Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.black):getResources().getColor(R.color.white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }

}
