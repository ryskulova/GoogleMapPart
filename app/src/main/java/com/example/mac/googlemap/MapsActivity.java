package com.example.mac.googlemap;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static android.R.string.yes;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private int tabCount;
    private int mIcon;
    private TabLayout tabLayout;
    private TabItem firstTab,secondTab, thirdTab, fourTab;
    private GoogleMap mMap, mMap1;
    private Button voiceRecorder;


    private ArrayList<MyMarker> mMyMarkersArray = new ArrayList<MyMarker>();
    private HashMap<Marker, MyMarker> mMarkersHashMap;


    private ArrayList<LatLng> places = new ArrayList<>();
    SharedPreferences.Editor edit;
    int index = 0;
    SharedPreferences local;
    int sizeOfPlaces;

    String latt;
    String lngg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setTabTextColors(Color.RED,Color.WHITE);
        firstTab = (TabItem) findViewById(R.id.tabItem1);
        secondTab = (TabItem) findViewById(R.id.tabItem2);
        thirdTab = (TabItem) findViewById(R.id.tabItem3);
        fourTab = (TabItem) findViewById(R.id.tabItem4);
       // getItem(firstTab);

        local = getPreferences(MODE_PRIVATE);
        edit = local.edit();
        edit.remove("sizeOfPlaces");
        edit.clear();
        sizeOfPlaces = local.getInt("sizeOfPlaces", 0);
    }

    private void plotMarkers(ArrayList<MyMarker> markers)
    {
        if(markers.size() > 0)
        {
            for (MyMarker myMarker : markers)
            {

                // Create user marker with custom icon and other options
                MarkerOptions markerOption = new MarkerOptions().position(new LatLng(myMarker.getmLatitude(), myMarker.getmLongitude()));
             //   markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.currentlocation_icon));

                Marker currentMarker = mMap.addMarker(markerOption);
                mMarkersHashMap.put(currentMarker, myMarker);


            }
        }

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng bishkek = new LatLng(42.8746, 74.5698);
        LatLng journalist = new LatLng(42.8345, 74.5555);
        LatLng photographer = new LatLng(43.8744, 74.5677);
        LatLng bloger = new LatLng(42.7563, 74.4763);
        LatLng videoMaker = new LatLng(42.4637, 74.1322);
        LatLng journalist1 = new LatLng(41.4274,75.9862);
        LatLng journalist2 = new LatLng(41.1234, 75.1324);
        LatLng journalist3 = new LatLng(41.4563, 75.4634);
        LatLng journalist4 = new LatLng(41.7893, 75.5748);
        LatLng journalist5 = new LatLng(41.7893, 75.5748);
        LatLng journalist6 = new LatLng(42.7893, 77.5748);
        LatLng journalist7 = new LatLng(42.7486, 77.3724);
        LatLng photographer1 = new LatLng(42.1234, 77.1234);
        LatLng journalist8 = new LatLng(39.9721, 69.8597);
        LatLng journalist9 = new LatLng(39.3732, 69.1635);
        LatLng photographer10 = new LatLng(39.3892, 69.1735);
        LatLng photographer11 = new LatLng(39.7563, 69.0597);
        LatLng photographer12 = new LatLng(40.5140, 72.8161);
        LatLng photographer13 = new LatLng(40.5453, 72.8854);
        LatLng photographer14 = new LatLng(40.5873, 72.8966);
        LatLng photographer15 = new LatLng(40.1425, 72.3733);
        LatLng bloger1 = new LatLng(40.5140, 72.8161);



        edit.putInt("sizeOfPlaces", places.size());
        mMap.addMarker(new MarkerOptions().position(bishkek).title("Azat Ruziev").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.addMarker(new MarkerOptions().position(journalist).title("Lex Titova").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(photographer).title("Vitali Kulishov").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(bloger).title("Zhama Ryskulova").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.addMarker(new MarkerOptions().position(videoMaker).title("Arsenyi, Kloop").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mMap.addMarker(new MarkerOptions().position(journalist1).title("Адилет, Баетово").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(journalist2).title("Чынара,Нарын").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(journalist3).title("Гульбарчын,Нарын").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(journalist4).title("Самара,Нарын").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(journalist5).title("Айзат,Нарын").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(journalist6).title("Гульзат,Иссык-куль").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(journalist7).title("Ибраим,Иссык-куль").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.addMarker(new MarkerOptions().position(photographer1).title("Адилет Альчиев,Иссык-куль").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(journalist8).title("Бахром Рахманкулов,Баткен").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(journalist9).title("Икбол Асабеков,Араван").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.addMarker(new MarkerOptions().position(photographer10).title("Камбар,Андарек").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.addMarker(new MarkerOptions().position(photographer11).title("Сухроб,Араван").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.addMarker(new MarkerOptions().position(photographer12).title("Бермет,Баткен").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.addMarker(new MarkerOptions().position(photographer13).title("Нуртаза,Кульдхерен").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(photographer14).title("Ахыбай,Ош").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.addMarker(new MarkerOptions().position(photographer15).title("Хамудулло,Ош").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.addMarker(new MarkerOptions().position(bloger1).title("").icon((BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))));



        mMap.moveCamera(CameraUpdateFactory.newLatLng(bishkek));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        // mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(fromPosition, getMaxZoomLevel()));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bishkek, 5));
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        //  mMap.addMarker(new MarkerOptions().position(random).title("Marker in random"));

        int indexSaved = 0;
        for (int i = 5; i < sizeOfPlaces; i++) {
            Float lat = local.getFloat(Integer.toString(indexSaved), 1);
            Log.d("First tag", Integer.toString(indexSaved));
            Log.d("First float", Float.toString(lat));
            indexSaved++;
            Float lng = local.getFloat(Integer.toString(indexSaved), 0);
            Log.d("Second tag", Integer.toString(indexSaved));
            Log.d("Second float", Float.toString(lng));
            indexSaved++;
            LatLng tempMarker = new LatLng(lat, lng);
            places.add(tempMarker);
          //  mMap.addMarker(new MarkerOptions().position(tempMarker).title("Журналист"));

        }

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                places.add(latLng);
                mMap.addMarker(new MarkerOptions().position(latLng).title("Журналист"));

                edit.putInt("sizeOfPlaces", places.size());
                latt = Double.toString(latLng.latitude);
                lngg = Double.toString(latLng.longitude);
                Float lat = Float.parseFloat(Double.toString(latLng.latitude));
                Float lng = Float.parseFloat(Double.toString(latLng.longitude));
                Log.d("Latitude to be saved", Float.toString(lat));
                Log.d("Longitude to be saved", Float.toString(lng));

                edit.putFloat(Integer.toString(index), lat);
                Log.d("First tag", Integer.toString(index));
                index++;

                edit.putFloat(Integer.toString(index), lng);
                Log.d("Second tag", Integer.toString(index));
                index++;
            }
        });


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                showDialog();
            }
        });
    }

    public void showDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        LayoutInflater factory = LayoutInflater.from(MapsActivity.this);
        final View view = factory.inflate(R.layout.sample, null);

        alert.setView(view);
        alert.setPositiveButton("Связаться!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dlg, int sumthin) {
                Intent intent = new Intent(MapsActivity.this, TasksActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }



    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
               firstTab.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(MapsActivity.this, TabActivity.class);
                       startActivity(intent);
                   }
               });
            case 1:
                secondTab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MapsActivity.this, ProfileActivity.class);
                        startActivity(intent);
                    }
                });

            case 2:
                thirdTab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MapsActivity.this, TasksActivity.class);
                        startActivity(intent);
                    }
                });
            case 3:
                fourTab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MapsActivity.this, HistoryActivity.class);
                        startActivity(intent);
                    }
                });

            default:
                return null;
        }
    }


}

