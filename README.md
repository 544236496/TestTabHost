# TestTabHost

  1.TabHost基础使用方法（三种方法）
    1.布局中只定义内容xml样式、代码中获取TabHost，动态添加全部内容界面和tab标签进来（FirstWayActivity中讲解）

    //布局中
    <FrameLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@android:id/tabcontent"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <!-- 定义第一个标签页的内容 -->
        <LinearLayout
            android:id="@+id/tab01"
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:background="#99999999">
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="标签页一"
                android:textSize="8pt"
                android:gravity="center"/>
        </LinearLayout>
        <!-- 定义第二个标签页的内容 -->
        <LinearLayout
            android:id="@+id/tab02"
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:background="#777777">
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="标签页二"
                android:textSize="8pt" />
        </LinearLayout>
        <!-- 定义第三个标签页的内容 -->
        <LinearLayout
            android:id="@+id/tab03"
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:background="#333333">
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="标签页三"
                android:textSize="8pt" />
        </LinearLayout>
    </FrameLayout>

    //代码中
     // 1.获取该Activity里面的TabHost组件
            TabHost tabHost = getTabHost();
            LayoutInflater.from(this).inflate(R.layout.activity_first_way,
                    tabHost.getTabContentView(), true);
            tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("标签页一").setContent(R.id.tab01));
            tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("标签页二").setContent(R.id.tab02));
            tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("标签页三").setContent(R.id.tab03));
            //2.标签切换事件处理，setOnTabChangedListener
            tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
                @Override
                // tabId是newTabSpec参数设置的tab页名，并不是layout里面的标识符id
                public void onTabChanged(String tabId) {
                    if (tabId.equals("tab1")) {
                        Toast.makeText(FirstWayActivity.this, "点击标签页一", Toast.LENGTH_SHORT).show();
                    }
                    if (tabId.equals("tab2")) {
                        Toast.makeText(FirstWayActivity.this, "点击标签页二", Toast.LENGTH_SHORT).show();
                    }
                    if (tabId.equals("tab3")) {
                        Toast.makeText(FirstWayActivity.this, "点击标签页三", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    2.布局中定义TabHost、TabWidget、全部内容，代码中将tab标签和全部内容合并（SecondWayActivity中讲解）
    3布局中定义TabHost、TabWidget，内容分开xml文件定义，代码中将tab标签和全部内容合并（ThirdWayActivity中讲解）

  2.TabHost嵌套Fragment、自定义TabWidget样式的方法(ForthWayActivity中讲解)
    布局xml文件中定义TabHost、TabWidget、虚拟Content、实际Content
    代码中添加Fragment、绑定tab与fragment
