package com.example.vibration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrate(1000);
            }
        });

    }
    private void Vibrate(long millisecond){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            ((Vibrator)getSystemService(VIBRATOR_SERVICE))
                    .vibrate(VibrationEffect.createOneShot(millisecond, VibrationEffect.DEFAULT_AMPLITUDE));
        }
        else {
            ((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(millisecond);
        }
    }
}