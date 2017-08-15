package com.oohyugi.teststickear.repo;

import com.oohyugi.teststickear.api.ApiClient;
import com.oohyugi.teststickear.model.VehicleModel;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by oohyugi on 8/15/17.
 */

public class VehicleRepoImpl extends BaseRequest implements VehicleRepoRequest {


    public VehicleRepoImpl(ApiClient mApiClient) {
        super(mApiClient);
    }

    @Override
    public Observable<List<VehicleModel>> getAllVehicle() {
        return mApiClient.getmApiService().getAllVehicles().map(new Func1<List<VehicleModel>, List<VehicleModel>>() {
            @Override
            public List<VehicleModel> call(List<VehicleModel> vehicleModels) {
                return vehicleModels;
            }
        });
    }
}
