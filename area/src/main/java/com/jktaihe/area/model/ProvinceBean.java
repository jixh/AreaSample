package com.jktaihe.area.model;

import java.util.List;

/**
 * Created by jktaihe on 21/10/17.
 * blog: blog.jktaihe.com
 */

public class ProvinceBean {

    private String id;
    private String name;
    private List<CityBean> citys;

    public ProvinceBean(String name, List<CityBean> citys) {
        this.name = name;
        this.citys = citys;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityBean> getCitys() {
        return citys;
    }

    public void setCitys(List<CityBean> citys) {
        this.citys = citys;
    }
}
