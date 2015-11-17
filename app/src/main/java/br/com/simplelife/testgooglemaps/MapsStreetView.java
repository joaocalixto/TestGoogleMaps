package br.com.simplelife.testgooglemaps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/**
 * Created by JoaoCalixto on 17/11/2015.
 */
public class MapsStreetView extends FragmentActivity implements OnStreetViewPanoramaReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportStreetViewPanoramaFragment streetViewPanoramaFragment = (SupportStreetViewPanoramaFragment) getSupportFragmentManager().findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
    }


    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setPosition(new LatLng(36.0579667, -112.1430996));
        StreetViewPanoramaCamera streetViewPanoramaCamera = new StreetViewPanoramaCamera.Builder().bearing(180).build();
        streetViewPanorama.animateTo(streetViewPanoramaCamera, 1000);
//        streetViewPanorama.animateTo(streetViewPanoramaCamera,);

    }
}
