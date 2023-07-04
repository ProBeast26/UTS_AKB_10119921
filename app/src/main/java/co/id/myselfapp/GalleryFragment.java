package co.id.myselfapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


import co.id.myselfapp.adapter.AdapterGallery;
import co.id.myselfapp.models.GalleryModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    ArrayList<GalleryModel> galleryModels = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
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
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);
        initdata();
        RecyclerView galleryRv = v.findViewById(R.id.list_gallery);
        StaggeredGridLayoutManager gridLayoutManager = new  StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        galleryRv.setLayoutManager(gridLayoutManager);

       galleryRv.setAdapter(new AdapterGallery(galleryModels,getContext()));

        return v;
    }


    private void initdata(){
        galleryModels = new ArrayList<>();
//        for (int i = 0; i <50 ; i++) {
//            galleryModels.add(new GalleryModel("https://drive.google.com/uc?export=download&id=1MHULB2MXlYQ0CI9jgvIE8EX4fVELjQ7y"));
//
//        }
        galleryModels.add(new GalleryModel("https://epiphytic-aluminums.000webhostapp.com/s1.png"));
        galleryModels.add(new GalleryModel("https://epiphytic-aluminums.000webhostapp.com/s3.png"));
        galleryModels.add(new GalleryModel("https://epiphytic-aluminums.000webhostapp.com/s2.png"));
        galleryModels.add(new GalleryModel("https://epiphytic-aluminums.000webhostapp.com/s4.png"));
        galleryModels.add(new GalleryModel("https://epiphytic-aluminums.000webhostapp.com/s5.png"));
        galleryModels.add(new GalleryModel("https://epiphytic-aluminums.000webhostapp.com/s6.png"));
        galleryModels.add(new GalleryModel("https://epiphytic-aluminums.000webhostapp.com/s7.png"));
        galleryModels.add(new GalleryModel("https://epiphytic-aluminums.000webhostapp.com/s8.png"));
        galleryModels.add(new GalleryModel("https://epiphytic-aluminums.000webhostapp.com/s9.png"));
        galleryModels.add(new GalleryModel("https://epiphytic-aluminums.000webhostapp.com/s10.png"));

    }
}