package com.erickogi14gmail.odijos1.OdijoLFound;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.erickogi14gmail.odijos1.R;

/**
 * Created by Eric on 9/13/2017.
 */

public class FragmetOdijosProfile extends Fragment {
    private View view;
    RadioGroup  mRadioGroup;



    public static Fragment getInstance(int position) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);

        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_odijo_profile,container,false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        ViewPager viewPager = (ViewPager)view. findViewById(R.id.viewPager);

        CardFragmentPagerAdapter pagerAdapter = new CardFragmentPagerAdapter(getActivity().getSupportFragmentManager(), dpToPixels(2, getContext()));
        ShadowTransformer fragmentCardShadowTransformer = new ShadowTransformer(viewPager, pagerAdapter);
        fragmentCardShadowTransformer.enableScaling(true);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(false, fragmentCardShadowTransformer);
        viewPager.setOffscreenPageLimit(4);

        mRadioGroup=(RadioGroup)view.findViewById(R.id.radio_group);
       // mRadioGroup.check(getArguments().getInt("position"));


        return view;
    }
    public void check(int p){
        mRadioGroup.check(p);
    }

    /**
     * Change value in dp to pixels
     * @param dp
     * @param context
     * @return
     */
    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}
