package br.com.simplelife.testgooglemaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mapType(View view){
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
        finish();
    }

    public void flyTo(View view){
        startActivity(new Intent(MainActivity.this, MapsCameraActivity.class));
        finish();
    }

    public void goToStreetView(View view){
        startActivity(new Intent(MainActivity.this, MapsStreetView.class));
        finish();
    }


}
