package com.yelj.yebaseframework.mvp_helper.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yelj.yebaseframework.inter.IBaseView;
import com.yelj.yebaseframework.mvp_helper.presenter.IPresenter;

/**
 * Author: Alex.ylj
 * 2019-06-04 16:50 Tuesday
 * Description: View层的根接口
 */
public interface IView extends IBaseView {

    /**
     * 根据 {@link IView#getLayoutId}方法生成生成setContentView需要的根布局
     */
    View create(LayoutInflater inflater, ViewGroup container);

    /**
     * 当Activity的onCreate完毕后调用
     */
    void created();

    /**
     * 根据id获取view
     */
    <V extends View> V findViewById(int id);

    /**
     * 绑定Presenter
     */
    void bindPresenter(IPresenter presenter);

    /**
     * {@link IView#created}后调用，可以调用{@link com.yelj.yebaseframework.mvp_helper.helper.EventHelper#click}
     * 等方法为控件设置点击事件，一般推荐使用{@link com.yelj.yebaseframework.mvp_helper.helper.EventHelper#click (IPresenter presenter, View ...views)}
     * 方法并且让你的Presenter实现相应接口。
     */
    void bindEvent();
}
