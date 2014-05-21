package com.example.bluetoothpractice.app;

/**
 * Created by sbastin on 4/8/14.
 */
public class BluetoothModel
{
    private String mName;
    private String mAddress;

    BluetoothModel(String name, String address)
    {
        mName = name;
        mAddress = address;
    }

    public void setmAddress(String mAddress) {this.mAddress = mAddress;}
    public String getmAddress() {return mAddress;}

    public void setmName(String mName) {this.mName = mName;}
    public String getmName() {return mName;}
}
