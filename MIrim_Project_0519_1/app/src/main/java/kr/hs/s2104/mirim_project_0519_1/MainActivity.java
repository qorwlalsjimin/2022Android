package kr.hs.s2104.mirim_project_0519_1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linear_red, linear_yellow, linear_blue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear_red = findViewById(R.id.linear_red);
        linear_yellow = findViewById(R.id.linear_yellow);
        linear_blue = findViewById(R.id.linear_blue);

        Button btnRed = findViewById(R.id.btn_red);
        Button btnYellow = findViewById(R.id.btn_yellow);
        Button btnBlue = findViewById(R.id.btn_blue);

        btnRed.setOnClickListener(btnListener);
        btnYellow.setOnClickListener(btnListener);
        btnBlue.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            linear_red.setVisibility(View.INVISIBLE);
            linear_yellow.setVisibility(View.INVISIBLE);
            linear_blue.setVisibility(View.INVISIBLE);
            switch(view.getId()){
                case R.id.btn_red:
                    linear_red.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_yellow:
                    linear_yellow.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_blue:
                    linear_blue.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}