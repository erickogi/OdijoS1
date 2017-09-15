package com.erickogi14gmail.odijos1.OdijoLFound;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.erickogi14gmail.odijos1.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Eric on 9/13/2017.
 */

public class FragmentSearching extends Fragment {
    private View view;
    AVLoadingIndicatorView avLoadingIndicatorView;
    Button btnCancel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_searching,container,false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        avLoadingIndicatorView=(AVLoadingIndicatorView)view.findViewById(R.id.avi);
        btnCancel=(Button)view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stopAnim();
                getFragmentManager().popBackStack();


            }
        });

        startAnim();
        return view;


    }

    void  startAnim(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    stopAnim();
                    startActivity(new Intent(getActivity(), OdijoActivity.class));
                    //popOutFragments();
                }catch (Exception m){

                }
            }

        },5000);
        avLoadingIndicatorView.show();
    }
    void stopAnim(){
        avLoadingIndicatorView.hide();
    }
    void popOutFragments() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
            fragmentManager.popBackStack();
        }
    }
}
