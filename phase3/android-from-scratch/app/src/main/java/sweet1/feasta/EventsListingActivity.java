package sweet1.feasta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class EventsListingActivity extends AppCompatActivity {

    Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private EventAdapter mAdapter;
    private ArrayList<Event> eventArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_listing);

        mToolbar = (Toolbar) findViewById(R.id.eventsListingToolbar);
        setSupportActionBar(mToolbar);

        /* Get a support ActionBar corresponding to this toolbar */
        ActionBar ab = getSupportActionBar();

        /* Enable the Up button *//* //NOT SURE YET WHERE THIS UP WILL GO
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);*/

        eventArrayList = new ArrayList<>();
        eventArrayList.add(new Event("event1", "org1", "DAC 409", "1:50 PM - 3:15 PM", "Pizza", 3));
        eventArrayList.add(new Event("event2", "org2", "DAC 106", "6:00 PM - 8:00 PM", "Asian", 5));
        eventArrayList.add(new Event("event3", "org3", "DAC 416", "9:30 AM - 12:00 PM", "Italian", 2));

        /*final ToggleButton favoriteToggleButton = (ToggleButton) findViewById(R.id.favoriteToggleButton);
        favoriteToggleButton.setChecked(false);
        favoriteToggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favorite_border_black_24dp));
        favoriteToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    favoriteToggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favorite_black_24dp));
                else
                    favoriteToggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_favorite_border_black_24dp));
            }
        });*/
        //initialize our Recycler and our Adapter
        mRecyclerView = (RecyclerView) findViewById(R.id.eventsListingRecyclerView);
        mAdapter = new EventAdapter(eventArrayList);

        //set up the Recycler and the Adapter
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EventsListingActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*mToolbar = (Toolbar) findViewById(R.id.eventsListingToolbar);

        // Inflate the menu; this adds items to the bar if it is present
        mToolbar.inflateMenu(R.menu.menu_events_listing);
        mToolbar.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return onOptionsItemSelected(item);
                    }
                });*/
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_events_listing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                //TODO: make all entries in the listing selectable
                Intent editExistingEvent =
                        new Intent(getApplicationContext(), EventEditActivity.class);
                startActivity(editExistingEvent);
                return true;

            case R.id.action_add:
                Intent editNewEvent =
                        new Intent(getApplicationContext(), EventEditActivity.class);
                startActivity(editNewEvent);
                return true;

            case R.id.action_logout:
                //TODO: make a popup message asking "Do you want to log out?" "Yes" "No"

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
