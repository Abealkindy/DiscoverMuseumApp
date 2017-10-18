package com.rosinante24.discovermuseumapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rosinante24.discovermuseumapp.Activity.ListKotaActivity;
import com.rosinante24.discovermuseumapp.Model.ResponseProvinsi;
import com.rosinante24.discovermuseumapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rosinante24 on 18/10/17.
 */

public class AdapterRecyclerMain extends RecyclerView.Adapter<AdapterRecyclerMain.ViewHolder> {

    List<ResponseProvinsi.DataProvinsi> dataProvinsiList;
    Context context;

    public AdapterRecyclerMain(List<ResponseProvinsi.DataProvinsi> dataProvinsiList, Context context) {
        this.dataProvinsiList = dataProvinsiList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.textnamaprovinsi.setText(dataProvinsiList.get(position).getNamaProvinsi());
        holder.carditemprovinsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), ListKotaActivity.class);
                intent.putExtra("id_provinsi", dataProvinsiList.get(position).getKodelWilayahProvinsi());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataProvinsiList.size();
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
