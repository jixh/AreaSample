package com.jktaihe.area.adapter;

import android.content.Context;

import com.jktaihe.area.R;

/**
 * Created by jktaihe on 15/10/17.
 * blog: blog.jktaihe.com
 */

public class CityAdapter extends RVSingleTypeAdapter {

    public CityAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemResID() {
        return R.layout.item_city;
    }
}
