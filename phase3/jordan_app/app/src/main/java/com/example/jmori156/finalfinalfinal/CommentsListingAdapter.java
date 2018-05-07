package com.example.jmori156.finalfinalfinal;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

public class CommentsListingAdapter extends RecyclerView.Adapter<CommentsListingAdapter.CommentDetailViewHolder>{

    private Context mContext;
    private List<Comment> commentList;
    private SimpleDateFormat mDTFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    //see rerference for formatter patterns here: https://developer.android.com/reference/java/text/SimpleDateFormat


    CommentsListingAdapter(Context mContext, List<Comment> commentList) {
        this.mContext = mContext;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    //Create VIewHolder, import layout, instantiate itemView
    public CommentDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.card_comment, parent, false);
        return new CommentDetailViewHolder(view);
    }

    @Override
    //Bind VIewHolder and load data
    public void onBindViewHolder(@NonNull CommentDetailViewHolder holder, int position) {
        Comment comment = commentList.get(position);

        //loading data
        holder.textViewCommentText.setText(comment.getText());
        holder.textViewUserName.setText(comment.getUserName());
        holder.textViewTimeStamp.setText(mDTFormatter.format(comment.getTime()));
    }

    @Override
    //get The number of data sources, the number of item
    public int getItemCount() {
        return commentList.size();
    }

    class CommentDetailViewHolder extends RecyclerView.ViewHolder{

        TextView textViewCommentText, textViewUserName, textViewTimeStamp;

        CommentDetailViewHolder(View itemView) {
            super(itemView);

            textViewCommentText = (TextView) itemView.findViewById(R.id.textViewCommentText);
            textViewUserName = (TextView) itemView.findViewById(R.id.textViewUserName);
            textViewTimeStamp = (TextView) itemView.findViewById(R.id.textViewTimeStamp);

        }
    }

}
