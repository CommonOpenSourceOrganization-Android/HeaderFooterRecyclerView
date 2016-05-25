package com.liucanwen.app.headerfooterrecyclerview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.liucanwen.app.headerfooterrecyclerview.ExStaggeredGridLayoutManager;
import com.liucanwen.app.headerfooterrecyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.liucanwen.app.headerfooterrecyclerview.HeaderSpanSizeLookup;
import com.liucanwen.app.headerfooterrecyclerview.RecyclerViewUtils;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private CardView linearLayoutBtn, staggeredGridBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        linearLayoutBtn = (CardView) findViewById(R.id.linearLayout_layout);
        staggeredGridBtn = (CardView) findViewById(R.id.staggeredgridlayout_layout);

        linearLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                refreshRecyclerView(1);
            }
        });

        staggeredGridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                refreshRecyclerView(3);
            }
        });

        refreshRecyclerView(3);
    }

    private void refreshRecyclerView(int column) {

        MyAdapter myAdapter = new MyAdapter(MainActivity.this);
        HeaderAndFooterRecyclerViewAdapter adapter = new HeaderAndFooterRecyclerViewAdapter(myAdapter);
        recyclerView.setAdapter(adapter);

        ExStaggeredGridLayoutManager staggeredGridLayoutManager = new ExStaggeredGridLayoutManager(column, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter) recyclerView.getAdapter(), staggeredGridLayoutManager.getSpanCount()));
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        View headerView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_header, null);
        View footerView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_footer, null);

        RecyclerViewUtils.setHeaderView(recyclerView, headerView);
        RecyclerViewUtils.setFooterView(recyclerView, footerView);
    }

}
