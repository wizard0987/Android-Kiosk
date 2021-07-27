package com.example.megacoffee.fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.megacoffee.R;
import com.example.megacoffee.databinding.GridItemBinding;
import com.example.megacoffee.entity.Coffee;

import java.util.List;

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
    public SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SlideViewHolder(
                GridItemBinding.inflate(
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

        private GridItemBinding gridItemBinding;

        public SlideViewHolder(GridItemBinding gridItemBinding) {
            super(gridItemBinding.getRoot());
            this.gridItemBinding = gridItemBinding;
        }

        void bind(Coffee coffee) {
            try {
                if(coffee.getImgSrc().equals("ic_launcher_background")) {
                    gridItemBinding.itemImg.setImageResource(R.drawable.ic_launcher_background);
                } else {
                    gridItemBinding.itemImg.setImageResource(R.drawable.ic_launcher_foreground);
                }
                gridItemBinding.itemName.setText(coffee.getName());
                gridItemBinding.itemPrice.setText(coffee.getPrice() + "원");
            } catch (Exception e) {
                Log.d(TAG, "ERROR: " + e.getMessage());
            }
        }
    }
}
