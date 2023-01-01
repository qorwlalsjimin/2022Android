package kr.hs.s2104.mirim_project_0728_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingS, ratingM, ratingB;
    Button btnInc, btnDec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingS = findViewById(R.id.rating_small);
        ratingM = findViewById(R.id.rating_medium);
        ratingB = findViewById(R.id.rating_basic);

        btnInc = findViewById(R.id.btn_inc);
        btnDec = findViewById(R.id.btn_dec);

        btnInc.setOnClickListener(btnListener);
        btnDec.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_inc:
                    ratingS.setRating(ratingS.getRating()+ratingS.getStepSize());
                    ratingM.setRating(ratingM.getRating()+ratingM.getStepSize());
                    ratingB.setRating(ratingB.getRating()+ratingB.getStepSize());
                    break;
                case R.id.btn_dec:
                    ratingS.setRating(ratingS.getRating()-ratingS.getStepSize());
                    ratingM.setRating(ratingM.getRating()-ratingM.getStepSize());
                    ratingB.setRating(ratingB.getRating()-ratingB.getStepSize());
                    break;
            }
        }
    };
}