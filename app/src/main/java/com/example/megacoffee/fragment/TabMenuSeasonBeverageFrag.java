package com.example.megacoffee.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.megacoffee.R;
import com.example.megacoffee.databinding.ParentFragmentSeasonBeverageBinding;
import com.example.megacoffee.fragment.subFragment.Child1SeasonBeverageFrag;
import com.example.megacoffee.fragment.subFragment.Child2SeasonBeverageFrag;

import me.relex.circleindicator.CircleIndicator3;

public class TabMenuSeasonBeverageFrag extends Fragment {

    private ParentFragmentSeasonBeverageBinding sbBinding;
//    private View view;
//    private ViewPager2 viewPager;
//    private CircleIndicator3 indicator;
    private int num_page = 2;

    public TabMenuSeasonBeverageFrag() { }

    public static TabMenuSeasonBeverageFrag newInstance() {
        return new TabMenuSeasonBeverageFrag();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.parent_fragment_season_beverage, container, false);
//
//        viewPager = view.findViewById(R.id.vp_child_fragment_season_beverage);
//        indicator = view.findViewById(R.id.ci_child_fragment_season_beverage);
//        indicator.setViewPager(viewPager);
//        indicator.createIndicators(num_page, 0);
//
//        viewPager.setAdapter(new ViewPagerAdapter(getActivity()));
//        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
//        viewPager.setCurrentItem(0);
//        // viewpager를 사용할 때 이전 또는 다음 페이지 몇개까지 미리 로딩할지 지정
//        viewPager.setOffscreenPageLimit(3);
//
//        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
//
//            public void onPageSelected(int position) {
//                indicator.animatePageSelected(position);
//            }
//
//            public void onPageScrollStateChanged(int state) {}
//        });

        /**
         * Fragment에서 Binding 사용하기
         */
        sbBinding = ParentFragmentSeasonBeverageBinding.inflate(inflater, container, false);
        View view = sbBinding.getRoot();

        sbBinding.vpChildFragmentSeasonBeverage.setAdapter(new ViewPagerAdapter(getActivity()));
        sbBinding.vpChildFragmentSeasonBeverage.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        sbBinding.vpChildFragmentSeasonBeverage.setCurrentItem(0);
        // viewpager를 사용할 때 이전 또는 다음 페이지 몇개까지 미리 로딩할지 지정
//        sbBinding.vpChildFragmentSeasonBeverage.setOffscreenPageLimit(3);

        sbBinding.ciChildFragmentSeasonBeverage.setViewPager(sbBinding.vpChildFragmentSeasonBeverage);
        sbBinding.ciChildFragmentSeasonBeverage.createIndicators(num_page, 0);

        sbBinding.vpChildFragmentSeasonBeverage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        return view;
    }

    private class ViewPagerAdapter extends FragmentStateAdapter {

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        // Fragment를 교체를 보여주기 위한 처리를 구현
        @NonNull
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return Child1SeasonBeverageFrag.newInstance();
                case 1:
                    return Child2SeasonBeverageFrag.newInstance();
                default:
                    return null;
            }
        }

        public int getItemCount() {
            return 2;
        }
    }
}
