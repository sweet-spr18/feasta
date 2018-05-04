package sweet1.feasta;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

/**
 * The purpose of this class is to bind data in an ArrayList of events to a ViewHolder,
 * then offer that to the View object to present on the Activity.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private ArrayList<Event> events;

    public EventAdapter(ArrayList<Event> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.card_event, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.eventName.setText(events.get(position).getEventName());
        holder.orgName.setText(events.get(position).getOrgName());
        holder.location.setText(events.get(position).getLocation());
        holder.time.setText(events.get(position).getTime());
        //holder.foodImage.setText(events.get(position).getOrgName());
        holder.foodType.setText(events.get(position).getFoodType());
        //holder.likesCount.setText(events.get(position).getLikesCount() + " likes");
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class EventViewHolder extends RecyclerView.ViewHolder {

        TextView eventName, orgName, location, time, foodType;
        ToggleButton likesCount;

        EventViewHolder(View itemView) {
            super(itemView);
            eventName   = (TextView) itemView.findViewById(R.id.eventNameTextView);
            orgName     = (TextView) itemView.findViewById(R.id.orgNameTextView);
            location    = (TextView) itemView.findViewById(R.id.locationTextView);
            time        = (TextView) itemView.findViewById(R.id.timeTextView);
            foodType    = (TextView) itemView.findViewById(R.id.foodTypeTextView);
            //likesCount  = (ToggleButton) itemView.findViewById(R.id.favoriteToggleButton);
        }
    }
}
