package com.erickogi14gmail.odijos1.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erickogi14gmail.odijos1.R;

/**
 * Created by Eric on 9/12/2017.
 */


public class SignUpFragment extends Fragment{
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.sign_up_fragment,container,false);
        return view;
    }
}
