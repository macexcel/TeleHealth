package com.example.macexcel.telehealth;

/**
 * Created by Macexcel on 9/1/2018.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Tab1_PatientInfo extends Fragment {


    static public TextView patientname;
    static public TextView gender;
    static public TextView age;
    static public TextView birthday;
    static public TextView bloodtype;
    static public TextView weight;
    static public TextView height;
    static public TextView profile;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.tab1_patientinfo, container, false);

        patientname = (TextView) rootView.findViewById(R.id.in_patient);
        gender = (TextView) rootView.findViewById(R.id.in_gender);
        age = (TextView) rootView.findViewById(R.id.in_age);
        birthday = (TextView) rootView.findViewById(R.id.in_bday);
        bloodtype = (TextView) rootView.findViewById(R.id.in_blood);
        weight = (TextView) rootView.findViewById(R.id.in_weight);
        height = (TextView) rootView.findViewById(R.id.in_height);
        profile = (TextView) rootView.findViewById(R.id.textView8);


        return rootView;
    }


}
