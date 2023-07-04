package co.id.myselfapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import co.id.myselfapp.R;
import co.id.myselfapp.models.FoodModel;

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.ViewHolder> {

    List<FoodModel> itemList1;
    private Context context;

    public AdapterFood(List<FoodModel> itemList, Context context) {

        this.itemList1=itemList;
        this.context=context;

    }

    @NonNull
    @Override
    public AdapterFood.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_drink,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFood.ViewHolder holder, final int position) {
        holder.title.setText(itemList1.get(position).getTitle());
        holder.opininon.setText(itemList1.get(position).getDesc());
        holder.rate.setText(""+itemList1.get(position).getRate());
        if(itemList1.get(position).getTipe().equals("food")){
            holder.imageView.setImageResource(R.drawable.food);
        }else{
            holder.imageView.setImageResource(R.drawable.drinking);
        }
    }

    @Override
    public int getItemCount() {
        return itemList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView opininon;
        TextView rate;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_food);
            opininon = itemView.findViewById(R.id.my_op_food);
            imageView = itemView.findViewById(R.id.imgFood);
            rate = itemView.findViewById(R.id.rate_food);
//            itemImage=itemView.findViewById(R.id.itemImg);
//            itemtxt=itemView.findViewById(R.id.itemName);
//            linearLayout=itemView.findViewById(R.id.layout_id);

        }
    }
}