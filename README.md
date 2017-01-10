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

        //布局中
        <TabHost
            xmlns:android="http://schemas.android.com/apk/res/android"
            android:id="@+id/tabhost"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="1">
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical">
                <TabWidget
                    android:id="@android:id/tabs"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"/>
                <FrameLayout
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
            </LinearLayout>
        </TabHost>

        //代码中
        setContentView(R.layout.activity_second_way);
        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("标签页一").setContent(R.id.tab01));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("标签页二").setContent(R.id.tab02));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("标签页三").setContent(R.id.tab03));
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            // tabId是newTabSpec参数设置的tab页名，并不是layout里面的标识符id
            public void onTabChanged(String tabId) {
                if (tabId.equals("tab1")) {
                    Toast.makeText(SecondWayActivity.this, "点击标签页一", Toast.LENGTH_SHORT).show();
                }
                if (tabId.equals("tab2")) {
                    Toast.makeText(SecondWayActivity.this, "点击标签页二", Toast.LENGTH_SHORT).show();
                }
                if (tabId.equals("tab3")) {
                    Toast.makeText(SecondWayActivity.this, "点击标签页三", Toast.LENGTH_SHORT).show();
                }
            }
        });

    3布局中定义TabHost、TabWidget，内容分开xml文件定义，代码中将tab标签和全部内容合并（ThirdWayActivity中讲解）

        //布局中
        <TabHost
            xmlns:android="http://schemas.android.com/apk/res/android"
            android:id="@+id/tabhost"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="1">
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical">
                <TabWidget
                    android:id="@android:id/tabs"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"/>
                <FrameLayout
                    android:id="@android:id/tabcontent"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent">
                </FrameLayout>
            </LinearLayout>
        </TabHost>

        //代码中
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

  2.TabHost嵌套Fragment、自定义TabWidget样式的方法(ForthWayActivity中讲解)
    布局xml文件中定义TabHost、TabWidget、虚拟Content、实际Content
    代码中添加Fragment、绑定tab与fragment

    //布局中
    <TabHost
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/tabhost"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">
            <FrameLayout
                android:id="@android:id/tabcontent"
                android:layout_width="0dp"
                android:layout_height="0dp">
            </FrameLayout>
            <FrameLayout
                android:id="@+id/reallycontent"
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="#66666666">
            </FrameLayout>
            <TabWidget
                android:id="@android:id/tabs"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"/>
        </LinearLayout>
    </TabHost>

    //代码中
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