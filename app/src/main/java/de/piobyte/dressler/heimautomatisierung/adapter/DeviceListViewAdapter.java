package de.piobyte.dressler.heimautomatisierung.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import de.piobyte.dressler.heimautomatisierung.R;
import de.piobyte.dressler.heimautomatisierung.model.hADevice;
import de.piobyte.dressler.heimautomatisierung.model.hAGroup;

/**
 * Created by Piobyte-Gast on 19.09.2017.
 */

public class DeviceListViewAdapter extends RecyclerView.Adapter<DeviceListViewViewHolders> {
    private List<hADevice> itemList;
    private Context mContext;
    private int layout;

    public DeviceListViewAdapter(Context context, int layout, List<hADevice> itemList) {
        this.itemList = itemList;
        this.mContext = context;
        this.layout = layout;
    }

    @Override
    public DeviceListViewViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(layout, null);
        return new DeviceListViewViewHolders(layoutView);

    }

    @Override
    public void onBindViewHolder(DeviceListViewViewHolders holder, int position) {
        holder.deviceName.setText(itemList.get(position).getName());
        holder.deviceDescription.setText(itemList.get(position).getFriendlyName());
        holder.deviceImage.setBackgroundResource(itemList.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}

