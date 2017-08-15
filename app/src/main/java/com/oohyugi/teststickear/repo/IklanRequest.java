package com.oohyugi.teststickear.repo;

import com.oohyugi.teststickear.model.IklanModel;

import java.util.List;

import rx.Observable;

/**
 * Created by oohyugi on 8/15/17.
 */

public interface IklanRequest {
    Observable<List<IklanModel>> getAllIklan();
}
