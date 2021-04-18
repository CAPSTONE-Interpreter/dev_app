package org.tensorflow.lite.examples.detection;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends FragmentActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
//    private Fragment3 fragment3;
//    private Fragment4 fragment4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action1:
                        setFragment(0);
                        break;
                    case R.id.action2:
                        setFragment(1);
                        break;
                    case R.id.action3:
                        setFragment(2);
                        break;
                    case R.id.action4:
                        setFragment(3);
                        break;
                }
                return true;
            }
        });

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        setFragment(0);

    }
    private void setFragment(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction(); //프래그먼트 교체
        switch (n) { //activity_initial 에 있는 FrameLayout 에 프래그먼트 삽입
            case 0:
                ft.replace(R.id.main_frame, fragment1);
                ft.commit(); //저장을 의미
                break;
            case 1:
                ft.replace(R.id.main_frame, fragment2);
                ft.commit(); //저장을 의미
                break;
        }
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment).commit();
    }
}