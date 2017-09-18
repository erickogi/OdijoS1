package com.erickogi14gmail.odijos1.OdijoLFound;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.erickogi14gmail.odijos1.R;

import at.grabner.circleprogress.CircleProgressView;
import at.grabner.circleprogress.TextMode;

/**
 * Created by Eric on 9/15/2017.
 */

public class FragmentRequestProgress extends Fragment {
    CircleProgressView circleProgressView;
    Button btnCancel,btnCall;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_odijo_request_progress,container,false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        circleProgressView=(CircleProgressView)view.findViewById(R.id.circleProgress);
        circleProgressView.setSpinBarColor(getActivity().getResources().getColor(R.color.colorAccentP));
        circleProgressView.setValue(78);
        circleProgressView.setTextMode(TextMode.TEXT);
        circleProgressView.setTextTypeface(Typeface.MONOSPACE);
        circleProgressView.setAutoTextSize(true);
        //circleProgressView.setTextSize(26);
        circleProgressView.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
        circleProgressView.setRimColor(getActivity().getResources().getColor(R.color.colorPrimaryDark));
       // circleProgressView.setFillCircleColor(getActivity().getResources().getColor(R.color.colorPrimaryDark));
        circleProgressView.setBarColor(getActivity().getResources().getColor(R.color.colorPrimary));
        circleProgressView.setText("Approx.. 30 \n mins \nOut");

        btnCancel=(Button)view.findViewById(R.id.btn_cancel);
        btnCall=(Button)view.findViewById(R.id.btn_call);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0714406984"));
                startActivity(callIntent);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCancel();
            }
        });
        return view;
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
