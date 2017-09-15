package com.erickogi14gmail.odijos1.OdijoLFound;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;

import com.erickogi14gmail.odijos1.Main.FragmetMain;
import com.erickogi14gmail.odijos1.R;

public class OdijoActivity extends AppCompatActivity {
    public static Fragment fragment = null;
   // public static Drawable changeBackArrowColor(Context context,int color){
   //     String resName;
   //     int res;
   //     resName= Build.VERSION.SDK_INT>=23? "abc_ic_back_material" : "abc_ic_"
   // }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odijo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getActivity().setTitle(Html.fromHtml("<font color ='#142170'>Favorites</font>"));

        this.setTitle(Html.fromHtml("<font color ='#142170'>Available    Odijos </font>"));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

       fab.hide();

        fragment = new FragmentOdijoFoundList();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment, "fragmentOdijoFoundList").commit();

    }



    void setUpView() {
        if (fragment != null) {
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment)
                    .addToBackStack(null).commit();
        }

    }

    void popOutFragments() {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
            fragmentManager.popBackStack();
        }
    }

    public void goBack(View view) {
        popOutFragments();
        fragment= new FragmentOdijoFoundList();
        setUpView();
    }

    //public void goBack(View view) {
    //}
}
