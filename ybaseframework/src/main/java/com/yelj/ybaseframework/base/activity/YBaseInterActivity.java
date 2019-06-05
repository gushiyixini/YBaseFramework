package com.yelj.ybaseframework.base.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yelj.ybaseframework.R;
import com.yelj.ybaseframework.callback.YNoneCallback;
import com.yelj.ybaseframework.inter.IBaseView;
import com.yelj.ybaseframework.inter.ILifeCycle;
import com.yelj.ybaseframework.inter.IToolbar;
import com.yelj.ybaseframework.inter.IWebView;

/**
 * Author: Alex.ylj
 * 2019-06-04 18:17 Tuesday
 * Description:
 */
public abstract class YBaseInterActivity extends AppCompatActivity implements IBaseView, ILifeCycle, IToolbar, IWebView {

    private Toolbar toolbar;
    private TextView toolbar_title;
    private ImageView toolbar_close;

    @Override
    public void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        if (null != toolbar) {
            toolbar.setTitle("");
            toolbar_title = findViewById(R.id.toolbar_title);
            ImageView toolbar_back = findViewById(R.id.toolbar_back);
            toolbar_close = findViewById(R.id.toolbar_close);
            if (null != toolbar_title) {
                if (getTitleRes() != 0) {
                    toolbar_title.setText(getTitleRes());
                }
                if (null != getTitleStr()) {
                    toolbar_title.setText(getTitleStr());
                }
            }

            if (isShowNavigation()) {
                toolbar_back.setVisibility(View.VISIBLE);
                if (getNavigationIcon() != 0) {
                    //navigation
                    toolbar_back.setImageResource(getNavigationIcon());
                    toolbar_back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (null != onNavigationClick()) {
                                onNavigationClick().onCallback();
                            }
                        }
                    });
                } else {
                    toolbar_back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            onBackPressed();
                        }
                    });
                }
            } else {
                toolbar_back.setVisibility(View.GONE);
            }

            if (null != toolbar_close) {
                toolbar_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (null != onToolbarCloseClick()) {
                            onToolbarCloseClick().onCallback();
                        }
                    }
                });
            }
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean isRegisterEventBus() {
        return false;
    }

    @Override
    public boolean isShowNavigation() {
        return true;
    }

    @Override
    public int getNavigationIcon() {
        return 0;
    }

    @Override
    public YNoneCallback onNavigationClick() {
        return null;
    }

    @Override
    public int getToolbarCloseIcon() {
        return 0;
    }

    @Override
    public String getTitleStr() {
        return null;
    }

    @Override
    public int getTitleRes() {
        return 0;
    }

    @Override
    public void setToolbarTitle(String s) {
        if (null != toolbar_title) {
            toolbar_title.setText(s);
        }
    }

    @Override
    public void setToolbarTitle(int stringId) {
        if (null != toolbar_title) {
            toolbar_title.setText(stringId);
        }
    }

    @Override
    public int[] getMenuTextRes() {
        return new int[0];
    }

    @Override
    public String[] getMenuTextStr() {
        return new String[0];
    }

    @Override
    public void setMenuText(String s, int index) {
        Menu menu = toolbar.getMenu();
        if (menu.size() > 0) {
            menu.getItem(index).setTitle(s);
        }
    }

    @Override
    public void setMenuText(int stringId, int index) {
        Menu menu = toolbar.getMenu();
        if (menu.size() > 0) {
            menu.getItem(index).setTitle(stringId);
        }
    }

    @Override
    public int[] getMenuIcon() {
        return new int[0];
    }

    @Override
    public void setMenuIcon(int drawableId, int index) {
        Menu menu = toolbar.getMenu();
        if (menu.size() > 0) {
            menu.getItem(index).setIcon(drawableId);
        }
    }

    @Override
    public void onMenuItemClick(int position) {

    }

    @Override
    public void showToolbarClose(boolean show) {
        if (null != toolbar_close) {
            if (show) {
                toolbar_close.setVisibility(View.VISIBLE);
            } else {
                toolbar_close.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public YNoneCallback onToolbarCloseClick() {
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String[] menuItemStr = getMenuTextStr();
        if (null != menuItemStr && menuItemStr.length > 0) {
            int[] menuIconIds = getMenuIcon();
            for (int i = 0; i < menuItemStr.length; i++) {
                if (null != menuIconIds) {
                    menu.add(0, i, i, menuItemStr[i]).setIcon(menuIconIds[i]);
                } else {
                    menu.add(0, i, i, menuItemStr[i]);
                }
            }
        }

        int[] menuItemRes = getMenuTextRes();
        if (null != menuItemRes && menuItemRes.length > 0) {
            int[] menuIconIds = getMenuIcon();
            for (int i = 0; i < menuItemRes.length; i++) {
                if (null != menuIconIds) {
                    menu.add(0, i, i, menuItemRes[i]).setIcon(menuIconIds[i]);
                } else {
                    menu.add(0, i, i, menuItemRes[i]);
                }
            }
        }

        int ct = menu.size();
        for (int i = 0; i < ct; i++) {
            MenuItem mi = menu.getItem(i);
            mi.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (null != getMenuTextRes() || null != getMenuTextStr()) {
            onMenuItemClick(item.getItemId());
        }
        return super.onOptionsItemSelected(item);
    }
}
