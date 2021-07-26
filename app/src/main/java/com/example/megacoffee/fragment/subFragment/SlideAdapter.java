package com.example.megacoffee.fragment.subFragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.megacoffee.databinding.ItemListFormBinding;

import java.util.List;

public class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.SlideViewHolder> {

    private static final String TAG = "HotCoffeeAdapter";

    private Context context;
    private ViewPager2 viewPager;
    //    private List<entity.HotCoffeeEntity> list;
    private List<String> list;

    // 무한 슬라이딩을 위해 Adapter에서 리스트 끝에 올 때마다 새로운 리스트를 추가하기 위한 코드
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            list.addAll(list);
            notifyDataSetChanged(); // (새로운) 아이템 추가 시에 ReBinding(새로 고침)을 시킨다.
        }
    };

    public SlideAdapter(Context context, ViewPager2 viewPager, List<String> list) {
        this.context    = context;
        this.viewPager  = viewPager;
        this.list       = list;
    }

    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    public SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SlideViewHolder(
                ItemListFormBinding.inflate(
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

        private ItemListFormBinding itemListBinding;

        public SlideViewHolder(ItemListFormBinding fsdBinding) {
            super(fsdBinding.getRoot());
            this.itemListBinding = fsdBinding;
        }

        void bind(String imgUrl) {
            try {
                Glide.with(context).load(imgUrl).into((ImageView) itemListBinding.imageSlider);
            } catch (Exception e) {
                Log.d(TAG, "ERROR: " + e.getMessage());
            }
        }
    }
}
