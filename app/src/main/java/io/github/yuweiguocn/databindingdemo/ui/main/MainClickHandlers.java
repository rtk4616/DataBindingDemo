package io.github.yuweiguocn.databindingdemo.ui.main;

import android.view.View;

import io.github.yuweiguocn.databindingdemo.util.T;

/**
 * Created by growth on 7/9/16.
 */
public class MainClickHandlers {

    public void onClickName(View v) {
        T.s(v.getContext(),"通过方法引用处理的点击事件");
    }
}
