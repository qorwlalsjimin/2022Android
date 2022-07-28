package kr.hs.s2104.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnResult;
    EditText edit_name, edit_weight, edit_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnResult = findViewById(R.id.btn_result);
        btnResult.setOnClickListener(btnListener);

        edit_name = findViewById(R.id.edit_name);
        edit_weight = findViewById(R.id.edit_weight);
        edit_height = findViewById(R.id.edit_height);

    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("name", edit_name.getText().toString());
            intent.putExtra("weight", edit_weight.getText().toString());
            intent.putExtra("height", edit_height.getText().toString());
            startActivity(intent);
        }
    };
}