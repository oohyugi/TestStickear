package com.oohyugi.teststickear;

import rx.Subscriber;

/**
 * Created by oohyugi on 8/15/17.
 */

public abstract class BaseSubsriber<T>  extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onError(e.getMessage());
    }

    protected abstract void onError(String message);

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    protected abstract void onSuccess(T t);
}
