package com.example.tabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPagerAdapter mAdapter;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());  //referencia del adaptador

        //addFragment

        mAdapter.addFragment(new HomeFragment());       //0
        mAdapter.addFragment(new AccountFragment());    //1
        mAdapter.addFragment(new SettingsFragment());   //2

        viewPager2.setAdapter(mAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){

                    case 0:
                        tab.setText("Home");
                        break;
                    case 1:
                        tab.setText("Formas de cambiar la actitud del liderazgo");
                        break;
                    case 2:
                        tab.setText("Settings");
                        break;


                }

            }
        }).attach();


    }
}