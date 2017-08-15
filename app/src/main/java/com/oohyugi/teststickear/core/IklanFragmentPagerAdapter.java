package com.oohyugi.teststickear.core;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.oohyugi.teststickear.model.IklanModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oohyugi on 8/15/17.
 */

public class IklanFragmentPagerAdapter extends FragmentPagerAdapter {
    List<IklanModel> list  =new ArrayList<>();
    public IklanFragmentPagerAdapter(FragmentManager fm, List<IklanModel> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return IklanFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
