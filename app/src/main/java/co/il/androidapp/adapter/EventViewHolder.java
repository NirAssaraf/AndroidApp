package co.il.androidapp.adapter;

import android.graphics.drawable.Icon;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import co.il.androidapp.model.Event;

public class EventViewHolder extends RecyclerView.ViewHolder {
    public EventAdapter.OnItemClickListener listener;
    TextView EventName;
    TextView EventDetails;
    ImageView EventImage;


    int position;

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        EventName = itemView.findViewById(R.id.eventNameView);
//        EventImage = itemView.findViewById(R.id.eventImageView);
        EventDetails=itemView.findViewById(R.id.eventDetailsView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position);
            }
        });
    }

    public void bindData(Event event, int position) {
        EventName.setText(event.EventName);
        EventDetails.setText(event.EventDetails);
        this.position = position;
    }
}
