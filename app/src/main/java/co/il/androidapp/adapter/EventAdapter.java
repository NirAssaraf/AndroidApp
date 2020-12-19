package co.il.androidapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.il.androidapp.R;
import co.il.androidapp.model.Event;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {
    public List<Event> eventList;
    LayoutInflater inflater;

    public EventAdapter(LayoutInflater inflater){
        this.inflater = inflater;
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.event_row,parent,false);
        EventViewHolder holder = new EventViewHolder(view);
        holder.listener = listener;
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.bindData(event,position);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}

