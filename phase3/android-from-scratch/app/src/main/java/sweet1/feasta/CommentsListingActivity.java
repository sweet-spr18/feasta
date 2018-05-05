package sweet1.feasta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CommentsListingActivity extends AppCompatActivity {

    private CommentsListingAdapter adapter;
    private RecyclerView recyclerView;
    private List<Comment> commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments_listing);

        //TODO: the "frozen" bar (under the normal App Bar) showing the Event Details (see mockup.png on GitHub), see the activity_comments_listing.xml

        //initialize an empty commentBtn list
        commentList = new ArrayList<>();

        //check if the Intent that led to this activity has the Extra named as such
        if (getIntent().hasExtra("sweet1.feasta.THIS-EVENT")) {
            List<Comment> commentsBelongingToThisEvent = (List<Comment>) getIntent().getExtras().get("sweet1.feasta.THIS-EVENT");
            commentList.addAll(commentsBelongingToThisEvent);
        }
        /*//demo items to add to the list
        commentList.add(new Comment("Good Food", "Jing01", "05/03/2018"));
        commentList.add(new Comment("Food are good and the event are nice too",
                "Jing02", "05/02/2018"));*/


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
                editComment.setText(null);
            }
        });
    }
}
