package com.example.megacoffee.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.megacoffee.R;
import com.example.megacoffee.databinding.FragIceCoffeeBinding;
import com.example.megacoffee.databinding.FormGridviewBinding;
import com.example.megacoffee.entity.Coffee;

import java.util.ArrayList;
import java.util.List;

public class IceCoffeeFrag extends Fragment {

    private FragIceCoffeeBinding fragBinding;
    // 최상위 핸들러 정의
    private Runnable sliderRunnable =
            () -> fragBinding.vpIceCoffee.setCurrentItem(fragBinding.vpIceCoffee.getCurrentItem());
    private View view;

    private Handler sliderHandler = new Handler();

    private List<List<Coffee>> createDummyItems() {
        int limit = 3;
        List<List<Coffee>> lists = new ArrayList<>();

        List<Coffee> menulist = new ArrayList<>();
        menulist.add(new Coffee(1L, "아메리카노", "아아", R.drawable.ice_americano, 1500, 100, 4L));
        menulist.add(new Coffee(2L, "카푸치노", "까뿌찌노~", R.drawable.ice_cappuccino, 2700, 50, 4L));
        menulist.add(new Coffee(3L, "카라멜마끼아또", "ㄲ라멜", R.drawable.ice_caramel_macchiato, 3500, 130, 4L));
        menulist.add(new Coffee(4L, "카페모카", "모카빨", R.drawable.ice_cafe_mocha, 3700, 220, 4L));
        menulist.add(new Coffee(5L, "티라미슈라떼", "케이크라떼", R.drawable.ice_tiramisu_latte, 3300, 99, 4L));
        menulist.add(new Coffee(6L, "바닐라라떼", "바닐라무첨가", R.drawable.ice_vanilla_latte, 3800, 70, 4L));
        for(int i = 0; i < menulist.size(); i+=limit) {
            lists.add(menulist.subList(i, Math.min(i + limit, menulist.size())));
        }
        return lists;
    }

    public IceCoffeeFrag() { }

    public static IceCoffeeFrag newInstance() {
        return new IceCoffeeFrag();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        // Setting DataBinding
        fragBinding = FragIceCoffeeBinding.inflate(inflater, container, false);
        view = fragBinding.getRoot();

        // Setting ViewPager2
        fragBinding.vpIceCoffee.setAdapter(new SlideAdapter(createDummyItems()));
        fragBinding.vpIceCoffee.setCurrentItem(0); // 페이지 위치를 36pg으로 초기화

        // Setting Indicator
        fragBinding.ciHotCoffee.setViewPager(fragBinding.vpIceCoffee);
        fragBinding.ciHotCoffee.createIndicators(createDummyItems().size(), 0);

        // ViewPager2의 특정 페이지에 위치할 때 정의하는 코드
        fragBinding.vpIceCoffee.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 2000L);
            }
        });

        return view;
    }

    public class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.SlideViewHolder> {

        private static final String TAG = "IceCoffeeAdapter";
        private List<List<Coffee>> lists;

        public SlideAdapter(List<List<Coffee>> lists) {
            this.lists = lists;
        }

        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @NonNull
        public SlideAdapter.SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SlideAdapter.SlideViewHolder(
                    FormGridviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
            );
        }

        public void onBindViewHolder(@NonNull SlideAdapter.SlideViewHolder holder, int position) {
            for(List<Coffee> list : lists) {
                holder.bind(list);
            }
        }

        public int getItemCount() {
            return lists.size();
        }

        public class SlideViewHolder extends RecyclerView.ViewHolder {

            private FormGridviewBinding binding;
            private CoffeeAdapter adapter;

            public SlideViewHolder(FormGridviewBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }

            void bind(List<Coffee> list) {
                try {
                    adapter = new CoffeeAdapter();
                    for(Coffee coffee : list) {
                        adapter.addItem(coffee);
                    }
                    binding.gvCell.setAdapter(adapter);

                } catch (Exception e) {
                    Log.d(TAG, "ERROR: " + e.getMessage());
                }
            }
        }
    }

    public class CoffeeAdapter extends BaseAdapter {

        private CoffeeItemView view;
        private List<Coffee> list = new ArrayList<>();

        public int getCount() {
            return list.size();
        }

        public void addItem(Coffee coffee) {
            list.add(coffee);
        }

        public Object getItem(int position) {
            return list.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                view = new CoffeeItemView(getContext());
            } else {
                view = (CoffeeItemView) convertView;
            }

            Coffee coffee = list.get(position);

            view.setImage(coffee.getImgSrc());
            view.setName(coffee.getName());
            view.setPrice(coffee.getPrice());

            return view;
        }
    }


    public class CoffeeItemView extends LinearLayout {

        private ImageView iv_image;
        private TextView  tv_name;
        private TextView  tv_price;

        public CoffeeItemView(Context context) {
            super(context);
            init(context);
        }

        public CoffeeItemView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public void setImage(int resId) {
            iv_image.setImageResource(resId);
        }

        public void setName(String name) {
            tv_name.setText(name);
        }

        public void setPrice(int price) {
            tv_price.setText(String.valueOf(price) + "원");
        }

        private void init(Context context) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.coffee_item, this, true);

            iv_image = findViewById(R.id.iv_image);
            tv_name  = findViewById(R.id.tv_name);
            tv_price = findViewById(R.id.tv_price);
        }
    }
}
