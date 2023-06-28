package com.quangpao.webservice2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostRVAdapter extends RecyclerView.Adapter<PostRVAdapter.ViewHolder> {

    private ArrayList<Post> postArrayList;
    private Context context;

    public PostRVAdapter(ArrayList<Post> postArrayList, Context context) {
        this.postArrayList = postArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = postArrayList.get(position);
        holder.postUserIdTV.setText(String.valueOf(post.getUserId()));
        holder.postIdTV.setText(String.valueOf(post.getId()));
        holder.postTitleTV.setText(post.getTitle());
        holder.postBodyTV.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView postUserIdTV, postIdTV, postTitleTV, postBodyTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            postUserIdTV = itemView.findViewById(R.id.tvUserId);
            postIdTV = itemView.findViewById(R.id.tvPostId);
            postTitleTV = itemView.findViewById(R.id.tvTitle);
            postBodyTV = itemView.findViewById(R.id.tvBody);
        }
    }
}
