package com.example.macexcel.telehealth;

/**
 * Created by Macexcel on 9/1/2018.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Tab3_Allergies extends Fragment {

    public static ArrayList<String> allergies = new ArrayList<String>();
    public static ArrayList<String> reactions = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.tab3_allergies, container, false);







        return rootView;

    }
}
