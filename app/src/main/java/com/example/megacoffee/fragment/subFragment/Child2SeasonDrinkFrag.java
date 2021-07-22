package com.example.megacoffee.fragment.subFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.megacoffee.R;

public class Child2SeasonDrinkFrag extends Fragment {

    private View view;

    public static Child2SeasonDrinkFrag newInstance() {
        return new Child2SeasonDrinkFrag();
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_season_drink_child2, container, false);

        return view;
    }
}
