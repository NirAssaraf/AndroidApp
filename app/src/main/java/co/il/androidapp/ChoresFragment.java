package co.il.androidapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.zip.CheckedInputStream;

import co.il.androidapp.adapter.ChoreAdapter;
import co.il.androidapp.adapter.EventAdapter;
import co.il.androidapp.model.ChoreModel;
import co.il.androidapp.model.Event;
import co.il.androidapp.model.ModelDemo;


public class ChoresFragment extends Fragment {

    RecyclerView rv;
    ChoreAdapter adapter;
    public ChoresFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_chores, container, false);
         rv = view.findViewById(R.id.chore_RecyclerView);

        rv.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);

        //List<Event> data = ModelDemo.instance.getAllEvents();

        adapter = new ChoreAdapter(getActivity(), ChoreModel.instance.getAllChoreList());
        //adapter.data = data;
        rv.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }

    public void updateData() {

        adapter.notifyDataSetChanged();

    }
}

