package com.jktaihe.area.adapter;

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

public abstract class RVSingleTypeAdapter<DATA> extends RecyclerView.Adapter<RVSingleTypeAdapter.RVViewHolder> {

    protected List<DATA> mDataList;
    private int size = 0;

    public RVSingleTypeAdapter(){
        mDataList = new ArrayList<>();
    }

    @Override
    public RVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getItemResID(),null);
        view.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        RVViewHolder viewHolder = new RVViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return size ==0 ? 0 :Integer.MAX_VALUE;
    }

    public DATA getItem(int position){
    return mDataList.get(position%size);
    }

    public abstract int getItemResID();

    static class RVViewHolder extends RecyclerView.ViewHolder{

        public TextView item;

        public RVViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.tv_context);
        }
    }

    public List<DATA> getDataList() {
        return mDataList;
    }

    public void setDataList(List<DATA> dataList) {

        if (mDataList == null) dataList = new ArrayList<>();

        this.mDataList.clear();

        this.mDataList.addAll(dataList);

        size = this.mDataList.size();

        notifyDataSetChanged();
    }

    public int getMaxSize() {
        return size;
    }
}
