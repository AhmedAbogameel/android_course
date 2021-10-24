package com.example.android_course;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.example.android_course.data.WebServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;
    private final int LOCATION_PERMISSION_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_PERMISSION_CODE);
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Handle if User Deny permissions
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        TextView locationTV = findViewById(R.id.locationTV);
        TextView responseTV = findViewById(R.id.responseTV);
        TextView gradeTV = findViewById(R.id.gradeTV);

        locationTV.setText("Latitude : " + location.getLatitude() + "\nLongitude : " + location.getLongitude());

        Call<Map<Object, Object>> response = WebServiceClient.getINSTANCE().getWeather(location.getLatitude(), location.getLongitude());
        response.enqueue(new Callback<Map<Object, Object>>() {
            @Override
            public void onResponse(Call<Map<Object, Object>> call, Response<Map<Object, Object>> response) {
                System.out.println(response.body());
                responseTV.setText(response.body().toString());
                Map<Object, Object> result = (Map<Object, Object>) response.body().get("main");
                gradeTV.setText(result.get("temp").toString());
            }

            @Override
            public void onFailure(Call<Map<Object, Object>> call, Throwable t) {
                System.out.println(t.toString());
            }
        });
    }

}