package edu.orangecoastcollege.cs273.caffeinefinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class LocationDetailsActivity extends AppCompatActivity implements OnMapReadyCallback{

    private Location selectedLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        // Map Fragment


        TextView locationNameTextView = (TextView) findViewById(R.id.locationNameTextView);
        TextView locationAddressTextView = (TextView) findViewById(R.id.locationAddressTextView);
        TextView locationCityStateZipTextView = (TextView) findViewById(R.id.locationCityStateZipTextView);
        TextView locationPhoneTextView = (TextView) findViewById(R.id.locationPhoneTextView);
        TextView locationLatLngTextView = (TextView) findViewById(R.id.locationLatLngTextView);

        selectedLocation = getIntent().getExtras().getParcelable("SelectedLocation");

        locationNameTextView.setText(selectedLocation.getName());
        locationAddressTextView.setText(selectedLocation.getAddress());

        String cityStateZipString = selectedLocation.getCity();
        cityStateZipString += ", " + selectedLocation.getState();
        cityStateZipString += " " + selectedLocation.getZipCode();
        locationCityStateZipTextView.setText(cityStateZipString);

        locationPhoneTextView.setText(selectedLocation.getPhone());

        String longitudeTextString = String.valueOf(selectedLocation.getLongitude() + "N");
        String latitudeTextString = String.valueOf(selectedLocation.getLatitude() + "W");

        locationLatLngTextView.setText(longitudeTextString + " " + latitudeTextString);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
