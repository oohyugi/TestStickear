package com.oohyugi.teststickear.repo;

import com.oohyugi.teststickear.api.ApiClient;

public class BaseRequest {
    public ApiClient mApiClient;

    public BaseRequest(ApiClient mApiClient) {
        this.mApiClient = mApiClient;
    }



}