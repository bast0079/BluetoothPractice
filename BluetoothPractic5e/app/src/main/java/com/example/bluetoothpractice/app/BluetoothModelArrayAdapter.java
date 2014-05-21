package com.example.bluetoothpractice.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sbastin on 4/9/14.
 */
public class BluetoothModelArrayAdapter extends ArrayAdapter<BluetoothModel>
{
    public BluetoothModelArrayAdapter(Context context, ArrayList<BluetoothModel> devices)
    {
        super(context, R.layout.item_model, devices);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        BluetoothModel device = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_model, null);

        TextView bluetoothName = (TextView) convertView.findViewById(R.id.deviceName);
        TextView bluetoothAddress = (TextView)convertView.findViewById(R.id.deviceAddress);

        bluetoothName.setText(device.getmName());
        bluetoothAddress.setText(device.getmAddress());

        return convertView;
    }
}
