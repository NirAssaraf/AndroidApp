package co.il.androidapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import co.il.androidapp.adapter.EventAdapter;
import co.il.androidapp.model.Event;
import co.il.androidapp.model.ModelDemo;


public class EventListFragment extends Fragment {

    FloatingActionButton addEventBtn;

    public EventListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_event_list, container, false);
        RecyclerView rv =view.findViewById(R.id.eventListFrag);

        rv.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);

        List<Event> eventList = ModelDemo.instance.getAllEvents();

        EventAdapter eventAdapter =new EventAdapter(getLayoutInflater());
        eventAdapter.eventList=eventList;
        rv.setAdapter(eventAdapter);

        View view1 =inflater.inflate(R.layout.fragment_event_list, container, false);

// Need To figure it Out (the FloatingActionButton)
        addEventBtn=(FloatingActionButton) view1.findViewById(R.id.addEventBtn);
        addEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view1).navigate(R.id.actionEventListFrag_To_addEventFrag);
                //Toast.makeText(getContext(),"Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}