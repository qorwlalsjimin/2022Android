package kr.hs.s2104.mirim_project_0804_mp3player;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list1;
    Button btnPlay, btnPause, btnStop;
    TextView textMusic, textTime;
    ArrayList<String> musicList;
    String selectedmusic;
    SeekBar seekBar;

    String musicPath = Environment.getExternalStorageDirectory().getPath()+"/";
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("MP3 Player");
        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this, permissions, MODE_PRIVATE);
        list1 = findViewById(R.id.list1);
        btnPlay = findViewById(R.id.btn_play);
        btnPause = findViewById(R.id.btn_pause);
        btnStop = findViewById(R.id.btn_stop);
        textMusic = findViewById(R.id.text_music);
        textTime = findViewById(R.id.text_time);
        seekBar = findViewById(R.id.seek_bar);

        musicList = new ArrayList<String>();
        File[] files = new File(musicPath).listFiles();
        String fileName, extName;

        for (File file : files){
            fileName = file.getName();
            extName = fileName.substring(fileName.length()-3);
            if(extName.equals("mp3")){
                musicList.add(fileName);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, musicList);
        list1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list1.setAdapter(adapter);
        list1.setItemChecked(0, true);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedmusic = musicList.get(i);
            }
        });
        selectedmusic = musicList.get(0);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer = new MediaPlayer();
                try{
                    mPlayer.setDataSource(musicPath + selectedmusic);
                    mPlayer.prepare();
                    mPlayer.start();
                    btnPlay.setClickable(false);
                    btnStop.setClickable(true);
                    textMusic.setText("실행중인 음악: "+selectedmusic);
                }catch (IOException e){
                    e.printStackTrace();
                }

                new Thread(){
                    SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
                    @Override
                    public void run() {
                        if(mPlayer == null)
                            return;
                        seekBar.setMax(mPlayer.getDuration());
                        while(mPlayer.isPlaying()){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    seekBar.setProgress(mPlayer.getCurrentPosition());
                                    textTime.setText("진행시간: "+timeFormat.format(mPlayer.getCurrentPosition()));
                                }
                            });
                            SystemClock.sleep(200);
                        }
                    }
                }.start();
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnPause.getText().equals("일시정지")){
                    mPlayer.pause();
                    btnPause.setText("이어듣기");
                }
                else {
                    mPlayer.start();
                    btnPause.setText("일시정지");
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.stop();
                mPlayer.reset();
                btnPlay.setClickable(true);
                btnStop.setClickable(false);
                textMusic.setText("실행중인 음악: ");
            }
        });
        btnStop.setClickable(false);

    }
}