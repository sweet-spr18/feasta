package edu.stjohns.jhuan414.comments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Comment extends AppCompatActivity{

    private CommentDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_layout);

        List<CommentDetail> commentDetailList = new ArrayList<>();

        //initialize and set recyclerview
        RecyclerView recyclerView = findViewById(R.id.CommentRecyclerView);
        recyclerView.setHasFixedSize(true);

        //set layout display method
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //add item into recyclerview
        commentDetailList.add(new CommentDetail("Good Food", "Jing01", "05/03/2018"));
        commentDetailList.add(new CommentDetail("Food are good and the event are nice too",
                "Jing02", "05/02/2018"));

        //Initialize and set the adapter
        CommentDetailAdapter adapter = new CommentDetailAdapter(this, commentDetailList);
        recyclerView.setAdapter(adapter);

        //point edittext variable to target edit text
        final EditText editComment = (EditText)findViewById(R.id.CommentEditText);
        Button postBtn = (Button) findViewById(R.id.PostBtn);

        //create on click listener method to the post comment button
        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentText = editComment.getText().toString();
                //Not sure how to set edit text into recyclerview.
                //textViewCommentText.setText(commentText);
            }
        });
    }
}
