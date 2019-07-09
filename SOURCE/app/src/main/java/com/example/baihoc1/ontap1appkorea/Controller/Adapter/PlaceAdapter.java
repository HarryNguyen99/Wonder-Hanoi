package com.example.baihoc1.ontap1appkorea.Controller.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.baihoc1.ontap1appkorea.Controller.Detail;
import com.example.baihoc1.ontap1appkorea.Model.PlaceResult;
import com.example.baihoc1.ontap1appkorea.R;
import com.example.baihoc1.ontap1appkorea.interfaces.OnClickSccues;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {
    public Context context;
    public List<PlaceResult> data;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<PlaceResult> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.place_item_layout, viewGroup, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlaceViewHolder placeViewHolder, final int i) {
        final PlaceResult result = data.get(i);
        placeViewHolder.tvPlaceName.setText(result.getPlaceName());
        if (data.get(i).getIsPromotion() == 1) {
            placeViewHolder.tvKhuyenMai.setVisibility(View.VISIBLE);
        } else {
            placeViewHolder.tvKhuyenMai.setVisibility(View.INVISIBLE);
        }
        placeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent placedetail = new Intent(context, Detail.class);
                placedetail.putExtra("promotion", data.get(i));
                context.startActivity(placedetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {

        TextView tvPlaceName, tvKhuyenMai, tvChiTiet;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlaceName = itemView.findViewById(R.id.tv_place_name);
            tvKhuyenMai = itemView.findViewById(R.id.tv_khuyen_mai);
            tvChiTiet = itemView.findViewById(R.id.tv_chi_tiet);
        }
    }
}