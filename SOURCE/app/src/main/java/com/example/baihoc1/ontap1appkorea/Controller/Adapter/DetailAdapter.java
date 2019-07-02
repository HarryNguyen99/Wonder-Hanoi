package com.example.baihoc1.ontap1appkorea.Controller.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baihoc1.ontap1appkorea.Model.Media;
import com.example.baihoc1.ontap1appkorea.Model.PlaceResult;
import com.example.baihoc1.ontap1appkorea.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    ArrayList<Object> data;
    Context context;

    public DetailAdapter(ArrayList<Object> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof PlaceResult) {
            return 0;
        } else
            return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == 0){
            View view = LayoutInflater.from(context).inflate(R.layout.
                    detail_header_item_layoutt,viewGroup,false);
            return new HeaderViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.
                    detail_madia_item_layoutt,viewGroup,false);
            return new MediaViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        if (data.get(position) instanceof PlaceResult) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder)viewHolder;

            Picasso.get().
                    load(((PlaceResult) data.get(position)).getUrlLogoPlace()).
                    into(headerViewHolder.imglogoks);
            headerViewHolder.tvNameKsDetail.setText(((PlaceResult) data.get(position)).getPlaceName());
            headerViewHolder.tvTelephone.setText(((PlaceResult) data.get(position)).getPhone());
            headerViewHolder.tvDiaChi.setText(((PlaceResult) data.get(position)).getAddress());
            headerViewHolder.tvWeb.setText(((PlaceResult) data.get(position)).getUrlWeb());


        } else{
            MediaViewHolder mediaViewHolder = (MediaViewHolder)viewHolder;
            mediaViewHolder.configWithMedia((Media)data.get(position));
        }



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MediaViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMedia;
        public MediaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMedia = itemView.findViewById(R.id.img_media);
        }

        void configWithMedia(Media media){
            Picasso.get().load(media.getUrlID()).into(imgMedia);
        }
    }


    class HeaderViewHolder extends RecyclerView.ViewHolder {
        ImageView imglogoks;
        TextView tvTelephone, tvDiaChi, tvWeb, tvNameKsDetail;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            imglogoks = itemView.findViewById(R.id.img_logo_ks_detail);
            tvNameKsDetail = itemView.findViewById(R.id.tv_name_ks_detail);
            tvTelephone = itemView.findViewById(R.id.tv_telephone);
            tvDiaChi = itemView.findViewById(R.id.tv_dia_chi);
            tvWeb = itemView.findViewById(R.id.tv_web);

        }
    }

}
