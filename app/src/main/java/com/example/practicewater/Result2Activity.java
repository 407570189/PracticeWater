package com.example.practicewater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Result2Activity extends AppCompatActivity {
    private static final float DEFAULT_FEE =-1;
    private static final String TAG =Result2Activity.class.getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        Intent intent =getIntent();
        double outcome=intent.getDoubleExtra("fee",DEFAULT_FEE);
        Log.d(TAG ,outcome+"");
        TextView textView=findViewById(R.id.fee);
        int n=(int)(outcome+0.5);
        textView.setText(n+"");
    }
}
