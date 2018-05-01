package sweet1.feasta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class EventEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);

        Toolbar eventEditToolbar = findViewById(R.id.eventEditToolbar);
        setSupportActionBar(eventEditToolbar);

        /* Get a support ActionBar corresponding to this toolbar */
        ActionBar ab = getSupportActionBar();

        /* Enable the Up button */
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the bar if it is present
        getMenuInflater().inflate(R.menu.menu_event_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_publish:
                //TODO: publish the event (i.e. add to database)
                //TODO: show an overflow message "Your event has been published"
                Intent backToEventsList =
                        new Intent(getApplicationContext(), EventsListingActivity.class);
                startActivity(backToEventsList);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
