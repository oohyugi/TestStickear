package com.oohyugi.teststickear.core;

import android.Manifest;
import android.app.ProgressDialog;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.oohyugi.teststickear.R;
import com.oohyugi.teststickear.model.IklanModel;
import com.oohyugi.teststickear.model.VehicleModel;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements MainView, EasyPermissions.PermissionCallbacks {

    MainPresenter presenter;
    ViewPager viewPager;
    CirclePageIndicator pageIndicator;
    RecyclerView rvVehicles;
    IklanFragmentPagerAdapter pagerAdapter;
    VehiclesAdapter vehiclesAdapter;
    List<IklanModel> iklanModelList = new ArrayList<>();
    List<VehicleModel> vehicleModels = new ArrayList<>();
    ProgressDialog mProgressDialog;
    private static final int RC_LOCATION_PERM = 999;
    private static final int RC_SETTINGS_SCREEN = 125;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        rvVehicles = (RecyclerView) findViewById(R.id.rvVehicles);
        viewPager = (ViewPager) findViewById(R.id.pager);
        pageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        rvVehicles.setLayoutManager(new LinearLayoutManager(this));
        presenter.getAllVehicle();
        presenter.getAlliklan();
        thisCheckPermission();

    }

    @AfterPermissionGranted(RC_LOCATION_PERM)
    private void thisCheckPermission() {

        if (EasyPermissions.hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION)) {


        } else {
            // Ask for one permission
            EasyPermissions.requestPermissions(this, "Aplikasi membutuhkan akses lokasi",
                    RC_LOCATION_PERM, Manifest.permission.ACCESS_FINE_LOCATION);

        }

    }

    @Override
    public void onsuccesLoadedVehicle(List<VehicleModel> vehicleModels) {
        this.vehicleModels.addAll(vehicleModels);
        vehiclesAdapter = new VehiclesAdapter(this, vehicleModels);
        rvVehicles.setAdapter(vehiclesAdapter);
        vehiclesAdapter.notifyDataSetChanged();


    }

    @Override
    public void onsuccesLoadedIklan(List<IklanModel> iklanModels) {
        Log.e("onsuccesLoadedIklan: ", new Gson().toJson(iklanModels));
        iklanModelList.addAll(iklanModels);
        pagerAdapter = new IklanFragmentPagerAdapter(getSupportFragmentManager(), iklanModelList);
        viewPager.setAdapter(pagerAdapter);
        pageIndicator.setViewPager(viewPager);

    }

    @Override
    public void showError(String message) {
        mProgressDialog.dismiss();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mProgressDialog = ProgressDialog.show(this, null, "Please wait..");

    }

    @Override
    public void stopLoading() {
        mProgressDialog.dismiss();

    }




    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Log.d("onPermissionsGranted:", requestCode + ":" + perms.size());

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.d("onPermissionsDenied:", requestCode + ":" + perms.size());
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this, "This app may not work correctly without the requested permissions. Open the app settings screen to modify app permissions.")
                    .setTitle("Permissions Required")
                    .setPositiveButton("Goto Settings")
                    .setNegativeButton("Cancel", null /* click listener */)
                    .setRequestCode(RC_SETTINGS_SCREEN)
                    .build()
                    .show();
        }

    }
}
