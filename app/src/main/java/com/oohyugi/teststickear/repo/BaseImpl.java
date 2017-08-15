package com.oohyugi.teststickear.repo;

/**
 * Created by oohyugi on 8/15/17.
 */

public class BaseImpl<A> {
    protected A mApiClient;

    public BaseImpl(A mApiClient) {
        this.mApiClient = mApiClient;
    }
}
