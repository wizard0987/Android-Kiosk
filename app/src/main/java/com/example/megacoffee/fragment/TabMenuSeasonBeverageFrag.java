package com.example.megacoffee.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.megacoffee.R;

public class TabMenuSeasonBeverageFrag extends Fragment {

    public TabMenuSeasonBeverageFrag() { }

    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tl_ti_season_beverage, container, false);
    }
}
