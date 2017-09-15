package com.erickogi14gmail.odijos1.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erickogi14gmail.odijos1.R;

/**
 * Created by Eric on 9/15/2017.
 */

public class FragmentMyProfile extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_my_profile,container,false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        return view;
    }
}
