package com.jktaihe.area.adapter;

import com.jktaihe.area.R;
import com.jktaihe.area.model.ProvinceBean;

/**
 * Created by jktaihe on 15/10/17.
 * blog: blog.jktaihe.com
 */

public class ProvinceAdapter extends RVSingleTypeAdapter<ProvinceBean> {

    private  int selectPosition;

    public ProvinceAdapter() {
    }

    @Override
    public void onBindViewHolder(RVViewHolder holder, int position) {
        holder.item.setText(mDataList.get(position).getName());
    }

    @Override
    public int getItemResID() {
        return R.layout.item_province;
    }

    public int getSelectPosition() {
        return selectPosition;
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
    }
}
