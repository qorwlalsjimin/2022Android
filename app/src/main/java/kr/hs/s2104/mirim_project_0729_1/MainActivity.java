package kr.hs.s2104.mirim_project_0729_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        btnPlus = findViewById(R.id.btn_plus);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("edit1", Integer.parseInt(edit1.getText().toString()));
                intent.putExtra("edit2", Integer.parseInt(edit2.getText().toString()));
                startActivityForResult(intent, 0);
            }
        });
    }//OnCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            int sum = data.getIntExtra("sum", 0);
            Toast.makeText(getApplicationContext(), "덧셈결과"+sum, Toast.LENGTH_LONG).show();
        }
    }
}