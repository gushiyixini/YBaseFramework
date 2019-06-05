package com.yelj.yebaseframeworkdemo;

import android.widget.Toast;

import com.yelj.yebaseframework.base.activity.YeBaseActivity;

public class MainActivity extends YeBaseActivity {

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public String getTitleStr() {
        return "首页";
    }

    @Override
    public int getNavigationIcon() {
        return android.R.drawable.ic_menu_add;
    }

    @Override
    public int[] getMenuIcon() {
        return new int[]{android.R.drawable.ic_menu_call, android.R.drawable.ic_menu_camera};
    }

    @Override
    public String[] getMenuTextStr() {
        return new String[]{"打电话", "相机"};
    }

    @Override
    public void onMenuItemClick(int position) {
        super.onMenuItemClick(position);
        switch (position) {
            case 0:
                Toast.makeText(mContext, "打电话", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(mContext, "相机", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
