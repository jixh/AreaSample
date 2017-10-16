package com.jktaihe.area.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jktaihe.area.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jktaihe on 15/10/17.
 * blog: blog.jktaihe.com
 */

public abstract class RVSingleTypeAdapter extends RecyclerView.Adapter<RVSingleTypeAdapter.RVViewHolder> {

    private List<String> datas;
    private Context mContext;

    public RVSingleTypeAdapter(Context context){
        datas = new ArrayList<>();
    }


    @Override
    public RVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(getItemResID(),parent,false);
        RVViewHolder viewHolder = new RVViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RVViewHolder holder, int position) {
        holder.item.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public abstract int getItemResID();

    public List<String> getDatas() {
        return datas;
    }

    public void setDatas(List<String> datas) {
        this.datas.clear();
        if (datas != null && !datas.isEmpty())
            this.datas.addAll(datas);
    }

    static class RVViewHolder extends RecyclerView.ViewHolder{

        public TextView item;

        public RVViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.tv_context);
        }
    }
}
