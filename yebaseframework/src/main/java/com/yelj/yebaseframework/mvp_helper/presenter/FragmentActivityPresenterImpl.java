package com.yelj.yebaseframework.mvp_helper.presenter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.yelj.yebaseframework.mvp_helper.helper.GenericHelper;
import com.yelj.yebaseframework.mvp_helper.view.IView;

/**
 * Author: Alex.ylj
 * 2019-06-04 17:04 Tuesday
 * Description: 将Activity作为Presenter的基类
 */
public class FragmentActivityPresenterImpl<T extends IView> extends FragmentActivity implements IPresenter<T> {

    protected String TAG = this.getClass().getSimpleName();
    protected T mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        create(savedInstanceState);

        try {
            mView = getViewClass().newInstance();
            mView.bindPresenter(this);
            setContentView(mView.create(getLayoutInflater(), null));
            mView.bindEvent();
            created(savedInstanceState);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

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

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
