package com.erickogi14gmail.odijos1.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.erickogi14gmail.odijos1.OdijoLFound.FragmentRequestingOdijo;
import com.erickogi14gmail.odijos1.OdijoLFound.OdijoActivity;
import com.erickogi14gmail.odijos1.R;
import com.erickogi14gmail.odijos1.utills.StaggeredHiddingScrollListener;
import com.erickogi14gmail.odijos1.utills.clickListener;

import java.util.ArrayList;

/**
 * Created by Eric on 9/12/2017.
 */

public class FragmentFavoritesCourses extends Fragment {
    private View view;
    private FavoritesPojo favoritesPojo;
    private ArrayList<FavoritesPojo> favoritesPojos;
    private FavoritesListAdapter favoritesListAdapter;
    private FragmetMain f;
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    public static Fragment fragment = null;


    private void insertItems(){
        favoritesPojos=new ArrayList<>();
        for(int a=0;a<50;a++) {
            FavoritesPojo favoritesPojo = new FavoritesPojo(a,"Full Odijo Names","4.5","30","300");
            favoritesPojos.add(favoritesPojo);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_favorites,container,false);
        f = (FragmetMain) getActivity().getSupportFragmentManager().findFragmentByTag("fragmentMain");
        insertItems();
        intViews();
        return view;
    }

    private void intViews() {

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        favoritesListAdapter=new FavoritesListAdapter(getContext(), favoritesPojos, new clickListener() {
            @Override
            public void onPositionClicked(int position) {
                fragment=new FragmentRequestingOdijo();
                popOutFragments();
                setUpView();
               // startActivity(new Intent(getActivity(), OdijoActivity.class));
              //  Toast.makeText(getContext(), "Requested Odijo "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClicked(int postion) {

            }

            @Override
            public void onPositionClickedbtnProfile(int position) {

            }
        });
        favoritesListAdapter.notifyDataSetChanged();
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(favoritesListAdapter);





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
