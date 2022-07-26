package kr.hs.s2104.mirim_project_0726_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image_view;
    EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_view = findViewById(R.id.image_view);
        edit_text = findViewById(R.id.edit_text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        item.setChecked(false);
        switch (item.getItemId()){
            case R.id.rotate:
                image_view.setRotation(Float.parseFloat(edit_text.getText().toString()));
                return true;
            case R.id.hanrasan:
                image_view.setImageResource(R.drawable.hanrasan);
                item.setChecked(true);
                return true;
            case R.id.chujado:
                image_view.setImageResource(R.drawable.chujado);
                item.setChecked(true);
                return true;
            case R.id.bumsum:
                image_view.setImageResource(R.drawable.bumsum);
                item.setChecked(true);
                return true;
        }
        return false;
    }


}