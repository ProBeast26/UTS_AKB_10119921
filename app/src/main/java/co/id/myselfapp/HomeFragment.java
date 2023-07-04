
package co.id.myselfapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import co.id.myselfapp.adapter.AdapterFood;
import co.id.myselfapp.adapter.AdapterHobby;
import co.id.myselfapp.models.FoodModel;
import co.id.myselfapp.models.HobbyModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ColorStateList def;
    TextView item1;
    TextView item2;
    TextView item3;
    TextView select;
    FrameLayout fragHobby,fragFood,fragInterest;
    RecyclerView recyclerView,recyclerViewFood;
    List<HobbyModel> itemHobby;
    List<FoodModel>itemFood;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the lay

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        TextView my_desc = v.findViewById(R.id.my_desc);
        String html = "Hello saya Fakih Syafalik</b><br/> Saya Kuliah di Indonesian Computer University and majoring in informatics engineering";
        my_desc.setText(HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY));

        item1 = v.findViewById(R.id.item1);
        item2 = v.findViewById(R.id.item2);
        item3 = v.findViewById(R.id.item3);
        init();
        recyclerView=v.findViewById(R.id.hobby_value);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new AdapterHobby(initData(),getContext()));
        fragHobby = v.findViewById(R.id.fHobby);

        recyclerViewFood = v.findViewById(R.id.food_value);
        recyclerViewFood.setHasFixedSize(true);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewFood.setAdapter(new AdapterFood(itemFood,getContext()));
        fragFood = v.findViewById(R.id.fFood);
        fragInterest = v.findViewById(R.id.fInterest);
        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        select = v.findViewById(R.id.select);
        def = item2.getTextColors();

        return v;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.item1) {
            select.animate().x(0).setDuration(100);
            item1.setTextColor(Color.WHITE);
            item2.setTextColor(def);
            item3.setTextColor(def);
            fadeOutAnimation(fragFood);
            fadeOutAnimation(fragInterest);
            fadeInAnimation(fragHobby);
        } else if (view.getId() == R.id.item2) {
            item1.setTextColor(def);
            item2.setTextColor(Color.WHITE);
            item3.setTextColor(def);
            int size = item2.getWidth();
            select.animate().x(size).setDuration(100);
            fadeOutAnimation(fragHobby);
            fadeOutAnimation(fragInterest);
            fadeInAnimation(fragFood);
        } else if (view.getId() == R.id.item3) {
            item1.setTextColor(def);
            item3.setTextColor(Color.WHITE);
            item2.setTextColor(def);
            int size = item2.getWidth() * 2;
            select.animate().x(size).setDuration(100);
            fadeOutAnimation(fragHobby);
            fadeOutAnimation(fragFood);
            fadeInAnimation(fragInterest);
        }
    }

    private void init(){
        itemFood = new ArrayList<>();
        itemFood.add(new FoodModel("Fried Rice","one of my favorite foods, because it's very easy to cook","food",5.0));
        itemFood.add(new FoodModel("Kopi Kenangan","Very delicious coffee to drink anytime","drink",4.7));
        itemFood.add(new FoodModel("Kopi Kenangan","Very delicious coffee to drink anytime","drink",4.7));
        itemFood.add(new FoodModel("Seafood","Very delicious coffee to drink anytime","food",4.5));

    }
    void fadeOutAnimation(View viewToFadeOut) {
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(viewToFadeOut, "alpha", 1f, 0f);

        fadeOut.setDuration(500);
        fadeOut.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // We wanna set the view to GONE, after it's fade out. so it actually disappear from the layout & don't take up space.
                viewToFadeOut.setVisibility(View.GONE);
            }
        });

        fadeOut.start();
    }

    void fadeInAnimation(View viewToFadeIn) {
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(viewToFadeIn, "alpha", 0f, 1f);
        fadeIn.setDuration(500);
        fadeIn.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                viewToFadeIn.setVisibility(View.VISIBLE);
                viewToFadeIn.setAlpha(0);
            }
        });
        fadeIn.start();
    }



    private List<HobbyModel> initData() {

        itemHobby = new ArrayList<>();
        itemHobby.add(new HobbyModel("Mountaineering", R.drawable.hiking, "its my love hobby i like a nature", 90));
        itemHobby.add(new HobbyModel("Vollyball", R.drawable.volleyball, "i like sport volley ball", 75));
        itemHobby.add(new HobbyModel("Futsal", R.drawable.futsal, "futsal one of many sport i like it", 83));
        itemHobby.add(new HobbyModel("Play Guitar", R.drawable.guitar, "the song make me peace", 81));
        return itemHobby;
    }
}