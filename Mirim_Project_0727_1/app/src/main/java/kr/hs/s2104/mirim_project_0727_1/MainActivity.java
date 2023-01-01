package kr.hs.s2104.mirim_project_0727_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCheck;
    String[] itemsArr = {"Italy", "France", "Spain"};
    boolean[] checkArr = {false, false, false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCheck = findViewById(R.id.btn_check);
        btnCheck.setOnClickListener(btnCheckListener);
    }

    View.OnClickListener btnCheckListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("체크목록대화상자");
            dlg.setIcon(R.drawable.icon);
//            dlg.setMultiChoiceItems(itemsArr, checkArr, null);
//            dlg.setItems(itemsArr, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            btnCheck.setText(itemsArr[i]);
//                        }
//                    });

            dlg.setMultiChoiceItems(itemsArr, checkArr, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    checkArr[i] = b;
                    btnCheck.setText("");
                    for(int j = 0; j<checkArr.length; j++){
                        if(checkArr[j])
                            btnCheck.append(itemsArr[j]);
                    }
                }
            });

            dlg.setNegativeButton("닫기", null);
            dlg.show();
        }
    };
}