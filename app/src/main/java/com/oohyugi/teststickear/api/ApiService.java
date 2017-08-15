package com.oohyugi.teststickear.api;

import com.oohyugi.teststickear.model.IklanModel;
import com.oohyugi.teststickear.model.VehicleModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by oohyugi on 8/15/17.
 */

public interface ApiService {
    @GET("vehicles")
    Observable<List<VehicleModel>> getAllVehicles();
    @GET("iklan")
    Observable<List<IklanModel>> getAllIklans();
}
