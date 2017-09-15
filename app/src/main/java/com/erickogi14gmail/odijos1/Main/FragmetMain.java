package com.erickogi14gmail.odijos1.Main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.erickogi14gmail.odijos1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 9/12/2017.
 */

public class FragmetMain extends Fragment implements ViewPager.OnPageChangeListener,View.OnClickListener{
    private View view;
    private ViewPager viewPager;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioBtnOne,mRadioBtnTwo;

    public void hideRadioBtns(){
        mRadioGroup.setVisibility(View.INVISIBLE);
    }
    public void showRadioBtns(){
        mRadioGroup.setVisibility(View.VISIBLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_main,container,false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        mRadioGroup=(RadioGroup)view.findViewById(R.id.radio_group);
        mRadioBtnOne=(RadioButton)view.findViewById(R.id.radio_btn_one);
        mRadioBtnTwo=(RadioButton)view.findViewById(R.id.radio_btn_two);

        mRadioBtnOne.setChecked(true);
        getActivity().setTitle(Html.fromHtml("<font color ='#142170'>New Course</font>"));
        initUi(view);
        return view;
    }

    private void initUi(View view) {
        initListeners();
    }

    private void initListeners() {
        viewPager.addOnPageChangeListener(this);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentNewCourse(), "lo");
        adapter.addFragment(new FragmentFavoritesCourses(), "li");


        viewPager.setOffscreenPageLimit(0);
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
      mRadioGroup.check(mRadioGroup.getChildAt(position).getId());
        if(position==1){
            getActivity().setTitle(Html.fromHtml("<font color ='#142170'>Favorites</font>"));
        }else {
            getActivity().setTitle(Html.fromHtml("<font color ='#142170'>New Course</font>"));
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }



}
