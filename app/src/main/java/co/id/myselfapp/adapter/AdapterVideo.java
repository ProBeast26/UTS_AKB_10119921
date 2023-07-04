package co.id.myselfapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.id.myselfapp.R;
import co.id.myselfapp.models.VideoModel;

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.ViewHolder> {

    List<VideoModel> itemList1;
    private Context context;

    public AdapterVideo(List<VideoModel> itemList, Context context) {

        this.itemList1=itemList;
        this.context=context;

    }

    @NonNull
    @Override
    public AdapterVideo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVideo.ViewHolder holder, final int position) {
        holder.webViewYt.loadData(itemList1.get(position).getEmbedUrl(), "text/html", "utf-8");
    }

    @Override
    public int getItemCount() {
        return itemList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        WebView webViewYt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           webViewYt = itemView.findViewById(R.id.yt_webview);
            webViewYt.getSettings().setJavaScriptEnabled(true);
            webViewYt.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        }
    }
}