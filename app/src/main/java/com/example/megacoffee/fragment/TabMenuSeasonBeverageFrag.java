package com.example.megacoffee.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.megacoffee.MainActivity;
import com.example.megacoffee.R;
import com.example.megacoffee.databinding.ActivityMainBinding;
import com.example.megacoffee.fragment.subFragment.PageSeasonBeverageFrag;

public class TabMenuSeasonBeverageFrag extends Fragment {

    public TabMenuSeasonBeverageFrag() { }

    public static TabMenuSeasonBeverageFrag newInstance() {
        return new TabMenuSeasonBeverageFrag();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.main_fragment_season_beverage, container, false);
    }
}
