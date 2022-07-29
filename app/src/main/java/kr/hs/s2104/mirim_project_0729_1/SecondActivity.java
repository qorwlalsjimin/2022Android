package kr.hs.s2104.mirim_project_0729_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    int sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int num1 = intent.getIntExtra("edit1", 0);
        int num2 = intent.getIntExtra("edit2",0);

        sum = num1 + num2;
        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("sum", sum);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}