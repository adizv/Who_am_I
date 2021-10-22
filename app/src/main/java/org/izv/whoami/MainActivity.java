package org.izv.whoami;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getName() + "xyzyx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        try {
            String line;
            Process p = Runtime.getRuntime().exec("whoami");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                //System.out.println(line); //<-- Parse data here.
                Log.v(TAG, line);
            }
            input.close();
        } catch (Exception err) {
            Log.v(TAG, err.getLocalizedMessage());
            Log.v(TAG, err.toString());
        }
    }
}