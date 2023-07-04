package co.id.myselfapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;

import co.id.myselfapp.R;
import co.id.myselfapp.models.FriendsModel;


public class AdapterFriends extends RecyclerView.Adapter<AdapterFriends.ViewHolder> {

    List<FriendsModel> itemList1;
    private Context context;

    public AdapterFriends(List<FriendsModel> itemList,Context context) {

        this.itemList1=itemList;
        this.context=context;

    }

    @NonNull
    @Override
    public AdapterFriends.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friends,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFriends.ViewHolder holder, final int position) {

        holder.title.setText(itemList1.get(position).getName());
        final int min = 200;
        final int max = 300;
        final int random = new Random().nextInt((max - min) + 1) + min;
        Glide.with(context).load("https://picsum.photos/"+random+"/"+random).into(holder.friendsImage);


    }

    @Override
    public int getItemCount() {
        return itemList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        LinearLayout linearLayout;
        ImageView friendsImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            friendsImage= itemView.findViewById(R.id.friends_image);
            linearLayout = itemView.findViewById(R.id.linear_main_friends);
            title = itemView.findViewById(R.id.friends_name);
        }
    }
}