package co.id.myselfapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import co.id.myselfapp.adapter.AdapterDaily;
import co.id.myselfapp.adapter.AdapterFriends;
import co.id.myselfapp.models.DailyModel;
import co.id.myselfapp.models.FriendsModel;


public class DailyActivity extends AppCompatActivity {
    RecyclerView friendsrecyler,dailyRecyler;
    List<FriendsModel> itemFriends;
    List<DailyModel>itemDaily;
    TextView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        friendsrecyler = findViewById(R.id.list_friends);
        dailyRecyler = findViewById(R.id.list_daily);
        backButton = findViewById(R.id.back_daily);
        backButton.setOnClickListener(v -> {finish();});
        initdata();

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        friendsrecyler.setLayoutManager(layoutManager);
        friendsrecyler.setAdapter(new AdapterFriends(itemFriends,getApplicationContext()));

        LinearLayoutManager layoutManagerVertical
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        dailyRecyler.setLayoutManager(layoutManagerVertical);
        dailyRecyler.setAdapter(new AdapterDaily(itemDaily,getApplicationContext()));
    }
     private void initdata(){
        itemDaily = new ArrayList<>();
        itemDaily.add(new DailyModel("","","",0));
         itemDaily.add(new DailyModel("","","",0));
         itemDaily.add(new DailyModel("","","",0));
         itemDaily.add(new DailyModel("","","",0));
         itemDaily.add(new DailyModel("","","",0));
         itemDaily.add(new DailyModel("","","",0));
         itemDaily.add(new DailyModel("","","",0));
         itemDaily.add(new DailyModel("","","",0));


         itemFriends = new ArrayList<>();
        itemFriends.add(new FriendsModel("1","Muhaammad Alvin"));
         itemFriends.add(new FriendsModel("1","Deral Alvin"));
         itemFriends.add(new FriendsModel("1","Dilan Alvin"));
         itemFriends.add(new FriendsModel("1","Sabath"));
         itemFriends.add(new FriendsModel("1","my freinds"));
         itemFriends.add(new FriendsModel("1","solusi"));
     }
}