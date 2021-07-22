package com.example.megacoffee.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.megacoffee.databinding.FormSeasonDessertBinding;
import com.example.megacoffee.databinding.FragSeasonDessertBinding;

import java.util.Arrays;
import java.util.List;

public class SeasonDessertFrag extends Fragment {

    private View view;
    private FragSeasonDessertBinding sdBinding;
    private int num_page = 6;

    public SeasonDessertFrag() { }

    public static SeasonDessertFrag newInstance() {
        return new SeasonDessertFrag();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        List<String> itemList = Arrays.asList(
                "https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg",
                "https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg",
                "https://cdn.pixabay.com/photo/2020/11/10/01/34/pet-5728249_1280.jpg",
                "https://cdn.pixabay.com/photo/2020/12/21/19/05/window-5850628_1280.png",
                "https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg",
                "https://cdn.pixabay.com/photo/2019/10/15/13/33/red-deer-4551678_1280.jpg"
        );

        sdBinding = FragSeasonDessertBinding.inflate(inflater, container, false);
        view = sdBinding.getRoot();

        sdBinding.vpSeasonDessert.setAdapter(new SlideAdapter(getActivity(), sdBinding.vpSeasonDessert, itemList));

        sdBinding.ciSeasonDessert.setViewPager(sdBinding.vpSeasonDessert);
        sdBinding.ciSeasonDessert.createIndicators(6, 0);

        return view;
    }

    private class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.SlideViewHolder> {

        private static final String TAG = "DessertSlideAdapter";

        private Context context;
        private ViewPager2 viewPager;
        //    private List<entity.DessertEntity> list;
        private List<String> list;

        public SlideAdapter(Context context, ViewPager2 viewPager, List<String> list) {
            this.context = context;
            this.viewPager = viewPager;
            this.list = list;
        }

        @NonNull
        public SlideAdapter.SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SlideAdapter.SlideViewHolder(FormSeasonDessertBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent, false
            ));
        }

        public void onBindViewHolder(@NonNull SlideAdapter.SlideViewHolder holder, int position) {
            holder.bind(list.get(position));
        }

        public int getItemCount() {
            return list.size();
        }

        public class SlideViewHolder extends RecyclerView.ViewHolder {

            private FormSeasonDessertBinding siBinding;

            public SlideViewHolder(FormSeasonDessertBinding binding) {
                super(binding.getRoot());
                siBinding = binding;
            }

            void bind(String sliderItem) {
                try {
                    Glide.with(context).load(sliderItem).into(siBinding.imageSlider);
                } catch (Exception e) {
                    Log.d(TAG, "ERROR: " + e.getMessage());
                }
            }
        }
    }
}
