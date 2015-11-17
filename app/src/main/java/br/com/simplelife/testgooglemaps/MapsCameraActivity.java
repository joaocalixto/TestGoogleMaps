package br.com.simplelife.testgooglemaps;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsCameraActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MarkerOptions marketTest;

    static final CameraPosition NEWYORK = CameraPosition.builder()
            .target(new LatLng(40.784,-73.9857))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204,-122.3491))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition DUBLIN = CameraPosition.builder()
            .target(new LatLng(53.3478,-6.2597))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_camera);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        marketTest = new MarkerOptions().
                position(new LatLng(40.784, -73.9857))
                .title("Rink").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_rink));


        mapFragment.getMapAsync(this);
    }

    public void toNewYork(View v){
        changeMapTypeTo(NEWYORK);
    }

    public void toSeattle(View v){
        changeMapTypeTo(SEATTLE);
    }

    public void toBulin(View v){
        changeMapTypeTo(DUBLIN);
    }

    public void changeMapTypeTo(CameraPosition target){
        if(mMap != null)
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
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
        mMap.addMarker(marketTest);

        Circle circle = mMap.addCircle(new CircleOptions()
                .center(new LatLng(40.784, -73.9857))
                .radius(50)
                .strokeColor(Color.RED));

        // (-7.996928, -34.860721) Home
        // Add a marker in Sydney and move the camera
      //  LatLng newYork = new LatLng(-7.996928, -34.860721);
       // CameraPosition target = CameraPosition.builder().target(newYork).zoom(14).build();
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
       // mMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
