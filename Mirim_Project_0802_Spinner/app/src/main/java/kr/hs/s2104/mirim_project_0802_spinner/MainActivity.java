package kr.hs.s2104.mirim_project_0802_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    int[] posterId = {R.drawable.after, R.drawable.busanhang, R.drawable.exit, R.drawable.flipped, R.drawable.soul,
            R.drawable.gisaeng, R.drawable.jangnan, R.drawable.juragi, R.drawable.minions, R.drawable.kissingbooth};
    String[] items = {"애프터", "부산행", "엑시트","플립","소울","기생충","장난스런 키스","쥬라기공원","미니언즈","키싱부스"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView imgv = findViewById(R.id.img_poster);
                imgv.setImageResource(posterId[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}