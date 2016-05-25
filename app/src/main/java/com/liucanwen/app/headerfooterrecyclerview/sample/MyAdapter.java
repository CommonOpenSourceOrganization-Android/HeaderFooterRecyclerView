package com.liucanwen.app.headerfooterrecyclerview.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter {

    private Context mContext;

    public MyAdapter(Context context) {

        mContext = context;

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = View.inflate(parent.getContext(), R.layout.adapter_list_item, null);

        return new HomeFragmentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        HomeFragmentViewHolder holder = (HomeFragmentViewHolder) viewHolder;

        char content = (char)('A' + position);

        holder.testTv.setText("" + content);
    }

    @Override
    public int getItemViewType(int position) {
        return position % 4;  //any logic can go here
    }

    public class HomeFragmentViewHolder extends RecyclerView.ViewHolder {

        TextView testTv;

        public HomeFragmentViewHolder(View itemView) {
            super(itemView);

            testTv = (TextView) itemView.findViewById(R.id.test_tv);
        }
    }
}
