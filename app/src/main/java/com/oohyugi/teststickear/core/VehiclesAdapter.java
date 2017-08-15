package com.oohyugi.teststickear.core;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oohyugi.teststickear.R;
import com.oohyugi.teststickear.model.VehicleModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oohyugi on 8/15/17.
 */
public class VehiclesAdapter extends
        RecyclerView.Adapter<VehiclesAdapter.ViewHolder> {

    private static final String TAG = VehiclesAdapter.class.getSimpleName();

    private Context context;
    private List<VehicleModel> list;
    public VehiclesAdapter(Context context, List<VehicleModel> list) {
        this.context = context;
        this.list = list;

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        TextView tvDrivers;
        TextView tvNumber;
        public ViewHolder(View itemView) {
            super(itemView);
          tvDrivers = (TextView)itemView.findViewById(R.id.tvDrivers);
          tvNumber = (TextView)itemView.findViewById(R.id.tvNumber);


        }


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.vehicles_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VehicleModel item = list.get(position);
        holder.tvDrivers.setText(item.getDrivers());
        holder.tvNumber.setText(item.getVehicles_number());


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


}