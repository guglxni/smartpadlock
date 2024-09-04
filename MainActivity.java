package com.example.iotlock;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    // IP address of the ESP8266
    private static final String ESP8266_URL = "http://192.168.1.100";  // Replace with your ESP8266's IP

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lockButton = findViewById(R.id.lockButton);
        Button unlockButton = findViewById(R.id.unlockButton);

        // Lock Button
        lockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCommand("/lock"); // Send /lock command
            }
        });

        // Unlock Button
        unlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCommand("/unlock"); // Send /unlock command
            }
        });
    }

    // Function to send lock/unlock command to ESP8266
    private void sendCommand(final String command) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(ESP8266_URL + command);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.getResponseCode();  // Send request
                    urlConnection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
