package com.jeyong.usbserial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.dronefleet.mavlink.MavlinkConnection;
import io.dronefleet.mavlink.MavlinkMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, UsbService.class);
        startService(intent);
    }

    public void getIn(){
        InputStream in = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };

        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                return ;
            }
        };

        MavlinkConnection connection = MavlinkConnection.create(in, out);
        MavlinkMessage message;

        try {
            message = connection.next();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
