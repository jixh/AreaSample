package com.jktaihe.area.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jktaihe.area.R;
import com.jktaihe.area.adapter.CityAdapter;
import com.jktaihe.area.adapter.ProvinceAdapter;
import java.util.List;
import java.util.Map;

/**
 * Created by jktaihe on 15/10/17.
 * blog: blog.jktaihe.com
 */

public class AreaDialog extends AlertDialog {

    private RecyclerView mProvince;
    private RecyclerView mCity;
    private List<String> mProvinceDatas;
    private Map<String,List<String>> citys;

    public AreaDialog(@NonNull Context context,List<String> mProvinceDatas,Map<String,List<String>> citys) {
        super(context);
        this.mProvinceDatas = mProvinceDatas;
        this.citys = citys;

        initView(context);
    }

    private void initView(Context context) {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,700);
        setContentView(LayoutInflater.from(context).inflate(R.layout.layout_area,null),params);

        mProvince = findViewById(R.id.rv_province);
        mCity = findViewById(R.id.rv_city);

        ProvinceAdapter provinceAdapter = new ProvinceAdapter(context);
        mProvince.setAdapter(provinceAdapter);
        provinceAdapter.setDatas(mProvinceDatas);
        mProvince.setLayoutManager(new LinearLayoutManager(context));

        CityAdapter cityAdapter = new CityAdapter(context);
        mCity.setAdapter(cityAdapter);
        mCity.setLayoutManager(new LinearLayoutManager(context));
        cityAdapter.setDatas(citys.get(mProvinceDatas.get(provinceAdapter.getSelectPosition())));
    }
}
