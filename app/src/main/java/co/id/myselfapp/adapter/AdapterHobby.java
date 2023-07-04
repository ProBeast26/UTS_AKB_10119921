package co.id.myselfapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import co.id.myselfapp.R;
import co.id.myselfapp.models.HobbyModel;

public class AdapterHobby extends RecyclerView.Adapter<AdapterHobby.ViewHolder> {

    List<HobbyModel> itemList1;
    private Context context;

    public AdapterHobby(List<HobbyModel> itemList,Context context) {

        this.itemList1=itemList;
        this.context=context;

    }

    @NonNull
    @Override
    public AdapterHobby.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hobby,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHobby.ViewHolder holder, final int position) {
        holder.title.setText(itemList1.get(position).getName());
        holder.myinterest.setText("My interest "+itemList1.get(position).getMyInterest()+"%");
        holder.progressBar.setProgress(itemList1.get(position).getMyInterest());
        holder.opininon.setText(itemList1.get(position).getMyOpinion());
        holder.imageView.setImageResource(itemList1.get(position).getImage());
//        holder.itemImage.setImageResource(itemList1.get(position).getImage());
//        holder.itemtxt.setText(itemList1.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return itemList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView opininon;
        TextView myinterest;
        ProgressBar progressBar;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_hobby);
            opininon = itemView.findViewById(R.id.my_op_hobby);
            myinterest = itemView.findViewById(R.id.my_int_des_hobby);
            progressBar = itemView.findViewById(R.id.progress_hobby);
            imageView = itemView.findViewById(R.id.imgTourismHr);
//            itemImage=itemView.findViewById(R.id.itemImg);
//            itemtxt=itemView.findViewById(R.id.itemName);
//            linearLayout=itemView.findViewById(R.id.layout_id);

        }
    }
}