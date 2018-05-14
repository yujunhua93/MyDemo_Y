package com.junhuayu.mydemo_y.model;

import android.support.v4.app.Fragment;
import android.view.ViewGroup;

/**
 * Created by junhua.yu on 2018/5/11.
 */

public class TabItem {
    public int page;
    public Fragment fragment;
    public ViewGroup navGroup;

    public TabItem(int page, Fragment fragment, ViewGroup navGroup) {
        this.page = page;
        this.fragment = fragment;
        this.navGroup = navGroup;
    }
}
