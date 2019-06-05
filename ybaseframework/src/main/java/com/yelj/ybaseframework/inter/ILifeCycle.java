package com.yelj.ybaseframework.inter;

/**
 * Author: Alex.ylj
 * 2019-06-04 16:50 Tuesday
 * Description: 生命周期方法
 */
public interface ILifeCycle extends IBaseView{

    /**
     * 初始化toolbar
     */
    void initToolbar();

    /**
     * 初始化视图
     */
    void initView();

    /**
     * 初始化数据
     */
    void initData();

    /**
     * 是否注册EventBus
     */
    boolean isRegisterEventBus();
}
