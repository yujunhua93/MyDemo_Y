package com.junhuayu.mydemo_y.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by junhua.yu on 2018/5/14.
 */

public class BaseFragemnt extends Fragment{

    private boolean mIsHidden;
    private static final String FRAGMENT_STATUS = "fragment_status";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (savedInstanceState != null){
//            mIsHidden = savedInstanceState.getBoolean(FRAGMENT_STATUS);
//            processFragmentStatus();
//        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putBoolean(FRAGMENT_STATUS,isHidden());
    }

    private void processFragmentStatus() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (mIsHidden){
            ft.hide(this);
        }else {
            ft.show(this);
        }
        ft.commit();
    }
}
