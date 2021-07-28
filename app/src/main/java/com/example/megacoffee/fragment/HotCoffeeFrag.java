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

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.megacoffee.R;
import com.example.megacoffee.databinding.CoffeeItemBinding;
import com.example.megacoffee.databinding.FragHotCoffeeBinding;
import com.example.megacoffee.entity.Coffee;

import java.util.ArrayList;
import java.util.List;

public class HotCoffeeFrag extends Fragment {

    private FragHotCoffeeBinding fragBinding;
    // 최상위 핸들러 정의
    private Runnable sliderRunnable =
            () -> fragBinding.vpHotCoffee.setCurrentItem(fragBinding.vpHotCoffee.getCurrentItem());
    private View view;

    private Handler sliderHandler = new Handler();

//    private List<String> createDummyItems() {
//        List<String> itemList = new ArrayList<>();
//        itemList.add("https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg");
//        itemList.add("https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg");
//        itemList.add("https://cdn.pixabay.com/photo/2020/11/10/01/34/pet-5728249_1280.jpg");
//        itemList.add("https://cdn.pixabay.com/photo/2020/12/21/19/05/window-5850628_1280.png");
//        itemList.add("https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg");
//        itemList.add("https://cdn.pixabay.com/photo/2019/10/15/13/33/red-deer-4551678_1280.jpg");
//        return itemList;
//    }

    private List<Coffee> createDummyItems() {
        List<Coffee> itemList = new ArrayList<>();
        itemList.add(new Coffee(1L, "아메리카노", "핫아", R.drawable.hot_americano, 1500, 100, 3L));
        itemList.add(new Coffee(2L, "카푸치노", "까뿌찌노~", R.drawable.hot_cappuccino, 2700, 50, 3L));
        itemList.add(new Coffee(3L, "카라멜마끼아또", "ㄲ라멜", R.drawable.hot_caramel_macchiato, 3500, 130, 3L));
        itemList.add(new Coffee(4L, "카페모카", "모카빨", R.drawable.hot_cafe_mocha, 3700, 220, 3L));
        itemList.add(new Coffee(5L, "티라미슈라떼", "케이크라떼", R.drawable.hot_tiramisu_latte, 3300, 99, 3L));
        itemList.add(new Coffee(6L, "바닐라라떼", "바닐라무첨가", R.drawable.hot_vanilla_latte, 3800, 70, 3L));
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
        fragBinding.vpHotCoffee.setAdapter(new SlideAdapter(fragBinding.vpHotCoffee, createDummyItems()));
        fragBinding.vpHotCoffee.setCurrentItem(36); // 페이지 위치를 36pg으로 초기화

        // Setting Indicator
        fragBinding.ciHotCoffee.setViewPager(fragBinding.vpHotCoffee);
        fragBinding.ciHotCoffee.createIndicators(createDummyItems().size(), 0);

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
                fragBinding.ciHotCoffee.animatePageSelected(position % createDummyItems().size());
            }
        });

        return view;
    }

    public class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.SlideViewHolder> {

        private static final String TAG = "HotCoffeeAdapter";

        private Context context;
        private ViewPager2 viewPager;
        private List<Coffee> list;

        // 무한 슬라이딩을 위해 Adapter에서 리스트 끝에 올 때마다 새로운 리스트를 추가하기 위한 코드
        private Runnable runnable = new Runnable() {
            @Override
            public void run() {
                list.addAll(list);
                notifyDataSetChanged(); // (새로운) 아이템 추가 시에 ReBinding(새로 고침)을 시킨다.
            }
        };

        public SlideAdapter(ViewPager2 viewPager, List<Coffee> list) {
//        this.context    = context;
            this.viewPager  = viewPager;
            this.list       = list;
        }

        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @NonNull
        public SlideAdapter.SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SlideAdapter.SlideViewHolder(
                    CoffeeItemBinding.inflate(
                            LayoutInflater.from(parent.getContext()), parent, false
                    )
            );
        }

        public void onBindViewHolder(@NonNull SlideAdapter.SlideViewHolder holder, int position) {
            position = position % list.size();
            holder.bind(list.get(position));
            // 무한 슬라이딩 적용
            if(position == list.size() - 2) { // 페이지 위치가 아이템 목록 직전일 경우
                // 파라미터 Runnable 클래스를 통해 같은 아이템 목록을 새로 추가한다.
                viewPager.post(runnable);
            }
        }

        public int getItemCount() {
            return list == null ? 0 : 100; // 무한 슬라이딩을 위해 전체 페이지 수를 100으로 설정
        }

        public class SlideViewHolder extends RecyclerView.ViewHolder {

            private CoffeeItemBinding coffeeItemBinding;

            public SlideViewHolder(CoffeeItemBinding coffeeItemBinding) {
                super(coffeeItemBinding.getRoot());
                this.coffeeItemBinding = coffeeItemBinding;
            }

            void bind(Coffee coffee) {
                try {
                    if(coffee.getImgSrc().equals("ic_launcher_background")) {
                        coffeeItemBinding.ivImage.setImageResource(R.drawable.ic_launcher_background);
                    } else {
                        coffeeItemBinding.ivImage.setImageResource(R.drawable.ic_launcher_foreground);
                    }
                    coffeeItemBinding.tvName.setText(coffee.getName());
                    coffeeItemBinding.tvPrice.setText(coffee.getPrice() + "원");
                } catch (Exception e) {
                    Log.d(TAG, "ERROR: " + e.getMessage());
                }
            }
        }
    }

}
