package com.example.megacoffee;

import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ViewBinding 셋팅
//        setContentView(R.layout.activity_main);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            public void onTabSelected(TabLayout.Tab tab) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (tab.getPosition()) {
                    case 0:
                        TabMenuSeasonBeverageFrag frag1 = new TabMenuSeasonBeverageFrag();
                        transaction.replace(R.id.tab_menu_frame, frag1);
                        transaction.commit();
                        break;
                    case 1:
                        TabMenuSeasonDessertFrag frag2 = new TabMenuSeasonDessertFrag();
                        transaction.replace(R.id.tab_menu_frame, frag2);
                        transaction.commit();
                        break;
                    case 2:
                        TabMenuHotCoffeeFrag frag3 = new TabMenuHotCoffeeFrag();
                        transaction.replace(R.id.tab_menu_frame, frag3);
                        transaction.commit();
                        break;
                    case 3:
                        TabMenuIceCoffeeFrag frag4 = new TabMenuIceCoffeeFrag();
                        transaction.replace(R.id.tab_menu_frame, frag4);
                        transaction.commit();
                        break;
                    case 4:
                        TabMenuBreadFrag frag5 = new TabMenuBreadFrag();
                        transaction.replace(R.id.tab_menu_frame, frag5);
                        transaction.commit();
                        break;
                    case 5:
                        TabMenuCookieFrag frag6 = new TabMenuCookieFrag();
                        transaction.replace(R.id.tab_menu_frame, frag6);
                        transaction.commit();
                        break;
                }
            }

            public void onTabUnselected(TabLayout.Tab tab) {

            }

            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}