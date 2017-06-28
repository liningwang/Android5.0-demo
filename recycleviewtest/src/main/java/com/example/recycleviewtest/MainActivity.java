package com.example.recycleviewtest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import static com.example.recycleviewtest.DividerItemDecorationMy.HORIZONTAL_LIST;
import static com.example.recycleviewtest.DividerItemDecorationMy.VERTICAL_LIST;

public class MainActivity extends AppCompatActivity {
    String[] myDataset = {"1","2","3","4","5","7","8","9","10","11","12","13","14"
    ,"15","16","17","1","2","3","4","5","7","8","9","10","11","12","13","14","15","16","17","1","2","3","4","5","7","8","9","10","11","12","13","14","15","16","17",
            "1","2","3","4","5","7","8","9","10","11","12","13","14","15","16","17"};
    private LinearLayoutManager mLayoutManager;
    RecyclerView mRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = (RecyclerView) findViewById(R.id.rv);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecycleView.setHasFixedSize(true);
//        ItemTouchHelper a;
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleView.setLayoutManager(mLayoutManager);
//        DividerItemDecorationMy a = new DividerItemDecorationMy(this,1);
        // specify an adapter (see also next example)
        MyAdapter mAdapter = new MyAdapter(myDataset);
//        mRecycleView.addItemDecoration(new ItemDivider().setDividerWith(2).setDividerColor(Color.BLUE));
        DividerItemDecorationMy a = new DividerItemDecorationMy(this,HORIZONTAL_LIST);
        mRecycleView.addItemDecoration(a);
        mRecycleView.setAdapter(mAdapter);
    }
}
