package kr.hs.s2104.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    EditText editName, editWeight, editHeight;
    TextView textComment;
    Button btnHome;
    ImageView imgBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(btnListener);

        imgBmi = findViewById(R.id.img_bmi);
        textComment = findViewById(R.id.comment);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        double weight= Double.parseDouble(intent.getStringExtra("weight"));
        double height= Double.parseDouble(intent.getStringExtra("height"));
        double bmi = weight / Math.pow(height/100, 2);
        String bmiResult;

        if(bmi<18.5) {
            bmiResult = "저체중";
            imgBmi.setImageResource(R.drawable.bmi_01);
        }
        else if(bmi<24.9){
            bmiResult = "정상";
            imgBmi.setImageResource(R.drawable.bmi_02);
        }
        else if(bmi<28){
            bmiResult = "과체중";
            imgBmi.setImageResource(R.drawable.bmi_03);
        }
        else{
            bmiResult = "비만";
            imgBmi.setImageResource(R.drawable.bmi_04);
        }
        textComment.setText(name+"님의 BMI 지수는 "+bmi+"입니다. 따라서 "+bmiResult+"입니다.");

    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}