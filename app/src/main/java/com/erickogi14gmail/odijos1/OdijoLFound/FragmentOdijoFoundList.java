package com.erickogi14gmail.odijos1.OdijoLFound;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.erickogi14gmail.odijos1.Main.FavoritesListAdapter;
import com.erickogi14gmail.odijos1.Main.FavoritesPojo;
import com.erickogi14gmail.odijos1.Main.FragmetMain;
import com.erickogi14gmail.odijos1.R;
import com.erickogi14gmail.odijos1.utills.StaggeredHiddingScrollListener;
import com.erickogi14gmail.odijos1.utills.clickListener;

import java.util.ArrayList;

/**
 * Created by Eric on 9/13/2017.
 */

public class FragmentOdijoFoundList extends Fragment {
    private View view;
    private FavoritesPojo favoritesPojo;
    private ArrayList<FavoritesPojo> favoritesPojos;
    private OdijoListAdapter odijoListAdapter;
    private FragmetMain f;
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    public static Fragment fragment = null;


    private void insertItems(){
        favoritesPojos=new ArrayList<>();
        for(int a=0;a<50;a++) {
            FavoritesPojo favoritesPojo = new FavoritesPojo(a,"Full Odijo Names","4.5","30","300",
                    "7 am-8 am","Lorem ipsum dolor sit amet, consectetur adipiscing elit.  Etiam eget ligula eu lectus lobortis condimentum."
                    ,"",a);
            favoritesPojos.add(favoritesPojo);
        }
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_odijo_list,container,false);
       // getActivity().setTitle("Available Odijos");
       // getActivity().setTitleColor(2033112);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        insertItems();
        intViews();
        return view;
    }

    private void intViews() {

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        odijoListAdapter = new OdijoListAdapter(getContext(), favoritesPojos, new clickListener() {
            @Override
            public void onPositionClicked(int position) {
                fragment=new FragmentRequestingOdijo();
                popOutFragments();
                setUpView();

               // Toast.makeText(getContext(), "Requested Odijo " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClicked(int postion) {

            }

            @Override
            public void onPositionClickedbtnProfile(int position) {
                ///Toast.makeText(getContext(), "profile clicked " + position, Toast.LENGTH_SHORT).show();
                fragment=new  FragmetOdijosProfile();
                popOutFragments();
                setUpView();
            }
        });
        odijoListAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(odijoListAdapter);





        recyclerView.setOnScrollListener(new StaggeredHiddingScrollListener() {

            @Override
            public void onHide() {//hideViews();
                //  f.hideRadioBtns();

            }

            @Override
            public void onShow() {//showViews();
                // f.showRadioBtns();


            }
        });
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
}
