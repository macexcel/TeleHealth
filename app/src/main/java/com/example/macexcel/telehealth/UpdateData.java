package com.example.macexcel.telehealth;

import java.util.ArrayList;

/**
 * Created by Macexcel on 9/2/2018.
 */

public class UpdateData {

    private ArrayList<String> personal_array = new ArrayList<String>();
    private ArrayList<String> Hx_array = new ArrayList<String>();
    private ArrayList<String> allergies_array = new ArrayList<String>();

    private static String lastname;
    private static String firstname;
    private static String gender;
    private static String age;
    private static String birthday;
    private static String bloodType;
    private static String weight;
    private static String height;



    public ArrayList<String> Decode(String ScannedText){
        ScannedText = ScannedText.substring(2);
        lastname = ScannedText.substring(0, ScannedText.indexOf(','));
        ScannedText = ScannedText.substring(ScannedText.indexOf(',' + 1));
        firstname = ScannedText.substring(0, ScannedText.indexOf(','));
        ScannedText = ScannedText.substring(ScannedText.indexOf(',' + 1));
        if (ScannedText.charAt(0) == 'M'){
            gender = "Male";
        }
        else if (ScannedText.charAt(0) == 'F'){
            gender = "Female";
        }
        else{
            gender = "ERROR!";
        }
        ScannedText = ScannedText.substring(ScannedText.indexOf(',')+1);
        age = ScannedText.substring(0, ScannedText.indexOf(','));
        ScannedText = ScannedText.substring(ScannedText.indexOf(',')+1);
        birthday = ScannedText.substring(0,2) + "/" + ScannedText.substring(2,4) + "/" + ScannedText.substring(4,6);
        ScannedText = ScannedText.substring(ScannedText.indexOf(',')+1);
        bloodType = ScannedText.substring(0, ScannedText.indexOf(','));
        ScannedText = ScannedText.substring(ScannedText.indexOf(',')+1);
        weight = ScannedText.substring(0, ScannedText.indexOf(','));
        ScannedText = ScannedText.substring(ScannedText.indexOf(',')+1);
        height = ScannedText.substring(0, ScannedText.indexOf(','));

        personal_array.add(firstname);
        personal_array.add(lastname);
        personal_array.add(gender);
        personal_array.add(age);
        personal_array.add(birthday);
        personal_array.add(bloodType);
        personal_array.add(weight);
        personal_array.add(height);

        ScannedText = ScannedText.substring(ScannedText.indexOf('#' + 1));

        ScannedText = ScannedText.substring(ScannedText.indexOf('#' + 1));


        return personal_array;
    }
}
