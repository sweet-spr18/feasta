package sweet1.feasta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CommentsListingActivity extends AppCompatActivity {

    private CommentsListingAdapter adapter;
    private RecyclerView recyclerView;
    private List<Comment> commentList;
    private String Event_Details;

    private String FoodType;
    private String eventName;
    private String Location;
    private String Time;


    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("comment");
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments_listing);
        mToolbar = (Toolbar) findViewById(R.id.commentsListingToolbar);
        setSupportActionBar(mToolbar);

        /* Get a support ActionBar corresponding to this toolbar */
        ActionBar ab = getSupportActionBar();

        /* Enable the Up button */
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);

        //initialize an empty commentBtn list
        commentList = new ArrayList<>();

        //Passing of Event Details
        Event_Details = (String) getIntent().getExtras().get("Details");
        assignDetails(Event_Details);
        /*//demo items to add to the list
        commentList.add(new Comment("Good Food", "Jing01", "05/03/2018"));
        commentList.add(new Comment("Food are good and the event are nice too",
                "Jing02", "05/02/2018"));*/


        //Adding details
        LinearLayout lView = (LinearLayout)findViewById(R.id.textViewLayout);
        LinearLayout lView2 = (LinearLayout)findViewById(R.id.textView2Layout);
        LinearLayout lView3 = (LinearLayout)findViewById(R.id.textView3Layout);
        LinearLayout lView4 = (LinearLayout)findViewById(R.id.textView4Layout);

        /* DISPLAY THE EXISTING COMMENTS */

        //initialize and set recyclerview
        recyclerView = (RecyclerView) findViewById(R.id.CommentRecyclerView);
        recyclerView.setHasFixedSize(true); //Thoa: I don't know what this line is for. Things still come up same way when I commentBtn it out.

        //set layout display method
        recyclerView.setLayoutManager(new LinearLayoutManager(CommentsListingActivity.this));

        //Initialize and set the adapter
        adapter = new CommentsListingAdapter(this, commentList);
        recyclerView.setAdapter(adapter);

        /////////////////////////////////////////////////////////////////////////////////////////
        /* POST NEW COMMENT HERE */

        //point edittext variable to target edit text
        final EditText editComment = (EditText)findViewById(R.id.CommentEditText);
        Button postBtn = (Button) findViewById(R.id.PostBtn);


        //create on click listener method to the post commentBtn button
        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentText = editComment.getText().toString();
                commentList.add(new Comment(commentText, "Jing03", Calendar.getInstance().getTime().toString()));
                adapter.notifyDataSetChanged();


                myRef.setValue(commentText);
                editComment.setText(null);
            }
        });
    }

    private void assignDetails(String event_details)
    {
        String[] seprated = event_details.split("|");
        FoodType = seprated[0];
        Location = seprated[1];
        eventName= seprated[2];
        Time= seprated[3];
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                //TODO: publish the event (i.e. add to database)
                Toast.makeText(CommentsListingActivity.this, "", Toast.LENGTH_LONG).show();
                Intent backToEvent =
                        new Intent(getApplicationContext(), EventsListingActivity.class);
                startActivity(backToEvent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showEventDetails()
    {

    }
}
