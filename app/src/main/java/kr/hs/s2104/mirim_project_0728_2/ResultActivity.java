package kr.hs.s2104.mirim_project_0728_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textTitle = findViewById(R.id.text_title);
        ImageView imgFirst = findViewById(R.id.img_first);

        Intent intent = getIntent();
        String[] imgName = intent.getStringArrayExtra("imgName");
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        int[] imgRes = {R.drawable.boy01, R.drawable.boy02, R.drawable.boy03,R.drawable.boy04, R.drawable.boy05,R.drawable.boy06,R.drawable.boy07,R.drawable.boy08,R.drawable.boy09};

        TextView[] tv = new TextView[imgName.length];
        int[] textId = {R.id.text01, R.id.text02, R.id.text03,
                        R.id.text04, R.id.text05, R.id.text06,
                        R.id.text07, R.id.text08, R.id.text09};
        RatingBar[] rb = new RatingBar[voteCount.length];
        int[] rbId = {R.id.rb1, R.id.rb2, R.id.rb3,
                R.id.rb4, R.id.rb5, R.id.rb6,
                R.id.rb7, R.id.rb8, R.id.rb9};

        for(int i= 0; i<rb.length; i++){
            tv[i] = findViewById(textId[i]);
            rb[i] = findViewById(rbId[i]);
            tv[i].setText(imgName[i]);
            rb[i].setRating(voteCount[i]);
        }

        //버튼
        Button btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //이미지
        int voteMax = voteCount[0], voteMaxIndex = 0;
        for(int i = 0; i<voteCount.length; i++){
            if(voteMax < voteCount[i]) {
                voteMax = voteCount[i];
                voteMaxIndex = i;
            }
        }

        textTitle.setText(imgName[voteMaxIndex]);
        imgFirst.setImageResource(imgRes[voteMaxIndex]);

    }
}