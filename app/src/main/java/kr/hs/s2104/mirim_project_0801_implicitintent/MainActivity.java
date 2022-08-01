package kr.hs.s2104.mirim_project_0801_implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] btnIds = {R.id.btn_dial, R.id.btn_homepage, R.id.btn_map, R.id.btn_search, R.id. btn_sms, R.id.btn_camera};
        Button btns[] = new Button[6];
        for(int i = 0; i<btns.length; i++){
            btns[i] = findViewById(btnIds[i]);
            btns[i].setOnClickListener(btnListener);
        }
    }//onCreate

    View.OnClickListener btnListener =  new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = null; //참조변수는 null로 초기화
            Uri uri = null;
            switch (view.getId()){
                case R.id.btn_dial:
                    uri = Uri.parse("tel:/01033337777");
                    intent = new Intent(Intent.ACTION_DIAL, uri);
                    break;
                case R.id.btn_homepage:
                    uri = Uri.parse("https://e-mirim.hs.kr");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.btn_map:
                    break;
                case R.id.btn_search:
                    break;
                case R.id.btn_sms:
                    break;
                case R.id.btn_camera:
                    break;
            }
            startActivity(intent);
        }
    };
}