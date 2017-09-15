package com.erickogi14gmail.odijos1.OdijoLFound;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.erickogi14gmail.odijos1.Main.FavoritesPojo;
import com.erickogi14gmail.odijos1.R;
import com.erickogi14gmail.odijos1.utills.clickListener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Eric on 9/13/2017.
 */

public class OdijoListAdapter extends RecyclerView.Adapter<OdijoListAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<FavoritesPojo> modelList;
    private final clickListener listener;

    public OdijoListAdapter(Context context, ArrayList<FavoritesPojo> modelList, clickListener listener) {
        this.context = context;
        this.modelList = modelList;
        this.listener = listener;
    }

    @Override
    public OdijoListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.odijo_item, parent, false);
        return new MyViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(OdijoListAdapter.MyViewHolder holder, int position) {
        FavoritesPojo favoritesPojo=modelList.get(position);
        holder.mtxtOdijoName.setText(favoritesPojo.getOdijo_name());
        holder.mtxtOdijoRating.setText(favoritesPojo.getOdijo_rating());
        holder.mtxtOdijoTime.setText(favoritesPojo.getOdijo_time());
        holder.mtxtOdijoRate.setText(favoritesPojo.getOdijo_rate());
        holder.mtxtOdijoAvailabilty.setText(favoritesPojo.getOdijo_availability());
        holder.mtxtOdijoQualifications.setText(favoritesPojo.getOdijo_qualifications());



        if((favoritesPojo.getIsFavorite()&1)==0){
            holder.mimgOdijoFav.setImageResource(R.drawable.heartred);
        }else {
            holder.mimgOdijoFav.setImageResource(R.drawable.heartblack);
        }
//        try{
//            if(favoritesPojo.getIsFavorite()/2==1){
//
//            }
//            else {
//                holder.mimgOdijoFav.setImageResource(R.drawable.heartblack);
//            }
//        }catch (Exception m){
//            holder.mimgOdijoFav.setImageResource(R.drawable.heartblack);
//        }
    }

    @Override
    public int getItemCount() {
        try {
            return modelList.size();
        }catch (NullPointerException npe){
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        TextView mtxtOdijoName,mtxtOdijoRating,mtxtOdijoTime,mtxtOdijoRate,mtxtOdijoAvailabilty,mtxtOdijoQualifications;
        ImageView mimgOdijoLogo,mimgOdijoFav;
        Button btnOdijoRequest,btnOdijoProfile;
        private WeakReference<clickListener> listenerWeakReference;
        public MyViewHolder(View itemView,clickListener listener) {
            super(itemView);
            listenerWeakReference=new WeakReference<clickListener>(listener);
            mtxtOdijoName=(TextView)itemView.findViewById(R.id.txt_odijo_name);
            mtxtOdijoRating=(TextView)itemView.findViewById(R.id.txt_odijo_ratings);
            mtxtOdijoTime=(TextView)itemView.findViewById(R.id.txt_odijo_time);
            mtxtOdijoRate=(TextView)itemView.findViewById(R.id.txt_odijo_rate);
            mimgOdijoLogo=(ImageView)itemView.findViewById(R.id.img_odijo);
            mimgOdijoFav=(ImageView)itemView.findViewById(R.id.img_fav_icon);
            mtxtOdijoAvailabilty=(TextView)itemView.findViewById(R.id.txt_odijo_available);
            mtxtOdijoQualifications=(TextView)itemView.findViewById(R.id.txt_odijo_qualifications);
            btnOdijoRequest=(Button)itemView.findViewById(R.id.btn_request);
            btnOdijoProfile=(Button)itemView.findViewById(R.id.btn_odijo_profile);

            btnOdijoProfile.setOnClickListener(this);


            btnOdijoRequest.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(v.getId()==btnOdijoProfile.getId()) {
                listenerWeakReference.get().onPositionClickedbtnProfile(getAdapterPosition());
            }else if (v.getId()==btnOdijoRequest.getId()){
                listenerWeakReference.get().onPositionClicked(getAdapterPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }
}
