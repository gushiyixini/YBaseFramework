package com.yelj.ybaseframework.mvp_helper.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yelj.ybaseframework.mvp_helper.presenter.IPresenter;

/**
 * Author: Alex.ylj
 * 2019-06-04 16:55 Tuesday
 * Description: View层的基类
 */
public abstract class ViewImpl implements IView {

    /**
     * create方法生成的view
     */
    protected View mRootView;
    /**
     * 绑定的presenter
     */
    protected IPresenter mPresenter;

    @Override
    public View create(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        created();
        return mRootView;
    }

    @Override
    public <V extends View> V findViewById(int id) {
        return (V) mRootView.findViewById(id);
    }

    @Override
    public void created() {

    }

    @Override
    public void bindPresenter(IPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void bindEvent() {

    }
}
