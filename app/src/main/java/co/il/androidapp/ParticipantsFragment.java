package co.il.androidapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.il.androidapp.adapter.ParticipantAdapter;
import co.il.androidapp.model.ParticipantModel;


public class ParticipantsFragment extends Fragment {

    RecyclerView rv;
    ParticipantAdapter adapter;

    public ParticipantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_participants, container, false);
        rv = view.findViewById(R.id.participant_RecyclerView);
        rv.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);

        adapter = new ParticipantAdapter(getActivity(), ParticipantModel.instance.getAllParticipantList());
        rv.setAdapter(adapter);

        return view;
    }


    public void updateData(){
        adapter.notifyDataSetChanged();
    }
}