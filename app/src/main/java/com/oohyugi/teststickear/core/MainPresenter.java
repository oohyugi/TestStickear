package com.oohyugi.teststickear.core;

import android.util.Log;

import com.oohyugi.teststickear.BaseSubsriber;
import com.oohyugi.teststickear.api.ApiClient;
import com.oohyugi.teststickear.model.IklanModel;
import com.oohyugi.teststickear.model.VehicleModel;
import com.oohyugi.teststickear.repo.IklanImpl;
import com.oohyugi.teststickear.repo.IklanRequest;
import com.oohyugi.teststickear.repo.VehicleRepoImpl;
import com.oohyugi.teststickear.repo.VehicleRepoRequest;


import java.util.List;

import rx.schedulers.Schedulers;

/**
 * Created by oohyugi on 8/15/17.
 */

public class MainPresenter extends BasePresenter<MainView> {

    ApiClient mApiClient;
    VehicleRepoRequest vehicleRepoRequest;
    IklanRequest iklanRequest;

    public MainPresenter(MainView mView) {
        super(mView);
        mApiClient = new ApiClient();
        iklanRequest = new IklanImpl(mApiClient);
        vehicleRepoRequest = new VehicleRepoImpl(mApiClient);
    }


    public void getAllVehicle() {
        mView.showLoading();
        vehicleRepoRequest.getAllVehicle().subscribeOn(Schedulers.newThread())
                .subscribe(new BaseSubsriber<List<VehicleModel>>() {
                    @Override
                    protected void onError(String message) {
                        Log.e("onError: ", message);
                        mView.showError(message);
                    }

                    @Override
                    protected void onSuccess(List<VehicleModel> vehicleModels) {
                        Log.e("onSuccess: ", "masuk");
                        mView.stopLoading();
                        mView.onsuccesLoadedVehicle(vehicleModels);
                    }
                });

    }

    public void getAlliklan() {
        iklanRequest.getAllIklan().subscribeOn(Schedulers.newThread())

                .subscribe(new BaseSubsriber<List<IklanModel>>() {
                    @Override
                    protected void onError(String message) {
                        Log.e("onError: ", message);
                        mView.showError(message);
                    }

                    @Override
                    protected void onSuccess(List<IklanModel> iklanModels) {
                        mView.onsuccesLoadedIklan(iklanModels);
                    }
                });

    }
}
