package com.yelj.yebaseframework.inter;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.yelj.yebaseframework.callback.YeNoneCallback;

/**
 * Author: Alex.ylj
 * 2019-06-04 16:50 Tuesday
 * Description: toolbar方法
 */
public interface IToolbar {

    //左上角navigation按钮的事件，一般为返回键
    //左上角navigation按钮的事件，一般为返回键
    //左上角navigation按钮的事件，一般为返回键

    /**
     * 是否显示 navigation icon
     */
    boolean isShowNavigation();

    /**
     * 设置 navigation 图标
     */
    int getNavigationIcon();

    /**
     * navigation 点击事件
     */
    YeNoneCallback onNavigationClick();

    //关闭按钮，目前用在 webView goBack()处理
    //关闭按钮，目前用在 webView goBack()处理
    //关闭按钮，目前用在 webView goBack()处理

    /**
     * 设置关闭按钮的图标
     */
    int getToolbarCloseIcon();

    //标题事件
    //标题事件
    //标题事件

    /**
     * @return str
     */
    String getTitleStr();

    /**
     * @return resId
     */
    int getTitleRes();

    /**
     * 设置标题
     *
     * @param s str
     */
    void setToolbarTitle(String s);

    /**
     * 设置标题
     *
     * @param stringId resId
     */
    void setToolbarTitle(@StringRes int stringId);

    //右侧菜单
    //右侧菜单
    //右侧菜单

    /**
     * @return 文本resId
     */
    int[] getMenuTextRes();

    /**
     * @return 文本str
     */
    String[] getMenuTextStr();

    /**
     * 设置菜单文字
     */
    void setMenuText(String s, int index);

    /**
     * 设置菜单文字
     */
    void setMenuText(int stringId, int index);

    /**
     * @return 菜单icon
     */
    int[] getMenuIcon();

    /**
     * 设置菜单icon
     */
    void setMenuIcon(@DrawableRes int drawableId, int index);

    /**
     * menu点击事件
     */
    void onMenuItemClick(int position);
}
