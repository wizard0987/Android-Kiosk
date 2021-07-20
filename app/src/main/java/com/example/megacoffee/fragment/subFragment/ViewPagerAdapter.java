package com.example.megacoffee.fragment.subFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    // Fragment를 교체를 보여주기 위한 처리를 구현
    @NonNull
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return PageSeasonBeverageFrag.newInstance();
//            case 1:
//                return PageSeasonDessertFrag.newInstance();
//            case 2:
//                return PageHotCoffeeFrag.newInstance();
//            case 3:
//                return PageIceCoffeeFrag.newInstance();
//            case 4:
//                return PageBreadFrag.newInstance();
//            case 5:
//                return PageCookieFrag.newInstance();
            default:
                return null;
        }
    }

    public int getItemCount() {
        return 2;
    }
}
