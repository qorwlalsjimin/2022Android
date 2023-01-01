package kr.hs.s2104.mirim_project_0801_listview1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] items = {"왜 오수재인가", "닥터로이어", "이상한변호사 우영우",
            "굿닥터", "종이의 집", "환혼", "외계인", "한산", "탑건", "헌트", "가쉽걸", "스팬서"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listv = findViewById(R.id.listv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, items);
        listv.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //선택 하나만
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("선택한 시리즈 및 영화");
                dlg.setMessage(items[i]+" 선택하셨군요~");
                dlg.show();
            }
        });
    }
}