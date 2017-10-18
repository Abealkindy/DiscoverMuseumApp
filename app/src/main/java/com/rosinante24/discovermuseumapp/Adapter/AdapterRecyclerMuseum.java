package com.rosinante24.discovermuseumapp.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rosinante24.discovermuseumapp.Model.ResponseMuseum;
import com.rosinante24.discovermuseumapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rosinante24 on 19/10/17.
 */

public class AdapterRecyclerMuseum extends RecyclerView.Adapter<AdapterRecyclerMuseum.ViewHolder> {
    List<ResponseMuseum.DataMuseum> dataMuseumList;
    Context context;

    public AdapterRecyclerMuseum(List<ResponseMuseum.DataMuseum> dataMuseumList, Context context) {
        this.dataMuseumList = dataMuseumList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_museum, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textnamamuseum.setText(dataMuseumList.get(position).getNamaMuseum());

    }

    @Override
    public int getItemCount() {
        return dataMuseumList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textnamamuseum)
        TextView textnamamuseum;
        @BindView(R.id.carditemmuseum)
        CardView carditemmuseum;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
