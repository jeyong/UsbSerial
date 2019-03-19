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

    /*
    ToDo:
     * command 만드는 방법
     * inputstream을 mavlink 메시지로 만들기
     * 현재 상태를 나타내는 struct나 class를 어떻게 저장할 것인가?
     * instance를 만들고 거기에 복사해 놓고 access하는 방법은?
     * 정보를 받는 경우 : update로 받는 경우와 get하는 것은 분리가 필요해 보인다. 왜??
     */
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
