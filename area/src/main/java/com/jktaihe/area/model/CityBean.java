package com.jktaihe.area.model;

/**
 * Created by jktaihe on 21/10/17.
 * blog: blog.jktaihe.com
 */

public class CityBean {
    private String id;
    private String name;

    public CityBean(String name) {
        this.name = name;
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
}
