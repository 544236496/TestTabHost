package com.sun.main.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.sun.main.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void firstWay(View view){
        startActivity(FirstWayActivity.createIntent(this));
    }
    public void secondWay(View view){
        startActivity(SecondWayActivity.createIntent(this));
    }
    public void thirdWay(View view){
        startActivity(ThirdWayActivity.createIntent(this));
    }
    public void forthWay(View view){
        startActivity(ForthWayActivity.createIntent(this));
    }
}
