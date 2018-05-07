package com.example.jmori156.finalfinalfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LocationsListingActivity extends AppCompatActivity {

    Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private LocationsListingAdapter mAdapter;
    private Location[] locationArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations_listing);

        //TODO: implement this toolbar i.e. the LogOut button
        mToolbar = (Toolbar) findViewById(R.id.locationsListingToolbar);
        setSupportActionBar(mToolbar);

        String[] locNames = getResources().getStringArray(R.array.locations);
        locationArray = new Location[locNames.length];
        for (int i = 0; i < locNames.length; i++) {
            locationArray[i] = new Location(locNames[i]);
        }

        //initialize our Recycler and our Adapter
        mRecyclerView = (RecyclerView) findViewById(R.id.locationsListingRecyclerView);
        mAdapter = new LocationsListingAdapter(locationArray);

        //set up the Recycler and the Adapter
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LocationsListingActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        //TODO: Retrieve event list for each location
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        //some code here
    }

    //UNCOMMENT & EDIT THE FOLLOWING CODE IF NEED TO ADD OPTIONS TO THE TOOLBAR
   /* @Override
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
    }*/
}
