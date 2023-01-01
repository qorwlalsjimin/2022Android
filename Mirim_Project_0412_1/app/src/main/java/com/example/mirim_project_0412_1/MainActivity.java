package com.example.mirim_project_0412_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1 = findViewById(R.id.text1);
        TextView t2 = findViewById(R.id.text2);
        TextView t3 = findViewById(R.id.text3);

        t1.setText("빨간색 글자 TextView");
        t1.setTextColor(Color.rgb(255,0,0));

        t2.setTextSize(30);
        t2.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);

        t3.setText("안드로이드 기초 B반 강좌 방과후 학교안드로이드 기초 B반 강좌 방과후 학교안드로이드 기초 B반 강좌 방과후 학교");
        t3.setSingleLine(true);
    }
}