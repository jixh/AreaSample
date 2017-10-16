package com.jktaihe.area.adapter;

import android.content.Context;

import com.jktaihe.area.R;

/**
 * Created by jktaihe on 15/10/17.
 * blog: blog.jktaihe.com
 */

public class ProvinceAdapter extends RVSingleTypeAdapter {
    private  int selectPosition;

    public ProvinceAdapter(Context context) {
        super(context);
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
