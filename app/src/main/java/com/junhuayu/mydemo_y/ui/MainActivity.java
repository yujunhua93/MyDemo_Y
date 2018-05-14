package com.junhuayu.mydemo_y.ui;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.junhuayu.mydemo_y.R;
import com.junhuayu.mydemo_y.model.TabItem;
import com.junhuayu.mydemo_y.ui.fragments.CateFragment;
import com.junhuayu.mydemo_y.ui.fragments.HomeFragment;
import com.junhuayu.mydemo_y.ui.fragments.MyFragment;
import com.junhuayu.mydemo_y.ui.fragments.ShoppingCartFragment;
import com.junhuayu.mydemo_y.ui.fragments.SocialFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    public static final int HOME = 0;
    public static final int CATE = 1;
    public static final int SOCIAL = 2;
    public static final int SHOPPINGCART = 3;
    public static final int MY = 4;

    private HomeFragment homeFragment;
    private CateFragment cateFragment;
    private SocialFragment socialFragment;
    private ShoppingCartFragment shoppingCartFragment;
    private MyFragment myFragment;

    @BindView(R.id.home_tab)
    LinearLayout homeTab;
    @BindView(R.id.cate_tab)
    LinearLayout cateTab;
    @BindView(R.id.social_tab)
    LinearLayout SocialTab;
    @BindView(R.id.shopping_tab)
    LinearLayout shoppingTab;
    @BindView(R.id.my_tab)
    LinearLayout myTab;







    private int currentPage = HOME;

    private SparseArray<TabItem> fragmentSparseArray;

    private static final String CUTTENT_PAGE = "current_page";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (savedInstanceState == null){

        }else {
            FragmentManager fm = getSupportFragmentManager();
            homeFragment = (HomeFragment) fm.findFragmentByTag(String.valueOf(HOME));
            cateFragment = (CateFragment) fm.findFragmentByTag(String.valueOf(CATE));
            socialFragment = (SocialFragment) fm.findFragmentByTag(String.valueOf(SOCIAL));
            shoppingCartFragment = (ShoppingCartFragment) fm.findFragmentByTag(String.valueOf(SHOPPINGCART));
            myFragment = (MyFragment) fm.findFragmentByTag(String.valueOf(MY));
            currentPage = savedInstanceState.getInt(CUTTENT_PAGE);
        }
        changeFragments(currentPage);
        changeSelect(currentPage);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CUTTENT_PAGE,currentPage);
    }

    @OnClick({R.id.home_tab,R.id.cate_tab,R.id.social_tab,R.id.shopping_tab,R.id.my_tab})
    void tabClick(View v){
        if (v.getId() ==  R.id.home_tab){
            currentPage = HOME;
        }else if (v.getId() ==  R.id.cate_tab){
            currentPage = CATE;
        }else if (v.getId() ==  R.id.social_tab){
            currentPage = SOCIAL;
        }else if (v.getId() ==  R.id.shopping_tab){
            currentPage = SHOPPINGCART;
        }else if (v.getId() ==  R.id.my_tab){
            currentPage = MY;
        }
        changeFragments(currentPage);
        changeSelect(currentPage);
    }

    private void changeFragments(int page){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//开启一个Fragment事务
        hideFragments(transaction);
        if(page == HOME){
            if(homeFragment==null){
                homeFragment = HomeFragment.newInstance("","");
                transaction.add(R.id.content,homeFragment,String.valueOf(HOME));
            }else {
                transaction.show(homeFragment);
            }
        }else if(page == CATE){
            if(cateFragment==null){
                cateFragment = CateFragment.newInstance("","");
                transaction.add(R.id.content,cateFragment,String.valueOf(CATE));
            }else {
                transaction.show(cateFragment);
            }
        }else if(page == SOCIAL){
            if(socialFragment==null){
                socialFragment = SocialFragment.newInstance("","");
                transaction.add(R.id.content,socialFragment,String.valueOf(SOCIAL));
            }else {
                transaction.show(socialFragment);
            }
        }else if(page == SHOPPINGCART){
            if(shoppingCartFragment==null){
                shoppingCartFragment = ShoppingCartFragment.newInstance("","");
                transaction.add(R.id.content,shoppingCartFragment,String.valueOf(SHOPPINGCART));
            }else {
                transaction.show(shoppingCartFragment);
            }
        }else if(page == MY){
            if(myFragment==null){
                myFragment = MyFragment.newInstance("","");
                transaction.add(R.id.content,myFragment,String.valueOf(MY));
            }else {
                transaction.show(myFragment);
            }
        }
        transaction.commit();

    }

    private void hideFragments(FragmentTransaction ft){
        if (homeFragment != null)
            ft.hide(homeFragment);
        if (cateFragment != null)
            ft.hide(cateFragment);
        if (socialFragment != null)
            ft.hide(socialFragment);
        if (shoppingCartFragment != null)
            ft.hide(shoppingCartFragment);
        if (myFragment != null)
            ft.hide(myFragment);
    }

    private void changeSelect(int page){
        setSelectorAllFalse();
        if(page == HOME){
            changeTabStyle(R.id.home_tab);
        }else if(page == CATE){
            changeTabStyle(R.id.cate_tab);
        }else if(page == SOCIAL){
            changeTabStyle(R.id.social_tab);
        }else if(page == SHOPPINGCART){
            changeTabStyle(R.id.shopping_tab);
        }else if(page == MY){
            changeTabStyle(R.id.my_tab);
        }
    }

    private void setSelectorAllFalse() {

    }

    private void changeTabStyle(int id) {
        ViewGroup navView = findViewById(id);
        TextView tv = (TextView) navView.getChildAt(1);
        navView.getChildAt(0).setSelected(true);
        tv.setTextColor(getResources().getColor(R.color.colorPrimary));
    }

}
