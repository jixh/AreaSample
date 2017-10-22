package com.jktaihe.area.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import com.jktaihe.area.R;
import com.jktaihe.area.adapter.CityAdapter;
import com.jktaihe.area.adapter.ProvinceAdapter;
import com.jktaihe.area.model.CityBean;
import com.jktaihe.area.model.ProvinceBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jktaihe on 15/10/17.
 * blog: blog.jktaihe.com
 */

public class AreaDialog extends AlertDialog implements View.OnClickListener{

    private AreaRecyclerView rvProvince;
    private AreaRecyclerView rvCity;
    private List<ProvinceBean> mDataList = new ArrayList<>();
    private ProvinceBean mSelectedProvince;
    private CityBean mSelectedCity;
    private SelectListener mSelectListener;
    private Handler handlerCity;
    private static final int centerPosition = 3;

    public AreaDialog(@NonNull Context context,List<ProvinceBean> dataList) {
        super(context,R.style.AreaAlertDialog);
        setDataList(dataList);
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

        final CityAdapter cityAdapter = new CityAdapter();
        rvCity.setAdapter(cityAdapter);

        handlerCity = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                cityAdapter.setDataList(mSelectedProvince.getCitys());
                rvCity.scrollToPosition(cityAdapter.getMaxSize()*10000);
                return false;
            }
        });
        rvCity.setScrollListener(new AreaRecyclerView.ScrollListener() {
            @Override
            public void onScroll(int position) {
                mSelectedCity = cityAdapter.getItem(position);
            }
        });

        final ProvinceAdapter provinceAdapter = new ProvinceAdapter();
        provinceAdapter.setDataList(mDataList);
        rvProvince.setAdapter(provinceAdapter);
        rvProvince.setScrollListener(new AreaRecyclerView.ScrollListener() {
            @Override
            public void onScroll(int position) {
                mSelectedProvince = provinceAdapter.getItem(position);
                handlerCity.sendEmptyMessage(0);
            }
        });
        rvProvince.scrollToPosition(provinceAdapter.getMaxSize()*10000);


        mSelectedProvince = provinceAdapter.getItem(provinceAdapter.getMaxSize()*10000+centerPosition);
        handlerCity.sendEmptyMessage(0);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_cancel){

        }else if(id == R.id.tv_confirm){
            if (mSelectListener!=null)
                mSelectListener.select(mSelectedProvince,mSelectedCity);
        }
        dismiss();
    }

    public void setDataList(List<ProvinceBean> dataList) {
        if (dataList ==null) dataList = new ArrayList<>();
        this.mDataList.clear();
        this.mDataList.addAll(dataList);
    }

    public interface SelectListener{
        void select(ProvinceBean province,CityBean city);
    }

    public void setSelectListener(SelectListener mSelectListener) {
        this.mSelectListener = mSelectListener;
    }
}
