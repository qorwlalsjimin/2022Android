package kr.hs.s2104.mirim_project_0802_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    GridView gridv;
    int[] posterId = {R.drawable.after, R.drawable.busanhang, R.drawable.exit, R.drawable.flipped, R.drawable.soul,
            R.drawable.gisaeng, R.drawable.jangnan, R.drawable.juragi, R.drawable.minions, R.drawable.kissingbooth,
            R.drawable.after, R.drawable.busanhang, R.drawable.exit, R.drawable.flipped, R.drawable.soul,
            R.drawable.gisaeng, R.drawable.jangnan, R.drawable.juragi, R.drawable.minions, R.drawable.kissingbooth,
            R.drawable.after, R.drawable.busanhang, R.drawable.exit, R.drawable.flipped, R.drawable.soul,
            R.drawable.gisaeng, R.drawable.jangnan, R.drawable.juragi, R.drawable.minions, R.drawable.kissingbooth};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최신영화포스터");
        gridv = findViewById(R.id.gridv);
        PosterAdapter adapter = new PosterAdapter(this);
        gridv.setAdapter(adapter);
    }

    public class PosterAdapter extends BaseAdapter{
        Context context;
        public PosterAdapter(Context context){
            this.context = context;
        }
        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(200, 300);
            //GridView.LayoutParams params = new GridView.LayoutParams(200, 300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setPadding(5,5,5,5);
            imgv.setImageResource(posterId[i]);

            final int pos = i;
            imgv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("Large Poster");
                    dlg.setIcon(R.drawable.movic);
                    View dlgView = View.inflate(MainActivity.this, R.layout.dialog, null);
                    ImageView imgvDlg = dlgView.findViewById(R.id.imgv_dlg);
                    imgvDlg.setImageResource(posterId[pos]);
                    dlg.setView(dlgView);
                    dlg.setNegativeButton("close", null);
                    dlg.show();
                }
            });

            return null;
        }
    }
}