package co.id.myselfapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;


import co.id.myselfapp.R;
import co.id.myselfapp.models.MusicModel;

public class AdapterMusic extends RecyclerView.Adapter<AdapterMusic.ViewHolder> {

    List<MusicModel> itemList1;
    private Context context;

    public AdapterMusic(List<MusicModel> itemList, Context context) {

        this.itemList1=itemList;
        this.context=context;

    }

    @NonNull
    @Override
    public AdapterMusic.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMusic.ViewHolder holder, final int position) {
        final int min = 100;
        final int max = 400;
        final int random = new Random().nextInt((max - min) + 1) + min;
        Glide.with(context).load("https://picsum.photos/"+random+"/"+random).into(holder.thumbanilMusic);
        holder.band.setText( itemList1.get(position).getNameBand());
        holder.song.setText(itemList1.get(position).getTitleSong());
    }

    @Override
    public int getItemCount() {
        return itemList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbanilMusic;
        TextView  band,song;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbanilMusic = itemView.findViewById(R.id.thumbnail_music);
            band = itemView.findViewById(R.id.band_name);
            song = itemView.findViewById(R.id.title_song);

        }
    }
}