package com.oohyugi.teststickear.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.oohyugi.teststickear.R;
import com.oohyugi.teststickear.model.IklanModel;
import com.squareup.picasso.Picasso;

/**
 * Created by oohyugi on 8/15/17.
 */

public class IklanFragment extends Fragment {

    private static final String IKLAN_MODEL ="iklan" ;
    IklanModel iklanModel;

    public static IklanFragment newInstance(IklanModel mData) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(IKLAN_MODEL, mData);
        IklanFragment fragment = new IklanFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    ImageView imageView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iklanModel = (IklanModel) getArguments().getSerializable(IKLAN_MODEL);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.iklan_fragment,container,false);
      imageView = (ImageView) view.findViewById(R.id.imgIklan);
        Log.e( "onCreateView: ",iklanModel.getImage() );
        Picasso.with(getActivity()).load(iklanModel.getImage()).fit().centerCrop().into(imageView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

    }
}
