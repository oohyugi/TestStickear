package com.oohyugi.teststickear.core;

/**
 * Created by oohyugi on 8/15/17.
 */

public class BasePresenter<V> {
    protected V mView;


    public BasePresenter(V mView) {
        this.mView = mView;
    }
}
