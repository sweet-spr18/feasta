package sweet1.feasta;

/**
 * @author: tta
 *
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class EventEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);

        Toolbar eventEditToolbar = (Toolbar) findViewById(R.id.eventEditToolbar);
        setSupportActionBar(eventEditToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toolbar eventEditToolbar = (Toolbar) findViewById(R.id.eventEditToolbar);
        eventEditToolbar.inflateMenu(R.menu.menu_event_edit);
        eventEditToolbar.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return onOptionsItemSelected(item);
                    }
                }
        );
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
