package kr.hs.s2104.mirim_project_0729_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnCalc;
    RadioGroup radio;

    final static int PLUS = 0;
    final static int MINUS = 1;
    final static int MULTI = 2;
    final static int DIVIDE = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        btnCalc = findViewById(R.id.btn_calc);
        radio = findViewById(R.id.radio_oper);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("edit1", Integer.parseInt(edit1.getText().toString()));
                intent.putExtra("edit2", Integer.parseInt(edit2.getText().toString()));

                int oper = 0;
                switch (radio.getCheckedRadioButtonId()){
                    case R.id.radio_plus:
                       oper = PLUS;
                       break;
                    case R.id.radio_minus:
                        oper = MINUS;
                        break;
                    case R.id.radio_multi:
                        oper = MULTI;
                        break;
                    case R.id.radio_divide:
                        oper = DIVIDE;
                        break;
                }
                intent.putExtra("oper", oper);
                startActivityForResult(intent, 0);
            }
        });
    }//OnCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            int result = data.getIntExtra("result", 0);
            Toast.makeText(getApplicationContext(), "결과 :"+result, Toast.LENGTH_LONG).show();
        }
    }
}