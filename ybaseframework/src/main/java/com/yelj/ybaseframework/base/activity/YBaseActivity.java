package com.yelj.ybaseframework.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.jaeger.library.StatusBarUtil;
import com.yelj.ybaseframework.R;

/**
 * Author: Alex.ylj
 * 2019-06-04 16:44 Tuesday
 * Description:
 */
public abstract class YBaseActivity extends YBaseInterActivity {

    protected final String TAG = getClass().getName() + "==";
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
            //设置沉浸式状态栏
            setStatusBar();
            //初始化toolbar
            initToolbar();
            //初始化界面的View
            initView();
            //初始化数据
            initData();
        }
    }

    /**
     * 设置状态栏的颜色
     */
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(mContext, R.color.colorPrimary), 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 显示进度框
     */
    protected void showProgress() {
//        DialogUtil.showLoadingDialog(context, false);
    }

    /**
     * 显示进度框
     *
     * @param dimAmount 窗口背景透明度
     */
    protected void showProgress(float dimAmount) {
//        DialogUtil.showLoadingDialog(context, false, dimAmount);
    }

    /**
     * 显示无法取消进度框
     */
    protected void showProgressIrrevocable() {
//        DialogUtil.showLoadingDialog(context, true);
    }

    /**
     * 隐藏进度框
     */
    protected void dismissProgress() {
//        DialogUtil.dismissLoadingDialog();
    }
}
