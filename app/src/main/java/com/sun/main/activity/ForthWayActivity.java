package com.sun.main.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.sun.main.R;
import com.sun.main.fragment.DFragment;
import com.sun.main.fragment.HFragment;
import com.sun.main.fragment.JFragment;
import com.sun.main.fragment.MFragment;
import com.sun.main.fragment.VFragment;

public class ForthWayActivity extends FragmentActivity {

    private static final String V = "V";
    private static final String H = "H";
    private static final String D = "D";
    private static final String J = "J";
    private static final String M = "M";
    private String[] text = { "H", "V", "D", "J", "M" };
    private int[] icons = { R.drawable.indicator_tab_icon_h_selector,
    R.drawable.indicator_tab_icon_v_selector,
    R.drawable.indicator_tab_icon_d_selector,
    R.drawable.indicator_tab_icon_j_selector,
    R.drawable.indicator_tab_icon_m_selector};
    private String[] tags = { H, V, D,J, M };
    private TabHost mTabHost;
    private HFragment mHFragment = new HFragment();
    private VFragment mVFragment = new VFragment();
    private DFragment mDFragment = new DFragment();
    private JFragment mJFragment = new JFragment();
    private MFragment mMFragment = new MFragment();
    private FragmentManager mFragmentManager = getSupportFragmentManager();


    public static Intent createIntent(Context context){
        Intent toForthWayActivity = new Intent();
        toForthWayActivity.setClass(context,ForthWayActivity.class);
        return toForthWayActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth_way);
        mTabHost = (TabHost)findViewById(R.id.tabhost);
        mTabHost.setup();
        //初始化tab显示
        addTab();
        //默认加载第一个fragment
        showFragment("mHFragment");
        //标签切换事件处理
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            // tabId是newTabSpec第一个参数设置的tab页名，并不是layout里面的标识符id
            public void onTabChanged(String tabId) {
                if (tabId.equals(H)) {
                    Toast.makeText(ForthWayActivity.this, "H", Toast.LENGTH_SHORT).show();
                    showFragment("mHFragment");
                }
                if (tabId.equals(D)) {
                    Toast.makeText(ForthWayActivity.this, "D", Toast.LENGTH_SHORT).show();
                    showFragment("mDFragment");
                }
                if (tabId.equals(J)) {
                    Toast.makeText(ForthWayActivity.this, "J", Toast.LENGTH_SHORT).show();
                    showFragment("mJFragment");
                }
                if (tabId.equals(M)) {
                    Toast.makeText(ForthWayActivity.this, "M", Toast.LENGTH_SHORT).show();
                    showFragment("mMFragment");
                }
                if (tabId.equals(V)) {
                    Toast.makeText(ForthWayActivity.this, "V", Toast.LENGTH_SHORT).show();
                    showFragment("mVFragment");
                }
            }
        });
    }

    private void showFragment(String fragmentName) {
        FragmentTransaction mFt = mFragmentManager.beginTransaction();
        if (TextUtils.equals("mHFragment",fragmentName)) {
            mFt.replace(R.id.reallycontent,mHFragment);
        }
        if (TextUtils.equals("mVFragment",fragmentName)) {
            mFt.replace(R.id.reallycontent,mVFragment);
        }
        if (TextUtils.equals("mDFragment",fragmentName)) {
            mFt.replace(R.id.reallycontent,mDFragment);
        }
        if (TextUtils.equals("mJFragment",fragmentName)) {
            mFt.replace(R.id.reallycontent,mJFragment);
        }
        if (TextUtils.equals("mMFragment",fragmentName)) {
            mFt.replace(R.id.reallycontent,mMFragment);
        }
        mFt.commit();
    }

    //初始化tab样式
    private void addTab() {
        TabWidget tabWidget = (TabWidget) findViewById(android.R.id.tabs);
        for (int i = 0; i < text.length; i++) {
            LinearLayout mTabIndicator = (LinearLayout) LayoutInflater.from(
                    this)
                    .inflate(R.layout.tab_indicator_main, tabWidget, false);
            TextView tvTab1 = (TextView) mTabIndicator
                    .findViewById(R.id.tab_text_textview);
            tvTab1.setText(text[i]);
            ImageView tab_icon_imageView = (ImageView) mTabIndicator
                    .findViewById(R.id.tab_icon_imageView);
            tab_icon_imageView.setImageResource(icons[i]);
            TabHost.TabSpec tSpecVisa = mTabHost.newTabSpec(tags[i]);
            tSpecVisa.setIndicator(mTabIndicator);
            tSpecVisa.setContent(new DummyTabContent(getBaseContext()));
            mTabHost.addTab(tSpecVisa);
        }
    }

    //仿制品，用来虚拟填充
    public class DummyTabContent implements TabHost.TabContentFactory {
        private Context mContext;
        public DummyTabContent(Context context) {
            mContext = context;
        }
        @Override
        public View createTabContent(String tag) {
            View v = new View(mContext);
            return v;
        }
    }
}
