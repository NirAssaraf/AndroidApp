package co.il.androidapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;


public class AddEventFragment extends Fragment {

     private int position;
     Button saveBtn;
     Button cancelBtn;
     EditText eventName;
     EditText eventDate;
     EditText eventDescription;
     Spinner spinnerEvent;

     String[] subject = {"birthday","house Party","sit In The House","party",};

    public AddEventFragment() {
        // Required empty public constructor
        this.position = 0;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_event, container, false);
        spinnerEvent= view.findViewById(R.id.event_subject);
        spinnerEvent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //tell us which position are choose
                position=i;

            }
        });

        ArrayAdapter aa = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,subject);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEvent.setAdapter(aa);
        eventName = view.findViewById(R.id.AddEventName);
        eventDate = view.findViewById(R.id.addEventDate);
        eventDescription = view.findViewById(R.id.addEventDescription);
        saveBtn = view.findViewById(R.id.SaveEventBtn);
        cancelBtn = view.findViewById(R.id.CancelEventBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }



}