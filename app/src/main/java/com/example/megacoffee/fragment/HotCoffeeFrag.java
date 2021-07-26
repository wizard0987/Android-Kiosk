package com.example.megacoffee.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.megacoffee.databinding.FragHotCoffeeBinding;
import com.example.megacoffee.databinding.ItemListFormBinding;
import com.example.megacoffee.fragment.subFragment.SlideAdapter;

import java.util.ArrayList;
import java.util.List;

public class HotCoffeeFrag extends Fragment {

    private FragHotCoffeeBinding fragBinding;
    // 최상위 핸들러 정의
    private Runnable sliderRunnable =
            () -> fragBinding.vpHotCoffee.setCurrentItem(fragBinding.vpHotCoffee.getCurrentItem());
    private View view;

    private Handler sliderHandler = new Handler();

    private List<String> createDummyItems() {
        List<String> itemList = new ArrayList<>();
        itemList.add("https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg");
        itemList.add("https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg");
        itemList.add("https://cdn.pixabay.com/photo/2020/11/10/01/34/pet-5728249_1280.jpg");
        itemList.add("https://cdn.pixabay.com/photo/2020/12/21/19/05/window-5850628_1280.png");
        itemList.add("https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg");
        itemList.add("https://cdn.pixabay.com/photo/2019/10/15/13/33/red-deer-4551678_1280.jpg");
        return itemList;
    }

    public HotCoffeeFrag() { }

    public static HotCoffeeFrag newInstance() {
        return new HotCoffeeFrag();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        fragBinding = FragHotCoffeeBinding.inflate(inflater, container, false);
        view = fragBinding.getRoot();

        // Setting ViewPager2
//        fragBinding.vpHotCoffee.setAdapter(new SlideAdapter(getActivity(), createDummyItems()));
        fragBinding.vpHotCoffee.setAdapter(new SlideAdapter(getActivity(), fragBinding.vpHotCoffee, createDummyItems()));
        fragBinding.vpHotCoffee.setCurrentItem(36); // 페이지 위치를 36pg으로 초기화

        // Setting Indicator
        fragBinding.ciIndicator.setViewPager(fragBinding.vpHotCoffee);
        fragBinding.ciIndicator.createIndicators(createDummyItems().size(), 0);

        // 이전/다음 페이지로 이동 시 슬라이딩 대상 페이지에 적용되는 애니메이션 효과
        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(40));
        transformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });
        fragBinding.vpHotCoffee.setPageTransformer(transformer);

        // ViewPager2의 특정 페이지에 위치할 때 정의하는 코드
        fragBinding.vpHotCoffee.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 2000L);
                fragBinding.ciIndicator
                        .animatePageSelected(position % createDummyItems().size());
            }
        });

        return view;
    }

}
