package co.id.myselfapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;

import co.id.myselfapp.R;
import co.id.myselfapp.models.GalleryModel;

public class AdapterGallery extends RecyclerView.Adapter<AdapterGallery.ViewHolder> {

    List<GalleryModel> itemList1;
    private Context context;

    public AdapterGallery(List<GalleryModel> itemList, Context context) {

        this.itemList1=itemList;
        this.context=context;

    }

    @NonNull
    @Override
    public AdapterGallery.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGallery.ViewHolder holder, final int position) {
        final int min = 200;
        final int max = 700;
        final int random = new Random().nextInt((max - min) + 1) + min;

        final int minImage = 200;
        final int maxImage = 500;
        final int randomImage = new Random().nextInt((maxImage - minImage) + 1) + minImage;
//        Glide.with(context).load("https://picsum.photos/"+randomImage+"/"+randomImage).into(holder.imageDaily);
        Glide.with(context)
                .load(itemList1.get(position).getNameImg())
                .into(holder.imageDaily);
        holder.imageDaily.getLayoutParams().height = random;
    }

    @Override
    public int getItemCount() {
        return itemList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageDaily;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageDaily = itemView.findViewById(R.id.imageViewGallery);

        }
    }
}