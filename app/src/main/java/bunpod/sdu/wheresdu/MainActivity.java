package bunpod.sdu.wheresdu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bunpod.sdu.wheresdu.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Show Fragment

        if (savedInstanceState == null) {

            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentcontent, mainFragment).commit();
        } // ติดตั้ง Fragment  ไว้ที่ View


    }// Main Mothod
}// Main Class
