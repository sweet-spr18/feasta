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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class LocationsListingActivity extends AppCompatActivity {

    Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private EventsListingAdapter mAdapter;
    private Location[] locationArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_listing);

        mToolbar = (Toolbar) findViewById(R.id.eventsListingToolbar);
        setSupportActionBar(mToolbar);

        /* Get a support ActionBar corresponding to this toolbar */
        ActionBar ab = getSupportActionBar();

        /* Enable the Up button *//* //TODO: THIS WILL NEED TO GO TO THE LocationsListing SCREEN ONCE WE HAVE THAT
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);*/

        String[] locNames = getResources().getStringArray(R.array.locations);
        locationArray = new Location[locNames.length];
        //TODO: add items into locationArray
        for (int i = 0; i < locNames.length; i++) {
            locationArray[i].setName(locNames[i]);
        }

        //initialize our Recycler and our Adapter
        mRecyclerView = (RecyclerView) findViewById(R.id.eventsListingRecyclerView);
        mAdapter = new LocationsListingAdapter(locationArray);

        //set up the Recycler and the Adapter
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LocationsListingActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        //myRef.setValue("Hello, World!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
                //TODO: then pass the event id to this putExtra code so that the fillable form can open for the appropriate event
                //editExistingEvent.putExtra("sweet1.feasta.EVENT-DETAILS", the-Event-object-to-retrieve);
                startActivity(editExistingEvent);
                return true;

            case R.id.action_add:
                Intent editNewEvent =
                        new Intent(getApplicationContext(), EventEditActivity.class);
                startActivity(editNewEvent);

                //NOT SURE HOW TO TIE IN THE OTHER CLASSES- CHELSEA
                //locationArray.add(NewEvent);
                return true;

            case R.id.action_logout:
                //TODO: make a popup message asking "Do you want to log out?" "Yes" "No"
                //TODO: then log out or come back to the current screen

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
