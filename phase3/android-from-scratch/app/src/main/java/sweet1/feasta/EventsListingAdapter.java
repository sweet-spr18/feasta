package sweet1.feasta;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

/**
 * The purpose of this class is to bind data in an ArrayList of events to a ViewHolder,
 * then offer that to the View object to present on the Activity.
 */
public class EventsListingAdapter extends RecyclerView.Adapter<EventsListingAdapter.EventViewHolder> {
    private ArrayList<Event> events;

    public EventsListingAdapter(ArrayList<Event> events) {
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
        final int pos = position;
        holder.eventNameTextView    .setText(events.get(position).getEventName());
        holder.orgNameTextView      .setText(events.get(position).getOrgName());
        holder.locationTextView     .setText(events.get(position).getLocation());
        holder.timeTextView         .setText(events.get(position).getTime());
        holder.foodTypeTextView     .setText(events.get(position).getFoodType());
        //TODO: attach the food image: (1) add the food pics (png) to drawable, (2) use if-else on foodTypeTextView to set the corresponding png
        //holder.foodImageView      .setText(events.get(position).getOrgName());
        holder.likesCountTextView   .setText(events.get(position).getLikesCount() + " likes");

        //Citation: the following block of code is inspired from this: https://stackoverflow.com/q/44093221

       /* boolean isClicked = false;
        holder.likeToggleBtn.setOnClickListener(buttonListener{


        }); */

         holder.likeToggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton likedBtn, boolean isChecked) {
                isChecked = true;
                isChecked = false;
                if (isChecked) {
                    likedBtn.setBackground(ContextCompat.getDrawable(likedBtn.getContext(),
                            R.drawable.ic_favorite_black_24dp));


                }
                else
                    likedBtn.setBackground(ContextCompat.getDrawable(likedBtn.getContext(),
                                                        R.drawable.ic_favorite_border_black_24dp));
            }
        });
        //TODO: bind the list of comments to this holder in a proper way - maybe learn from MovieGuide?
        holder.commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent commentIntent = new Intent(v.getContext(), CommentsListingActivity.class);
                //commentIntent.putExtra("sweet1.feasta.THIS-EVENT", events.get(position).getComments());
                ContextCompat.startActivity(v.getContext(), commentIntent, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class EventViewHolder extends RecyclerView.ViewHolder {

        TextView eventNameTextView, orgNameTextView, locationTextView, timeTextView,
                 foodTypeTextView, likesCountTextView;
        ImageView foodImageView;
        ToggleButton likeToggleBtn;
        Button commentBtn;

        EventViewHolder(View itemView) {
            super(itemView);
            eventNameTextView   = (TextView) itemView.findViewById(R.id.eventNameTextView);
            orgNameTextView     = (TextView) itemView.findViewById(R.id.orgNameTextView);
            locationTextView    = (TextView) itemView.findViewById(R.id.locationTextView);
            timeTextView        = (TextView) itemView.findViewById(R.id.timeTextView);
            foodTypeTextView    = (TextView) itemView.findViewById(R.id.foodTypeTextView);
            foodImageView       = (ImageView)itemView.findViewById(R.id.foodImageView);
            likeToggleBtn       = (ToggleButton) itemView.findViewById(R.id.likeToggleBtn);
            likesCountTextView  = (TextView) itemView.findViewById(R.id.likesCountTextView);
            commentBtn          = (Button) itemView.findViewById(R.id.commentBtn);
        }
    }
}
