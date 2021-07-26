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

import com.bumptech.glide.Glide;
import com.example.megacoffee.databinding.FragSeasonDessertBinding;
import com.example.megacoffee.databinding.ItemListFormBinding;
import com.example.megacoffee.fragment.subFragment.SlideAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeasonDessertFrag extends Fragment {

    private FragSeasonDessertBinding fragBinding;
    private View view;

    public SeasonDessertFrag() { }

    public static SeasonDessertFrag newInstance() {
        return new SeasonDessertFrag();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        fragBinding = FragSeasonDessertBinding.inflate(inflater, container, false);
        view = fragBinding.getRoot();

        fragBinding.vpSeasonDessert.setAdapter(new SlideAdapter(getActivity(), fragBinding.vpSeasonDessert, createDummyItems()));

        fragBinding.ciSeasonDessert.setViewPager(fragBinding.vpSeasonDessert);
        fragBinding.ciSeasonDessert.createIndicators(createDummyItems().size(), 0);

        return view;
    }

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

//    public class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.SlideViewHolder> {
//
//        private static final String TAG = "HotCoffeeAdapter";
//
//        private Context context;
//        //    private List<entity.HotCoffeeEntity> list;
//        private List<String> list;
//
//        public SlideAdapter(Context context, List<String> list) {
//            this.context = context;
//            this.list = list;
//        }
//
//        @NonNull
//        public SlideAdapter.SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            return new SlideAdapter.SlideViewHolder(
//                    ItemListFormBinding.inflate(
//                            LayoutInflater.from(parent.getContext()), parent, false
//                    )
//            );
//        }
//
//        public void onBindViewHolder(@NonNull SlideAdapter.SlideViewHolder holder, int position) {
//            holder.bind(list.get(position));
//        }
//
//        public int getItemCount() {
//            return list.size();
//        }
//
//        public class SlideViewHolder extends RecyclerView.ViewHolder {
//
//            private ItemListFormBinding itemListBinding;
//
//            public SlideViewHolder(ItemListFormBinding fsdBinding) {
//                super(fsdBinding.getRoot());
//                this.itemListBinding = fsdBinding;
//            }
//
//            void bind(String sliderItem) {
//                try {
//                    Glide.with(context).load(sliderItem).into(itemListBinding.imageSlider);
//                } catch (Exception e) {
//                    Log.d(TAG, "ERROR: " + e.getMessage());
//                }
//            }
//        }
//    }

}
