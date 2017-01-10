package com.sun.main.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.Toast;

import com.sun.main.R;

public class ThirdWayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        TabHost tabHost = (TabHost)findViewById(R.id.tabhost);
        tabHost.setup();

        //动态载入xml，不需要Activity
        LayoutInflater.from(this).inflate(R.layout.tab01, tabHost.getTabContentView());
        LayoutInflater.from(this).inflate(R.layout.tab02, tabHost.getTabContentView());
        LayoutInflater.from(this).inflate(R.layout.tab03, tabHost.getTabContentView());

        /*TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1")
                .setIndicator("标签页一") // 设置标题
                .setContent(R.id.tab01); //设置内容
        tabHost.addTab(tab1);
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2")
                .setIndicator("标签页二")
                .setContent(R.id.tab02);
        tabHost.addTab(tab2);
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3")
                .setIndicator("标签页三")
                .setContent(R.id.tab03);
        tabHost.addTab(tab3);*/

        /* 以上代码也可以实现 */
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("标签页一").setContent(R.id.tab01));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("标签页二").setContent(R.id.tab02));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("标签页三").setContent(R.id.tab03));

        //标签切换事件处理，setOnTabChangedListener
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            // tabId是newTabSpec第一个参数设置的tab页名，并不是layout里面的标识符id
            public void onTabChanged(String tabId) {
                if (tabId.equals("tab1")) {
                    Toast.makeText(ThirdWayActivity.this, "点击标签页一", Toast.LENGTH_SHORT).show();
                }
                if (tabId.equals("tab2")) {
                    Toast.makeText(ThirdWayActivity.this, "点击标签页二", Toast.LENGTH_SHORT).show();
                }
                if (tabId.equals("tab3")) {
                    Toast.makeText(ThirdWayActivity.this, "点击标签页三", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static Intent createIntent(Context context){
        Intent toThirdActivity = new Intent();
        toThirdActivity.setClass(context,ThirdWayActivity.class);
        return toThirdActivity;
    }
}
