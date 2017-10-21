package com.jktaihe.area;


import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.jktaihe.area.model.CityBean;
import com.jktaihe.area.model.ProvinceBean;
import com.jktaihe.area.ui.AreaDialog;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jktaihe on 15/10/17.
 * blog: blog.jktaihe.com
 */

public class AreaManager{

    static List<ProvinceBean> dataList = new ArrayList<>();

    private static void initData(){
        for (int i = 1; i < 20; i++) {

            List<CityBean> cityList = new ArrayList<>();
            for (int j = 1; j < 10; j++) {
                cityList.add(new CityBean("市"+i+j));
            }

            dataList.add(new ProvinceBean("省"+i,cityList));
        }
    }



    public static void showAreaSelect(Context context){
        if (dataList.isEmpty()){
            initData();
        }

        AreaDialog areaDialog = new AreaDialog(context,dataList);
        areaDialog.show();
    }
}
