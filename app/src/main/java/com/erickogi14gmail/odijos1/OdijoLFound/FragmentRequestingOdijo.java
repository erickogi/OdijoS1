package com.erickogi14gmail.odijos1.OdijoLFound;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.erickogi14gmail.odijos1.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Eric on 9/13/2017.
 */

public class FragmentRequestingOdijo extends Fragment {
    public static Fragment fragment = null;
    AVLoadingIndicatorView avLoadingIndicatorView;
    Button btnCancel,btnCall;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_requesting_odijo,container,false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        avLoadingIndicatorView=(AVLoadingIndicatorView)view.findViewById(R.id.avi);
        btnCancel=(Button)view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCancel();
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
                    popOutFragments();
                    fragment= new FragmentRequestProgress();
                    setUpView();//startActivity(new Intent(getActivity(),OdijoActivity.class));
                    //getActivity().finish();
                }catch (Exception m){

                }
                //popOutFragments();
            }

        },2000);
        avLoadingIndicatorView.show();
    }
    void stopAnim(){
        avLoadingIndicatorView.hide();
    }

    void setUpView() {
        if (fragment != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment)
                    .addToBackStack(null).commit();
        }

    }

    void popOutFragments() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
            fragmentManager.popBackStack();
        }
    }
    private void dialogCancel(){
        final Dialog dialog=new Dialog(getContext());
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.round_dark_blue);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_cancel_request);
        dialog.setCanceledOnTouchOutside(false);
        Button btnProceed=(Button)dialog.findViewById(R.id.btn_no);
        Button btnCancel=(Button)dialog.findViewById(R.id.btn_yes);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                getActivity().finish();
            }
        });
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
