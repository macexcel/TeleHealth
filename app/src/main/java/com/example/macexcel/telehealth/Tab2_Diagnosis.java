package com.example.macexcel.telehealth;

/**
 * Created by Macexcel on 9/1/2018.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Tab2_Diagnosis extends Fragment {

    ArrayList<String> doa = new ArrayList<String>();
    ArrayList<String> medication = new ArrayList<String>();
    ArrayList<String> dosage = new ArrayList<String>();
    ArrayList<String> complaint = new ArrayList<String>();
    ArrayList<String> diagnosis = new ArrayList<String>();
    ArrayList<String> remarks = new ArrayList<String>();
    ArrayList<String> date_r = new ArrayList<String>();

    public static TextView entry1;
    public static TextView entry2;
    public static TextView entry3;
    public static TextView entry4;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.tab2_diagnosis, container, false);

        entry1 = (TextView) rootView.findViewById(R.id.entry1);
        entry2 = (TextView) rootView.findViewById(R.id.entry2);
        entry3 = (TextView) rootView.findViewById(R.id.entry3);
        entry4 = (TextView) rootView.findViewById(R.id.entry4);

        doa.add("08/18/18");
        complaint.add("Headache");
        diagnosis.add("Mild Fever");
        medication.add("Beclomethasone");
        dosage.add("2 pills");
        date_r.add("N/A");
        remarks.add("Take 2-3 days rest. \nDrink plenty of water. \n[UNRESOLVED - " + date_r.get(0) + "]");

        entry1.setText("Date of Appointment: " + doa.get(0) + "\n\t\tCompaint: " + complaint.get(0) + "\n\t\tDiagnosis: " + diagnosis.get(0) + "\n\t\tMedication: " + medication.get(0) + "\t\t\t\tDosage: " + dosage.get(0));
        entry1.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          AlertDialog.Builder alt_entry1 = new AlertDialog.Builder(getContext());
                                          alt_entry1.setTitle("Entry 1 - " + doa.get(0));
                                          alt_entry1.setMessage("Remarks: \n" + remarks.get(0));
                                          alt_entry1.setPositiveButton("OK", null);
                                          alt_entry1.show();
                                      }
                                  });

        doa.add("12/02/17");
        complaint.add("Nosebleed");
        diagnosis.add("Nose Injury");
        medication.add("Acetaminophen");
        medication.add("Ice Treatment");
        dosage.add("5mg");
        date_r.add("12/06/17");
        remarks.add("Place some ice wrapped cloth over the nose for about 15 minutes for 1-2 days to reduce swelling. \n[RESOLVED - " + date_r.get(1) + "]");

        entry2.setText("Date of Appointment: " + doa.get(1) + "\n\t\tCompaint: " + complaint.get(1) + "\n\t\tDiagnosis: " + diagnosis.get(1) + "\n\t\tMedication: " + medication.get(1) + "\t\t\t\tDosage: " + dosage.get(1) + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + medication.get(2));
        entry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alt_entry2 = new AlertDialog.Builder(getContext());
                alt_entry2.setTitle("Entry 2 - " + doa.get(1));
                alt_entry2.setMessage("Remarks: \n" + remarks.get(1));
                alt_entry2.setPositiveButton("OK", null);
                alt_entry2.show();
            }
        });

        doa.add("06/28/17");
        complaint.add("Fatigue");
        diagnosis.add("Rheumatic Fever");
        diagnosis.add("Pneumonia");
        medication.add("Penicillin");
        dosage.add("12.5mg");
        date_r.add("07/14/17");
        remarks.add("Take 1 week bed rest. \nDrink plenty of water. \n[RESOLVED - " + date_r.get(2) + "]");

        entry3.setText("Date of Appointment: " + doa.get(2) + "\n\t\tCompaint: " + complaint.get(2) + "\n\t\tDiagnosis: " + diagnosis.get(2) + "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + diagnosis.get(3) + "\n\t\tMedication: " + medication.get(3) + "\t\t\t\tDosage: " + dosage.get(2));
        entry3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alt_entry3 = new AlertDialog.Builder(getContext());
                alt_entry3.setTitle("Entry 3 - " + doa.get(2));
                alt_entry3.setMessage("Remarks: \n" + remarks.get(2));
                alt_entry3.setPositiveButton("OK", null);
                alt_entry3.show();
            }
        });
        /*
        doa.add("05/01,/17");
        complaint.add("Nausea");
        diagnosis.add("Dengue");
        medication.add("Glipizide");

        doa.add("04/14,/16");
        complaint.add("Nausea");
        diagnosis.add("Dengue");
        medication.add("Glipizide");
*/
        return rootView;
    }

}
