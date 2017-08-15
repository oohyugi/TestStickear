package com.oohyugi.teststickear.repo;

import com.oohyugi.teststickear.model.VehicleModel;

import java.util.List;

import rx.Observable;

/**
 * Created by oohyugi on 8/15/17.
 */

public interface VehicleRepoRequest {
    Observable<List<VehicleModel>> getAllVehicle();
}
