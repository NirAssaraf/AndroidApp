package co.il.androidapp;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import co.il.androidapp.adapter.EventAdapter;
import co.il.androidapp.model.Event;
import co.il.androidapp.model.ModelDemo;

public class EventListFragment extends Fragment {

    public EventListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_event_list, container, false);
        RecyclerView rv = view.findViewById(R.id.eventListFrag);

        rv.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);

        List<Event> data = ModelDemo.instance.getAllEvents();

        EventAdapter adapter = new EventAdapter(getLayoutInflater());
        adapter.data = data;
        rv.setAdapter(adapter);

        adapter.setOnClickListener(new EventAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Navigation.findNavController(view).navigate(R.id.action_eventListFragment_to_eventDetailsFragment);
            }
        });

        FloatingActionButton Fab=  view.findViewById(R.id.addEventBtn);
        Fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.actionEventListFrag_To_addEventFrag);
            }
        });
        return view;
    }

}