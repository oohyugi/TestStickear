package com.oohyugi.teststickear.core;

import com.oohyugi.teststickear.model.IklanModel;
import com.oohyugi.teststickear.model.VehicleModel;

import java.util.List;

/**
 * Created by oohyugi on 8/15/17.
 */

public interface MainView {
    void onsuccesLoadedVehicle(List<VehicleModel> vehicleModels);

    void onsuccesLoadedIklan(List<IklanModel> iklanModels);

    void showError(String message);
    void showLoading();
    void stopLoading();
}
