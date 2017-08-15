
package com.oohyugi.teststickear.repo;

import com.oohyugi.teststickear.api.ApiClient;
import com.oohyugi.teststickear.model.IklanModel;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by oohyugi on 8/15/17.
 */

public class IklanImpl extends BaseRequest implements IklanRequest {
    public IklanImpl(ApiClient mApiClient) {
        super(mApiClient);
    }

    @Override
    public Observable<List<IklanModel>> getAllIklan() {
        return mApiClient.getmApiService().getAllIklans().map(new Func1<List<IklanModel>, List<IklanModel>>() {
            @Override
            public List<IklanModel> call(List<IklanModel> iklanModels) {
                return iklanModels;
            }
        });
    }
}
