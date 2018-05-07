package sweet1.feasta;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
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

public class EventsListingActivity extends AppCompatActivity {

    Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private EventsListingAdapter mAdapter;
    private ArrayList<Event> eventArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_listing);

        mToolbar = (Toolbar) findViewById(R.id.eventsListingToolbar);
        setSupportActionBar(mToolbar);

        /* Get a support ActionBar corresponding to this toolbar */
        ActionBar ab = getSupportActionBar();

        /* Enable the Up button */
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

        eventArrayList = new ArrayList<>();
        eventArrayList.add(new Event("event1", "org1", "DAC 409", "1:50 PM - 3:15 PM", "Pizza", 3, null));
        eventArrayList.add(new Event("event2", "org2", "DAC 106", "6:00 PM - 8:00 PM", "Asian", 5, null));
        eventArrayList.add(new Event("event3", "org3", "DAC 416", "9:30 AM - 12:00 PM", "Italian", 2, null));

        //initialize our Recycler and our Adapter
        mRecyclerView = (RecyclerView) findViewById(R.id.eventsListingRecyclerView);
        mAdapter = new EventsListingAdapter(eventArrayList);

        //set up the Recycler and the Adapter
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EventsListingActivity.this);
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
                //eventArrayList.add(NewEvent);
                return true;

            case R.id.action_logout:
                showAlert();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        dialog.cancel();
                        //TODO: need to log out at this point aka (1) remove user profile + bring back login screen
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
