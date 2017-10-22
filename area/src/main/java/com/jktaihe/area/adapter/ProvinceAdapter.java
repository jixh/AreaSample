package com.jktaihe.area.adapter;

import com.jktaihe.area.R;
import com.jktaihe.area.model.ProvinceBean;

/**
 * Created by jktaihe on 15/10/17.
 * blog: blog.jktaihe.com
 */

public class ProvinceAdapter extends RVSingleTypeAdapter<ProvinceBean> {

    public ProvinceAdapter() {
    }

    @Override
    public void onBindViewHolder(RVViewHolder holder, int position) {
        holder.item.setText(getItem(position).getName());
    }

    @Override
    public int getItemResID() {
        return R.layout.item_province;
    }
}
