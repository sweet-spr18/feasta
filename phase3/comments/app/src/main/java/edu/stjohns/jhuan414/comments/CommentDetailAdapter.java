package edu.stjohns.jhuan414.comments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CommentDetailAdapter extends RecyclerView.Adapter<CommentDetailAdapter.CommentDetailViewHolder>{

    private Context mContext;
    private List<CommentDetail> commentDetailList;


    CommentDetailAdapter(Context mContext, List<CommentDetail> commentDetailList) {
        this.mContext = mContext;
        this.commentDetailList = commentDetailList;
    }

    @NonNull
    @Override
    //Create VIewHolder, import layout, instantiate itemView
    public CommentDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.commnet_list_layout, null);
        return new CommentDetailViewHolder(view);
    }

    @Override
    //Bind VIewHolder and load data
    public void onBindViewHolder(@NonNull CommentDetailViewHolder holder, int position) {
        CommentDetail commentDetail = commentDetailList.get(position);

        //loading data
        holder.textViewCommentText.setText(commentDetail.getCommentText());
        holder.textViewUserName.setText(commentDetail.getUserName());
        holder.textViewTimeStamp.setText(commentDetail.getTimeStamp());
    }

    @Override
    //get The number of data sources, the number of item
    public int getItemCount() {
        return commentDetailList.size();
    }

    class CommentDetailViewHolder extends RecyclerView.ViewHolder{

        TextView textViewCommentText, textViewUserName, textViewTimeStamp;

        CommentDetailViewHolder(View itemView) {
            super(itemView);

            textViewCommentText = itemView.findViewById(R.id.textViewCommentText);
            textViewUserName = itemView.findViewById(R.id.textViewUserName);
            textViewTimeStamp = itemView.findViewById(R.id.textViewTimeStamp);

        }
    }

}
