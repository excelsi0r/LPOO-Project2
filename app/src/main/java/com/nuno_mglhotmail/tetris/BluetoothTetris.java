package com.nuno_mglhotmail.tetris;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class BluetoothTetris extends Activity implements View.OnClickListener
{

    private final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_FULLSCREEN
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

    private BluetoothAdapter bt;
    private BluetoothDevice bd;
    private BluetoothService service;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_config);
        //getWindow().getDecorView().setSystemUiVisibility(flags);

        TextView tx = (TextView) findViewById(R.id.bluetoothconfigtxt);

        bt = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> devices = bt.getBondedDevices();

        for (BluetoothDevice device1 : devices)
        {
            tx.append("\n" + device1.getName() + " " + device1.getBondState() + " " + device1.getUuids());
            bd = device1;
        }

        service = new BluetoothService(this);
        service.connect(bd, true);
        while(service.getState()!= BluetoothService.STATE_CONNECTED)
        {

        }

        Toast.makeText(this, "CONECTOU!", Toast.LENGTH_LONG).show();

        Button test = (Button) findViewById(R.id.test);
        test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.test:
            {
                byte[] b;
                String s = "writing here";
                b = s.getBytes();
                service.write(b);
            }


        }
    }

}
