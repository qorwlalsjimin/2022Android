package kr.hs.s2104.mirim_project_0803_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    Button btnSelect;
    EditText editName, editCount, editResultName, editResultCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.edit_name);
        editCount = findViewById(R.id.edit_counts);
        editResultName = findViewById(R.id.edit_result_name);
        editResultCount = findViewById(R.id.edit_result_counts);
        Button btnInit = findViewById(R.id.btn_init);
        Button btnInsert = findViewById(R.id.btn_insert);
        Button btnUpdate = findViewById(R.id.btn_update);
        Button btnDelete = findViewById(R.id.btn_delete);
        btnSelect = findViewById(R.id.btn_select);
        btnInit.setOnClickListener(btnListener);
        btnInsert.setOnClickListener(btnListener);
        btnUpdate.setOnClickListener(btnListener);
        btnDelete.setOnClickListener(btnListener);
        btnSelect.setOnClickListener(btnListener);
        dbHelper = new DBHelper(this);
    }

    View.OnClickListener btnListener =  new View.OnClickListener() {
        SQLiteDatabase db;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_init:
                    db = dbHelper.getWritableDatabase();
                    dbHelper.onUpgrade(db, 1, 2); //초기화하려면 버전을 바꿔야한다
                    db.close();
                    break;
                    
                case R.id.btn_insert:
                    db = dbHelper.getWritableDatabase();
                    db.execSQL("INSERT INTO idolTBL VALUES('"+editName.getText().toString()+"',"+editCount.getText().toString()+");");
                    db.close();
                    Toast.makeText(getApplicationContext(), "새로운 idol 정보가 추가되었습니다.", Toast.LENGTH_SHORT).show();
                    editName.setText("");
                    editCount.setText("");
                    btnSelect.callOnClick(); //조회 버튼 안 눌러도 보임
                    break;
                    
                case R.id.btn_update:
                    db = dbHelper.getWritableDatabase();
                    db.execSQL("UPDATE idolTBL SET cnt = "+editCount.getText().toString()+" WHERE name = '"+editName.getText().toString()+"';");
                    btnSelect.callOnClick();
                    db.close();
                    Toast.makeText(getApplicationContext(), "idol 정보가 수정되었습니다.", Toast.LENGTH_SHORT).show();
                    editName.setText("");
                    editCount.setText("");
                    break;

                case R.id.btn_delete:
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("정말 삭제하시겠습니까?");
                    dlg.setPositiveButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db = dbHelper.getWritableDatabase();
                            db.execSQL("DELETE FROM idolTBL WHERE name = '"+editName.getText().toString()+"';");
                            btnSelect.callOnClick();
                            db.close();
                            Toast.makeText(getApplicationContext(), "idol 정보가 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                            editName.setText("");
                            editCount.setText("");
                        }
                    });
                    dlg.setNegativeButton("아니오",null);
                    dlg.show();
                    break;

                case R.id.btn_select:
                    db = dbHelper.getReadableDatabase();
                    Cursor c = db.rawQuery("select * from idolTBL;", null);

                    String strName = "아이돌명\r\n_______\r\n";
                    String strCnt = "인원수\r\n_______\r\n";

                    while(c.moveToNext()){
                        strName += c.getString(0) + "\r\n";
                        strCnt += c.getString(1) + "\r\n";
                        //.append도 가능
                    }

                    editResultName.setText(strName);
                    editResultCount.setText(strCnt);

                    c.close();
                    db.close();
                    break;
            }
        }
    };
    public class DBHelper extends SQLiteOpenHelper{

        //DB 생성
        public DBHelper(Context context){ //생성자
            super(context, "idolDB", null, 1); //중간에 버전 올리면 기존의 데이터 사라짐. 특수 상황 아니면 버전 바꾸지 말기
        }

        @Override
        public void onCreate(SQLiteDatabase db) { //database 참조 값이 매개변수로 들어옴
            db.execSQL("CREATE TABLE idolTBL(" +
                    "name char(30) primary key, " +
                    "cnt integer" +
                    ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) { //(db, 올드 버전, 뉴 버전)
            //버전이 바뀌면 실행되는 메서드
            db.execSQL("DROP TABLE IF EXISTS idolTBL");
            onCreate(db);
        }
    }
}