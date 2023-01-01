package kr.hs.s2104.mirim_project_0725_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linear1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear1 = findViewById(R.id.linear1);
        btn = findViewById(R.id.btn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.item_red:
                linear1.setBackgroundColor(Color.RED);
                return true;
            case R.id.item_yellow:
                linear1.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.item_green:
                linear1.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.btn_rotate:
                btn.setRotation(45);
                return true;
            case R.id.btn_size:
                btn.setScaleX(2);
                return true;
        }
        return false;
    }
}