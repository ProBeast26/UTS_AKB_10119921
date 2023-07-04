package co.id.myselfapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


import co.id.myselfapp.adapter.AdapterMusic;
import co.id.myselfapp.adapter.AdapterVideo;
import co.id.myselfapp.models.MusicModel;
import co.id.myselfapp.models.VideoModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicFragment extends Fragment {
    List<MusicModel> itemMusic;
    List<VideoModel> itemVideo;
    RecyclerView recyclerViewMusic,recyclerViewVideos;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MusicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicFragment newInstance(String param1, String param2) {
        MusicFragment fragment = new MusicFragment();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_music, container, false);
        initdata();
        recyclerViewMusic = v.findViewById(R.id.fav_music);
        recyclerViewVideos = v.findViewById(R.id.fav_video);

        recyclerViewMusic.setHasFixedSize(true);
        recyclerViewMusic.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewMusic.setAdapter(new AdapterMusic(itemMusic,getContext()));

        recyclerViewVideos.setHasFixedSize(true);
        recyclerViewVideos.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewVideos.setAdapter(new AdapterVideo(itemVideo,getContext()));
        return v;
    }

    void initdata(){
        itemVideo = new ArrayList<>();
        itemMusic = new ArrayList<>();
        itemMusic.add(new MusicModel("Coldplay","Paradise"));
        itemMusic.add(new MusicModel("Hindia","Evaluasi"));
        itemMusic.add(new MusicModel("Kunto Aji","Terlalu Lama Sendiri"));
        itemMusic.add(new MusicModel("Adele","Send My Love (To Your New Lover"));

        itemVideo.add(new VideoModel("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=DbOulmdGIh8&t=2s\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        itemVideo.add(new VideoModel("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=c9bHbB8z7Cg\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        itemVideo.add(new VideoModel("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=IiZpbbffi1s\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));

    }
}