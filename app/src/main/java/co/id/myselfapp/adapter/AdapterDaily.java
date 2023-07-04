package co.id.myselfapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import co.id.myselfapp.R;
import co.id.myselfapp.models.DailyModel;

public class AdapterDaily extends RecyclerView.Adapter<AdapterDaily.ViewHolder> {

    List<DailyModel> itemList1;
    private Context context;

    public AdapterDaily(List<DailyModel> itemList,Context context) {

        this.itemList1=itemList;
        this.context=context;

    }

    @NonNull
    @Override
    public AdapterDaily.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDaily.ViewHolder holder, final int position) {



    }

    @Override
    public int getItemCount() {
        return itemList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageDaily;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageDaily = itemView.findViewById(R.id.image_daily);

        }
    }
}