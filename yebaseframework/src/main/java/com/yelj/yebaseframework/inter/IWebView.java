package com.yelj.yebaseframework.inter;

import com.yelj.yebaseframework.callback.YeNoneCallback;

/**
 * Author: Alex.ylj
 * 2019-06-04 17:58 Tuesday
 * Description: WebView相关的事件
 */
public interface IWebView {

    /**
     * 是否显示关闭按钮，目前用在 webView goBack()处理
     */
    void showToolbarClose(boolean show);

    /**
     * 左侧关闭按钮 点击事件
     */
    YeNoneCallback onToolbarCloseClick();
}
