package com.erickogi14gmail.odijos1.Main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import com.erickogi14gmail.odijos1.R;
import com.erickogi14gmail.odijos1.utills.clickListener;

/**
 * Created by Eric on 9/12/2017.
 */

public class FavoritesListAdapter extends RecyclerView.Adapter<FavoritesListAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<FavoritesPojo> modelList;
    private final clickListener listener;

    public FavoritesListAdapter(Context context, ArrayList<FavoritesPojo> modelList,clickListener listener) {
        this.context = context;
        this.modelList = modelList;
        this.listener=listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourites_item, parent, false);
        return new MyViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FavoritesPojo favoritesPojo=modelList.get(position);
        holder.mtxtFavName.setText(favoritesPojo.getFav_name());
        holder.mtxtFavRating.setText(favoritesPojo.getFav_rating());
        holder.mtxtFavTime.setText(favoritesPojo.getFav_time());
        holder.mtxtFavRate.setText(favoritesPojo.getFav_rate());
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
        TextView mtxtFavName,mtxtFavRating,mtxtFavTime,mtxtFavRate;
        ImageView mimgFavLogo;
        Button btnFavRequest;
        private WeakReference<clickListener> listenerWeakReference;
        public MyViewHolder(View itemView,clickListener listener) {
            super(itemView);
            listenerWeakReference=new WeakReference<clickListener>(listener);
            mtxtFavName=(TextView)itemView.findViewById(R.id.txt_fav_name);
            mtxtFavRating=(TextView)itemView.findViewById(R.id.txt_fav_ratings);
            mtxtFavTime=(TextView)itemView.findViewById(R.id.txt_fav_time);
            mtxtFavRate=(TextView)itemView.findViewById(R.id.txt_fav_rate);
            mimgFavLogo=(ImageView)itemView.findViewById(R.id.img_logo);
            btnFavRequest=(Button)itemView.findViewById(R.id.btn_request);

            btnFavRequest.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listenerWeakReference.get().onPositionClicked(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }
}
