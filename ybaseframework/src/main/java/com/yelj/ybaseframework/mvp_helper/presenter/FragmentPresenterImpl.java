package com.yelj.ybaseframework.mvp_helper.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yelj.ybaseframework.mvp_helper.helper.GenericHelper;
import com.yelj.ybaseframework.mvp_helper.view.IView;

/**
 * Author: Alex.ylj
 * 2019-06-04 17:04 Tuesday
 * Description: Fragment作为Presenter的基类
 */
public class FragmentPresenterImpl<T extends IView> extends Fragment implements IPresenter<T> {
    String mSimpleName = this.getClass().getSimpleName();
    protected T mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        create(savedInstanceState);
        try {
            mView = getViewClass().newInstance();
            View view = mView.create(inflater, container);
            mView.bindPresenter(this);
            mView.bindEvent();
            created(savedInstanceState);
            return view;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * @Override public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
     * super.onViewStateRestored(savedInstanceState);
     * if (mView == null) {
     * try {
     * mView = getViewClass().newInstance();
     * } catch (java.lang.InstantiationException e) {
     * e.printStackTrace();
     * } catch (IllegalAccessException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */

    @Override
    public Class<T> getViewClass() {
        return GenericHelper.getViewClass(getClass());
    }

    @Override
    public void create(Bundle savedInstance) {

    }

    @Override
    public void created(Bundle savedInstance) {

    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }
}