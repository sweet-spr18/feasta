package sweet1.feasta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class EventsListingActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EventAdapter mAdapter;
    private ArrayList<Event> eventArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_listing);

        eventArrayList = new ArrayList<>();
        eventArrayList.add(new Event("event1", "org1", "DAC 409", "1:50 PM - 3:15 PM"));
        eventArrayList.add(new Event("event2", "org2", "DAC 106", "6:00 PM - 8:00 PM"));
        eventArrayList.add(new Event("event3", "org3", "DAC 416", "9:30 AM - 12:00 PM"));

        mRecyclerView = (RecyclerView) findViewById(R.id.eventsListingRecyclerView);
        mAdapter = new EventAdapter(eventArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EventsListingActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
    }
}
