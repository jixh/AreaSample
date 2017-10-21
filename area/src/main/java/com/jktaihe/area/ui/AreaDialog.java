package com.jktaihe.area.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.jktaihe.area.R;
import com.jktaihe.area.adapter.CityAdapter;
import com.jktaihe.area.adapter.ProvinceAdapter;
import com.jktaihe.area.model.ProvinceBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jktaihe on 15/10/17.
 * blog: blog.jktaihe.com
 */

public class AreaDialog extends AlertDialog implements View.OnClickListener{

    private RecyclerView rvProvince;
    private RecyclerView rvCity;
    private List<ProvinceBean> datas = new ArrayList<>();
    private Context mContext;
    private LinearSnapHelper shProvince;
    private LinearSnapHelper shCity;

    public AreaDialog(@NonNull Context context,List<ProvinceBean> datas) {
        super(context,R.style.AreaAlertDialog);
        this.mContext = context;
        setDatas(datas);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);

//        WindowManager m = ((Activity)mContext).getWindowManager();
//        Display d = m.getDefaultDisplay(); //为获取屏幕宽、高
//        WindowManager.LayoutParams p = getWindow().getAttributes(); //获取对话框当前的参数值
//        p.width = d.getWidth(); //宽度设置为屏幕
//        getWindow().setAttributes(p); //设置生效

        setContentView(R.layout.layout_area);
        setCanceledOnTouchOutside(true);
        findViewById(R.id.tv_cancel).setOnClickListener(this);
        findViewById(R.id.tv_confirm).setOnClickListener(this);

        rvProvince = findViewById(R.id.rv_province);
        rvCity = findViewById(R.id.rv_city);
        shProvince = new LinearSnapHelper();
        shProvince.attachToRecyclerView(rvProvince);
        shCity = new LinearSnapHelper();
        shCity.attachToRecyclerView(rvCity);


        final CityAdapter cityAdapter = new CityAdapter();
        rvCity.setLayoutManager(new LinearLayoutManager(mContext));
        rvCity.setAdapter(cityAdapter);

        final ProvinceAdapter provinceAdapter = new ProvinceAdapter();
        rvProvince.setLayoutManager(new LinearLayoutManager(mContext));
        rvProvince.setAdapter(provinceAdapter);


        cityAdapter.setDataList(datas.get(provinceAdapter.getSelectPosition()).getCitys());
        provinceAdapter.setDataList(datas);
        rvProvince.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0){
                    cityAdapter.setDataList(datas.get(provinceAdapter.getSelectPosition()).getCitys());
                }
            }
        });


    }

    @Override
    public void show() {
        super.show();


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_cancel){

        }else if(id == R.id.tv_confirm){

        }
        dismiss();
    }

    public void setDatas(List<ProvinceBean> datas) {
        if (datas==null) datas = new ArrayList<>();
        this.datas.clear();
        this.datas.addAll(datas);
    }
}
