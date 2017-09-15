package com.erickogi14gmail.odijos1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.erickogi14gmail.odijos1.Main.FragmetMain;
import com.erickogi14gmail.odijos1.OdijoLFound.FragmentSearching;

public class StartActivity extends AppCompatActivity {
    public static Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        fragment = new FragmetMain();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment, "fragmentMain").commit();
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

    public void btnRequestOdijo(View view) {
        fragment=new FragmentSearching();
        popOutFragments();
        setUpView();

    }
}
