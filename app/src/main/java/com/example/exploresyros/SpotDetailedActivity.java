package com.example.exploresyros;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.FolderOverlay;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class SpotDetailedActivity extends AppCompatActivity {

    private String spotName;
    MapView map = null;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    Context mContext;

    private TextToSpeech textToSpeech;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots_detailed);
        //λειτούργια του toolbar, παίρνει δυναμικά τον τίτλο της κάρτα, και το back btn πηγαίνει στο mainpage
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView toolbarTitle = findViewById(R.id.toolbarTitle);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        ImageView btnBack = findViewById(R.id.btnBacktoolbar);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpotDetailedActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });


        mContext = this;
        Configuration.getInstance().load(mContext, PreferenceManager.getDefaultSharedPreferences(mContext));
        spotName = getIntent().getStringExtra(getString(R.string.intent_extra_spot_name));
        setTitle(spotName);
        SpotData spotData = new SpotData(getApplicationContext());
        Spot spot = spotData.getSpot(spotName);
        List<Pin> pins = spotData.getPinsForSpot(spotName);

        spot.setDescription(getString(spot.getDescriptionResourceId()));

        textToSpeech = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                Locale deviceLocale = getResources().getConfiguration().locale;

                if (deviceLocale.getLanguage().equals("el")) {
                    textToSpeech.setLanguage(new Locale("el", "GR"));
                } else {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

        inflateLayoutForSpot(spot);

        // Dynamically set the title of the Toolbar to match spot_name TextView
        toolbarTitle.setText(spot.getName());

        inflateLayoutForMap(pins);
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }
// δηλώνω views με τα id και πως παίρνουν δυναμικά το περιεχόμενο ανάλογα με τις κάρτες
    private void inflateLayoutForSpot(Spot spot) {
        ImageView itemImage = findViewById(R.id.spot_detail_img);
        itemImage.setImageResource(spot.getThumbnailResourceID());

        itemImage.setContentDescription(spot.getImageContentDescription());

        TextView spotNameTxtView = findViewById(R.id.spot_name);
        spotNameTxtView.setText(spot.getName());

        TextView spotOverview = findViewById(R.id.spot_overview);
        Log.d("SpotOverview", "Text: " + spot.getDescription());
        spotOverview.setText(spot.getDescription());

        ImageView imgtts = findViewById(R.id.imgtts);
        imgtts.setOnClickListener(view -> {
            String overviewToRead = spot.getDescription();
            if(!TextUtils.isEmpty(overviewToRead)){
                textToSpeech.speak(overviewToRead, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

    }
//set up του χάρτη
    private void inflateLayoutForMap(List<Pin> pins) {
        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);

        addMapFunctionality(pins);
        addPinsToMap(pins);
        getLocationPermission();
    }

    private void getLocationPermission() {
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};
        if (ContextCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_GRANTED) {
            setUserLocationEnabled();
        } else {
            ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                setUserLocationEnabled();
            }
        }
    }

    private void setUserLocationEnabled() {
        GpsMyLocationProvider gpsMyLocationProvider = new GpsMyLocationProvider(mContext);
        gpsMyLocationProvider.setLocationUpdateMinDistance(100);
        gpsMyLocationProvider.setLocationUpdateMinTime(10000);
        MyLocationNewOverlay mLocationOverlay = new MyLocationNewOverlay(gpsMyLocationProvider, map);
        mLocationOverlay.enableMyLocation();
        map.getOverlays().add(mLocationOverlay);
    }

    private void addPinsToMap(List<Pin> pins) {
        FolderOverlay pinMarkers = new FolderOverlay(this);
        map.getOverlays().add(pinMarkers);

        for (Pin pin : pins) {
            Marker pinMarker = new Marker(map);
            pinMarker.setTitle(pin.getTitle());
            pinMarker.setSnippet(pin.getTitle());
            pinMarker.setPosition(pin.getGeopoint());
            pinMarker.setIcon(getResources().getDrawable(pin.getPinResourceID()));
            pinMarker.setImage(getResources().getDrawable(pin.getImageResourceID()));
            pinMarkers.add(pinMarker);
        }
        map.invalidate();
    }

    private void addMapFunctionality(List<Pin> pins) {
        map.setMultiTouchControls(true);
        IMapController mapController = map.getController();
        mapController.setZoom(17);
        GeoPoint startPoint = computeCentralGeoPoint(pins);
        mapController.setCenter(startPoint);
        RotationGestureOverlay mRotationGestureOverlay = new RotationGestureOverlay(mContext, map);
        mRotationGestureOverlay.setEnabled(true);
        map.setMultiTouchControls(true);
        map.getOverlays().add(mRotationGestureOverlay);
        final DisplayMetrics dm = getResources().getDisplayMetrics();
        ScaleBarOverlay mScaleBarOverlay = new ScaleBarOverlay(map);
        mScaleBarOverlay.setCentred(false);
        mScaleBarOverlay.setScaleBarOffset(dm.widthPixels / 2, 10);
        map.getOverlays().add(mScaleBarOverlay);
        CompassOverlay mCompassOverlay = new CompassOverlay(mContext, new InternalCompassOrientationProvider(mContext), map);
        mCompassOverlay.enableCompass();
        map.getOverlays().add(mCompassOverlay);
    }

    public static GeoPoint computeCentralGeoPoint(List<Pin> pins) {
        double latTotal = 0;
        double lonTotal = 0;
        int totalGeoPoints = 0;

        for (Pin pin : pins) {
            latTotal += pin.getGeopoint().getLatitude();
            lonTotal += pin.getGeopoint().getLongitude();
            totalGeoPoints += 1;
        }

        if (totalGeoPoints != 0) {
            return new GeoPoint(latTotal / totalGeoPoints, lonTotal / totalGeoPoints);
        } else {
            return null;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(mContext));
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        Configuration.getInstance().save(mContext, prefs);
    }
}
