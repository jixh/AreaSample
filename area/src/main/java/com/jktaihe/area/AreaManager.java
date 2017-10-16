package com.jktaihe.area;


import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.jktaihe.area.ui.AreaDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jktaihe on 15/10/17.
 * blog: blog.jktaihe.com
 */

public class AreaManager{

    public static List<String> mProvinceDatas = new ArrayList<>();

    public static Map<String,List<String>> citys = new HashMap<>();


    private static void initData(){
        mProvinceDatas.add("A");
        mProvinceDatas.add("B");

        List<String> citys1 = new ArrayList<>();
        citys1.add("a1");
        citys1.add("a2");
        citys1.add("a3");
        citys1.add("a4");
        citys.put("A",citys1);

        List<String> citys2 = new ArrayList<>();
        citys1.add("b1");
        citys1.add("b2");
        citys1.add("b3");
        citys1.add("b4");
        citys.put("B",citys2);
    }



    public static void showAreaSelect(Context context){
        if (mProvinceDatas.isEmpty()){
            initData();
        }

        AreaDialog areaDialog = new AreaDialog(context,mProvinceDatas,citys);
        areaDialog.show();
    }
}
