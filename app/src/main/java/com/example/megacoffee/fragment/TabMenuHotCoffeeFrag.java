package com.example.megacoffee.fragment;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.megacoffee.R;

public class TabMenuHotCoffeeFrag extends Fragment {

    public TabMenuHotCoffeeFrag() { }

    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tl_ti_hot_coffee, container, false);
    }
}
