package co.id.myselfapp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import co.id.myselfapp.dialog.CustomDialogClass;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageView ig,fb,email,github;
    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        // Inflate the layout for this fragment
        TextView my_desc = v.findViewById(R.id.my_desc_profile);
        ig = v.findViewById(R.id.txt_instagram);
        fb = v.findViewById(R.id.txt_facebook);
        email = v.findViewById(R.id.txt_email);
        github = v.findViewById(R.id.txt_github);
        Button version = v.findViewById(R.id.openversion);
        version.setOnClickListener(v1 -> {
            CustomDialogClass cdd=new CustomDialogClass(getActivity());
            cdd.show();
        });

        email.setOnClickListener(v1 -> {
            try {
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "f.syafalik@gmail.com"));
//                intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
//                intent.putExtra(Intent.EXTRA_TEXT, "your_text");
                startActivity(intent);
            } catch (ActivityNotFoundException e){
                //TODO smth
            }
        });
        ig.setOnClickListener(v1 -> {
            String url = "https://www.instagram.com/fakihsyafalik/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        fb.setOnClickListener(v1 -> {

            String url = "https://www.facebook.com/fakihsyafalik/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

        github.setOnClickListener(v1 -> {

            String url = "https://github.com/ProBeast26/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        FloatingActionButton tomyloc = v.findViewById(R.id.to_my_loc);
        String html = "Hello saya Fakih Syafalik </b><br/>Saya merupakan mahasiswa dari Indonesian Computer University and majoring in informatics engineering";
        my_desc.setText(HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY));
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.my_maps_profile);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng latlng = new LatLng(32.3917,115.867);
                LatLng myloc = new LatLng(-6.889584, 107.621201);


                googleMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myloc,18));

                googleMap.addMarker(new
                        MarkerOptions().position(myloc).title("My Home"));
                tomyloc.setOnClickListener(v1 -> {
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myloc,18));
                });
            }
        });


        return v;
    }
    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        // below line is use to generate a drawable.
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        int height = 100;
        int width = 100;
        // below line is use to set bounds to our vector drawable.
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());

        // below line is use to create a bitmap for our
        // drawable which we have added.
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        // below line is use to add bitmap in our canvas.
        Canvas canvas = new Canvas(bitmap);

        // below line is use to draw our
        // vector drawable in canvas.
        vectorDrawable.draw(canvas);

        // after generating our bitmap we are returning our bitmap.
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}