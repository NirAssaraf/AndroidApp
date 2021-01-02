package co.il.androidapp;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import co.il.androidapp.adapter.EventAdapter;
import co.il.androidapp.model.Event;
import co.il.androidapp.model.ModelDemo;

public class EventListFragment extends Fragment {

    private eventInterface callback;
    private RecyclerView rv;
    private EventAdapter adapter;

    public interface eventInterface{
        void onItemClickEvent(Event event);
    }
    public EventListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_event_list, container, false);
        try {
            if(getArguments()!= null){
                //try to get data from addEventFragment
                EventListFragmentArgs args = EventListFragmentArgs.fromBundle(getArguments());
                //add the event into the model
                ModelDemo.instance.addEvent(args.getEvent());
                //refresh the adapter
                adapter.notifyDataSetChanged();
            }
        }catch (Exception e){}

        rv = view.findViewById(R.id.eventListFrag);
        rv.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);

        List<Event> data = ModelDemo.instance.getAllEvents();

        adapter = new EventAdapter();
        adapter.data = data;
        rv.setAdapter(adapter);

        adapter.setOnClickListener(new EventAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                callback.onItemClickEvent(data.get(position));
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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callback=(eventInterface) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback=null;
    }
}