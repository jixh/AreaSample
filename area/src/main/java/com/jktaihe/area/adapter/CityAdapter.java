package com.jktaihe.area.adapter;


import com.jktaihe.area.R;
import com.jktaihe.area.model.CityBean;

/**
 * Created by jktaihe on 15/10/17.
 * blog: blog.jktaihe.com
 */

public class CityAdapter extends RVSingleTypeAdapter<CityBean> {

    public CityAdapter() {
        super();
    }

    @Override
    public void onBindViewHolder(RVViewHolder holder, int position) {
        holder.item.setText(getItem(position).getName());
    }

    @Override
    public int getItemResID() {
        return R.layout.item_city;
    }
}
