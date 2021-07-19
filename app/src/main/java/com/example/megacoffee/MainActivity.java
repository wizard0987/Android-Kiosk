package com.example.megacoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.megacoffee.databinding.ActivityMainBinding;
import com.example.megacoffee.fragment.TabMenuBreadFrag;
import com.example.megacoffee.fragment.TabMenuCookieFrag;
import com.example.megacoffee.fragment.TabMenuHotCoffeeFrag;
import com.example.megacoffee.fragment.TabMenuIceCoffeeFrag;
import com.example.megacoffee.fragment.TabMenuSeasonDessertFrag;
import com.example.megacoffee.fragment.TabMenuSeasonBeverageFrag;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    private void switchFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.tab_menu_frame, fragment);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ViewBinding 셋팅
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        // 기본 Fragment 지정
        switchFragment(new TabMenuSeasonBeverageFrag());

        mainBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()) {
                    case 0:
                        switchFragment(new TabMenuSeasonBeverageFrag()); break;
                    case 1:
                        switchFragment(new TabMenuSeasonDessertFrag()); break;
                    case 2:
                        switchFragment(new TabMenuHotCoffeeFrag()); break;
                    case 3:
                        switchFragment(new TabMenuIceCoffeeFrag()); break;
                    case 4:
                        switchFragment(new TabMenuBreadFrag()); break;
                    case 5:
                        switchFragment(new TabMenuCookieFrag()); break;
                }
            }

            public void onTabUnselected(TabLayout.Tab tab) {}

            public void onTabReselected(TabLayout.Tab tab) {}
        });

    }

}