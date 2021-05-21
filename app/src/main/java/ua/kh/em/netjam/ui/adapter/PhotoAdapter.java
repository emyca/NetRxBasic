package ua.kh.em.netjam.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ua.kh.em.netjam.R;
import ua.kh.em.netjam.data.model.Photo;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private List<Photo> list;

    public PhotoAdapter(ArrayList<Photo> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhotoViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_photo,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {

        Photo item = list.get(position);

        Picasso.get()
                .load(item.getUrl())
                .error(R.drawable.ic_image)
                .placeholder(R.drawable.ic_image)
                .fit()
                .into(holder.photoImage);

        holder.photoTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class PhotoViewHolder extends RecyclerView.ViewHolder {

        ImageView photoImage;
        TextView photoTitle;

        PhotoViewHolder(@NonNull View itemView) {
            super(itemView);

            photoImage = itemView.findViewById(R.id.photo_image);
            photoTitle = itemView.findViewById(R.id.photo_title);
        }
    }

    public void addListPhoto(List<Photo> listPhoto) {
        this.list = listPhoto;
        notifyDataSetChanged();
    }
}
