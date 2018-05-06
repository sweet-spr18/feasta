package sweet1.feasta;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The purpose of this class is to bind data in an array of locations to a ViewHolder,
 * then offer that to the View object to present on the Activity.
 */
public class LocationsListingAdapter extends RecyclerView.Adapter<LocationsListingAdapter.EventViewHolder> {
    private Location[] locations;

    public LocationsListingAdapter(Location[] locations) {
        this.locations = locations;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.frame_location, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final EventViewHolder holder, final int position) {
        holder.locationNameTextView.setText(locations[position].getName());
        holder.locationImageView.setImageResource(locations[position].getImageResID());

        //TODO: bind the list of events to this holder in a proper way - maybe learn from MovieGuide?
        holder.locationImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent commentIntent = new Intent(v.getContext(), CommentsListingActivity.class);
                //commentIntent.putExtra("sweet1.feasta.THIS-EVENT", locations.get(position).getComments());
                ContextCompat.startActivity(v.getContext(), commentIntent, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return locations.length;
    }

    class EventViewHolder extends RecyclerView.ViewHolder {

        TextView locationNameTextView;
        ImageView locationImageView;

        EventViewHolder(View itemView) {
            super(itemView);
            locationNameTextView   = (TextView) itemView.findViewById(R.id.locationNameTextView);
            locationImageView      = (ImageView)itemView.findViewById(R.id.locationImageView);
        }
    }
}
