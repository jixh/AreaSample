package com.jktaihe.area.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
/**
 * Created by jktaihe on 21/10/17.
 * blog: blog.jktaihe.com
 */

public class AreaRecyclerView extends RecyclerView {

    private ScrollListener scrollListener;

    public AreaRecyclerView(Context context) {
        this(context,null);
    }

    public AreaRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        new LinearSnapHelper().attachToRecyclerView(this);
        setLayoutManager(new LinearLayoutManager(context));
        addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0 && scrollListener!=null){
                    scrollListener.onScroll(getVisableCenterPosition());
                }
            }
        });
    }

    public int getVisableCenterPosition() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        //判断是当前layoutManager是否为LinearLayoutManager
        // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
            //获取最后一个可见view的位置
            int lastItemPosition = linearManager.findLastVisibleItemPosition();
            //获取第一个可见view的位置
            int firstItemPosition = linearManager.findFirstVisibleItemPosition();
            return  (firstItemPosition + lastItemPosition)/2;
        }
        return 0;
    }

    public interface ScrollListener{
        void onScroll(int position);
    }

    public void setScrollListener(ScrollListener scrollListener) {
        this.scrollListener = scrollListener;
    }
}
