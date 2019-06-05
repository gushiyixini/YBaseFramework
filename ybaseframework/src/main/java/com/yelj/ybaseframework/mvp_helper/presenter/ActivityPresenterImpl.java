package com.yelj.ybaseframework.mvp_helper.presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yelj.ybaseframework.mvp_helper.helper.GenericHelper;
import com.yelj.ybaseframework.mvp_helper.view.IView;

/**
 * Author: Alex.ylj
 * 2019-06-04 17:04 Tuesday
 * Description: 将Activity作为Presenter的基类
 */
public class ActivityPresenterImpl<T extends IView> extends AppCompatActivity implements IPresenter<T> {
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
    public void create(Bundle savedInstance) {}

    @Override
    public void created(Bundle savedInstance) {}
}
