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

    public void switchFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.tab_menu_content, fragment);
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
                        switchFragment(TabMenuSeasonBeverageFrag.newInstance()); break;
                    case 1:
                        switchFragment(TabMenuSeasonDessertFrag.newInstance()); break;
                    case 2:
                        switchFragment(TabMenuHotCoffeeFrag.newInstance()); break;
                    case 3:
                        switchFragment(TabMenuIceCoffeeFrag.newInstance()); break;
                    case 4:
                        switchFragment(TabMenuBreadFrag.newInstance()); break;
                    case 5:
                        switchFragment(TabMenuCookieFrag.newInstance()); break;
                }
            }

            public void onTabUnselected(TabLayout.Tab tab) {}

            public void onTabReselected(TabLayout.Tab tab) {}
        });




    }

}