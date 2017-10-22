package com.jktaihe.area.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jktaihe.area.AreaManager;
import com.jktaihe.area.model.CityBean;
import com.jktaihe.area.model.ProvinceBean;
import com.jktaihe.area.ui.AreaDialog;

public class MainActivity extends AppCompatActivity {

    TextView tvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShow = findViewById(R.id.tv_show);
    }

    public void actionClick(View view){
        AreaManager.showAreaSelect(this, new AreaDialog.SelectListener() {
            @Override
            public void select(ProvinceBean province, CityBean city) {
                tvShow.setText(province.getName()+" "+city.getName());
            }
        });
    }
}
