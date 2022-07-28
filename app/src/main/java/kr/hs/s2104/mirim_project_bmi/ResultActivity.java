package kr.hs.s2104.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView name, bmi;
    EditText editName, editHeight, editWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        editName = findViewById(R.id.edit_name);
        editHeight = findViewById(R.id.edit_height);
        editWeight = findViewById(R.id.edit_weight);

        name = findViewById(R.id.name);
        bmi = findViewById(R.id.bmi);

        name.setText(editName.getText());
        bmi.setText("미정");
    }
}