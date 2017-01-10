package com.sun.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sun.main.R;


public class JFragment extends Fragment {

    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_j, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        ListView test_listview = (ListView) rootView.findViewById(R.id.test_listview);
        test_listview.setAdapter(new ArrayAdapter(mContext,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.two_items)));
    }

}
