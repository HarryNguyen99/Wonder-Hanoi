package com.example.baihoc1.ontap1appkorea.Controller.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baihoc1.ontap1appkorea.Model.Category;
import com.example.baihoc1.ontap1appkorea.Model.CategoryResult;
import com.example.baihoc1.ontap1appkorea.Model.ListCate;
import com.example.baihoc1.ontap1appkorea.Model.Media;
import com.example.baihoc1.ontap1appkorea.Model.PlaceResult;
import com.example.baihoc1.ontap1appkorea.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{

    public Context context;
    public CategoryResult data;

    public void setContext (@NonNull Context context) {
        this.context = context;
    }

    public void setData (CategoryResult data) {
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof CategoryResult) {
            return 0;
        } else
            return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == 0){
            View view = LayoutInflater.from(context).inflate(R.layout.
                    home_item,viewGroup,false);
            return new HomeViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.
                    home_media,viewGroup,false);
            return new MediaViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        HomeViewHolder homeViewHolder = (HomeViewHolder) viewHolder;
        if (data.get(position) instanceof CategoryResult) {
        Picasso.get().load((CategoryResult)data.get(position).getListBanner())
                .into(homeViewHolder.imgIconnameHome);
        homeViewHolder.tvIconnameHome.setText(listCate.getName());
        homeViewHolder.imgIconnameHome.setColorFilter(Color.WHITE);
        } else{
            MediaViewHolder mediaViewHolder = (MediaViewHolder) viewHolder;
            mediaViewHolder.configWithMedia((Media)data.get(position));
        }
        homeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "ok" + listCate.getName(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.getListCate().size();
    }

    class MediaViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMediaHome;
        public MediaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMediaHome = itemView.findViewById(R.id.img_media_home);
        }

        void configWithMedia(Media media){
            Picasso.get().load(media.getUrlID()).into(imgMediaHome);
        }
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {

        ImageView imgIconnameHome;
        TextView tvIconnameHome;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            imgIconnameHome = itemView.findViewById(R.id.img_iconname_home);
            tvIconnameHome = itemView.findViewById(R.id.tv_iconname_home);

        }
    }
}
