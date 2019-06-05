package com.yelj.ybaseframework.mvp_helper.presenter;

import android.os.Bundle;

/**
 * Author: Alex.ylj
 * 2019-06-04 16:55 Tuesday
 * Description: Presenter的根接口
 */
public interface IPresenter<T> {

    /**
     * 获取当前presenter泛型的类型
     */
    Class<T> getViewClass();

    /**
     * View初始化之前可以在此方法做一些操作
     */
    void create(Bundle savedInstance);

    /**
     * View初始化完毕后调用
     */
    void created(Bundle savedInstance);
}
