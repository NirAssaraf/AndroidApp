package co.il.androidapp.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import co.il.androidapp.R;
import co.il.androidapp.model.Event;


public class EventViewHolder extends RecyclerView.ViewHolder{
    public EventAdapter.OnItemClickListener listener;
    TextView EventName;
    int position;

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        EventName = itemView.findViewById(R.id.eventViewName);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position);
            }
        });
    }

    public void bindData(Event event, int position) {
        this.EventName.setText(event.EventName);
        this.position = position;
    }
}
