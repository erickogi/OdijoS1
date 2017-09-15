package com.erickogi14gmail.odijos1.OdijoLFound;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.erickogi14gmail.odijos1.R;

public class OdijoActivityHost extends AppCompatActivity  {
    public static Fragment fragment = null;
    private ImageView imgIconBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odijo_host);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgIconBack=(ImageView)findViewById(R.id.icon_back);
        imgIconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        fab.hide();

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
        finish();
    }
}
