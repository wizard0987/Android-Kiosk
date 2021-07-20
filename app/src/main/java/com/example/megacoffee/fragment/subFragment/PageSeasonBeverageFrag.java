package com.example.megacoffee.fragment.subFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.megacoffee.R;

public class PageSeasonBeverageFrag extends Fragment {

    private View view;

    public static PageSeasonBeverageFrag newInstance() {
        return new PageSeasonBeverageFrag();
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment_season_beverage, container, false);

        return view;
    }
}
