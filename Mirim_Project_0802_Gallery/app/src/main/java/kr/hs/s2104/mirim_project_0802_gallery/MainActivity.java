package kr.hs.s2104.mirim_project_0802_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] posterId = {R.drawable.after, R.drawable.busanhang, R.drawable.exit, R.drawable.flipped, R.drawable.soul,
            R.drawable.gisaeng, R.drawable.jangnan, R.drawable.juragi, R.drawable.minions, R.drawable.kissingbooth};
    String[] posterName = {"애프터", "부산행", "엑시트","플립","소울","기생충","장난스런 키스","쥬라기공원","미니언즈","키싱부스"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gallery gallery = findViewById(R.id.gallery);
        GalleryAdapter adapter = new GalleryAdapter(this);
        gallery.setAdapter(adapter);
    }

    public class GalleryAdapter extends BaseAdapter{

        Context context;
        public GalleryAdapter(Context context){
            this.context = context;
        }
        @Override
        public int getCount() {
            return posterId.length; //갯수만큼 반복할 수 있음
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
            Gallery.LayoutParams params = new Gallery.LayoutParams(200, 300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setImageResource(posterId[i]);
            final int pos = i;
            imgv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView largeImgv = findViewById(R.id.imgv);
                    largeImgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    largeImgv.setImageResource(posterId[pos]);

                    Toast t = new Toast(MainActivity.this);
                    View toastView = View.inflate(context, R.layout.toast, null);
                    TextView movieTitle = toastView.findViewById(R.id.text_movic_title);
                    movieTitle.setText(posterName[pos]);
                    t.setView(toastView);
                    t.show();
                    return false;
                }
            });

            return imgv;
        }
    }
}