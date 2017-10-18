package com.rosinante24.discovermuseumapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rosinante24.discovermuseumapp.Activity.ListMuseumActivity;
import com.rosinante24.discovermuseumapp.Model.ResponseKota;
import com.rosinante24.discovermuseumapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rosinante24 on 18/10/17.
 */

public class AdapterRecyclerKota extends RecyclerView.Adapter<AdapterRecyclerKota.ViewHolder> {
    List<ResponseKota.DataKota> dataKotaList;
    Context context;

    public AdapterRecyclerKota(List<ResponseKota.DataKota> dataKotaList, Context context) {
        this.dataKotaList = dataKotaList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_main, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textnamaprovinsi.setText(dataKotaList.get(position).getNamaKota());
        holder.carditemprovinsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), ListMuseumActivity.class);
                intent.putExtra("id_kota", dataKotaList.get(position).getKodeWilayahKota());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataKotaList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textnamaprovinsi)
        TextView textnamaprovinsi;
        @BindView(R.id.carditemprovinsi)
        CardView carditemprovinsi;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
