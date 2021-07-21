package com.example.megacoffee.fragment.subFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.megacoffee.R;

public class Child1SeasonBeverageFrag extends Fragment {

    private View view;

    public static Child1SeasonBeverageFrag newInstance() {
        return new Child1SeasonBeverageFrag();
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.child_fragment_season_beverage_1pg, container, false);

        return view;
    }
}
