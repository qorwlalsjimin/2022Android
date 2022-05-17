package com.example.mirim_project_0512_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    int[] btnNumId = {R.id.btn0, R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
    Button[] btnNum = new Button[btnNumId.length];
    TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        textResult = findViewById(R.id.text_result);
        Button btnPlus = findViewById(R.id.btn_plus);
        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnMulti = findViewById(R.id.btn_multi);
        Button btnDivide = findViewById(R.id.btn_divide);

        for(int i = 0; i<btnNum.length; i++){
            final int index = i;
            btnNum[i] = findViewById(btnNumId[i]);
            btnNum[index].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    String s = "";
                    if(edit1.isFocused()){
                        s = edit1.getText().toString() + btnNum[index].getText();
                        edit1.setText(s);
                    }else if(edit2.isFocused()){
                        s = edit2.getText().toString() + btnNum[index].getText();
                        edit2.setText(s);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "EditText에 포커스가 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnPlus.setOnClickListener(btnListener);
        btnMinus.setOnClickListener(btnListener);
        btnMulti.setOnClickListener(btnListener);
        btnDivide.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int n1 = Integer.parseInt(edit1.getText().toString());
            int n2 = Integer.parseInt(edit2.getText().toString());
            int result = 0;
            switch(view.getId()){
                case R.id.btn_plus:
                    result = n1+n2;
                    break;
                case R.id.btn_minus:
                    result = n1-n2;
                    break;
                case R.id.btn_multi:
                    result = n1*n2;
                    break;
                case R.id.btn_divide:
                    result = n1/n2;
                    break;
            }
            textResult.setText("결과 : "+result);
        }
    };
}