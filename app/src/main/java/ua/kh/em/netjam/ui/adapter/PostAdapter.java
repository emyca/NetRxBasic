package ua.kh.em.netjam.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ua.kh.em.netjam.R;
import ua.kh.em.netjam.data.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> list;

    public PostAdapter(ArrayList<Post> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        Post item = list.get(position);

        holder.postTitle.setText(item.getTitle());
        holder.postBody.setText(item.getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {

        TextView postTitle;
        TextView postBody;

        PostViewHolder(@NonNull View itemView) {
            super(itemView);

            postTitle = itemView.findViewById(R.id.post_title);
            postBody = itemView.findViewById(R.id.post_body);
        }
    }

    public void addListPost(List<Post> listPost) {
        this.list = listPost;
        notifyDataSetChanged();
    }
}
