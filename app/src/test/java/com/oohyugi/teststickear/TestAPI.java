package com.oohyugi.teststickear;

import android.util.Log;

import com.google.gson.Gson;
import com.oohyugi.teststickear.api.ApiClient;
import com.oohyugi.teststickear.model.IklanModel;
import com.oohyugi.teststickear.model.VehicleModel;
import com.oohyugi.teststickear.repo.IklanImpl;
import com.oohyugi.teststickear.repo.IklanRequest;
import com.oohyugi.teststickear.repo.VehicleRepoImpl;
import com.oohyugi.teststickear.repo.VehicleRepoRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by oohyugi on 8/15/17.
 */

public class TestAPI {
    @Mock
    ApiClient mApiClient;
    @Mock
    VehicleRepoRequest repoRequest;

    @Mock
    IklanRequest iklanRequest;

    @Before
    public void setup(){
        mApiClient = new ApiClient();
        repoRequest = new VehicleRepoImpl(mApiClient);
        iklanRequest = new IklanImpl(mApiClient);


    }
    @Test
    public void getAllVehicle(){
        repoRequest.getAllVehicle().subscribe(new Action1<List<VehicleModel>>() {
            @Override
            public void call(List<VehicleModel> vehicleModels) {

                    Assert.assertNotNull(vehicleModels.size()>0);

            }
        });



    }

    @Test
    public void getAllIklan() {
        iklanRequest.getAllIklan().subscribe(new Action1<List<IklanModel>>() {
            @Override
            public void call(List<IklanModel> vehicleModels) {

                Assert.assertNotNull(vehicleModels.size() > 0);

            }
        });
    }
}
