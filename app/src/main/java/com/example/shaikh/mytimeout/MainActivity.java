package com.example.shaikh.mytimeout;

import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView statusTextView = (TextView) findViewById(R.id.status_text);
        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.button);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT,30000000);
                    Toast.makeText(getApplicationContext(),"Development Mode on",Toast.LENGTH_SHORT).show();
                    statusTextView.setTextColor(Color.parseColor("#008000"));
                    toggleButton.setBackgroundColor(Color.parseColor("#008000"));
                    statusTextView.setText(getResources().getString(R.string.status_development_text));
                    toggleButton.setText(getResources().getString(R.string.button_on_text));
                }else{
                    Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT,120000);
                    Toast.makeText(getApplicationContext(),"Development Mode Off",Toast.LENGTH_SHORT).show();
                    statusTextView.setTextColor(Color.parseColor("#ff0000"));
                    toggleButton.setBackgroundColor(Color.parseColor("#ff0000"));
                    statusTextView.setText(getResources().getString(R.string.status_roaming_text));
                    toggleButton.setText(getResources().getString(R.string.button_off_text));

                }
            }
        });

    }
}
