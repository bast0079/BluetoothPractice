package com.example.bluetoothpractice.app;

import android.app.Activity;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.ParcelUuid;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class SendStuffActivity extends Activity {

   public Button sendFile;
   BluetoothSocket socket;
   BluetoothAdapter myBluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_stuff);
        initWidgets();
        setListeners();

    }

    private void setListeners()
    {
        sendFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendStuff("blah");
            }
        }

        );
    }



    private void initWidgets()
    {
        sendFile = (Button)findViewById(R.id.button_send_file);
    }

    private void sendStuff(String address)
    {


        BluetoothDevice device = myBluetoothAdapter.getRemoteDevice(address);
        BluetoothSocket clientSocket;

        try
        {
            ParcelUuid[] uuids = device.getUuids();
            boolean isFileTransferSupported = false;
            UUID ftpUUID = UUID.fromString("00001106-0000-1000-8000-00805F9B34FB");

            for (ParcelUuid parcelUuid: uuids)
            {
                if(parcelUuid.getUuid().equals(ftpUUID))
                {
                    isFileTransferSupported = true;
                    break;


                }
            }

            if(!isFileTransferSupported)
            {
                return;
            }

            clientSocket = device.createRfcommSocketToServiceRecord(ftpUUID);
            clientSocket.connect();




        }catch(IOException e)
        {
            e.printStackTrace();
        }
        byte[] toSend = message.getBytes();
        try
        {
            OutputStream out = socket.getOutputStream();
            out.write(toSend);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.send_stuff, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
