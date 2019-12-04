package com.bawei.pss20191204.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.pss20191204.R;
import com.bawei.pss20191204.bean.DataBean;

import java.util.List;

/**
 * Created by Android Studio.
 * User: 潘世松
 * Date: 2019/12/4
 * Time: 9:10
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    private Context mContext;
    private List<DataBean.ListdataBean> mList;

    public MyAdapter(Context mContext, List<DataBean.ListdataBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext, R.layout.bean, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.name.setText(mList.get(i).getName() + "");
        holder.iofo.setText(mList.get(i).getInfo());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView name, iofo;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.recy_name);
            iofo = itemView.findViewById(R.id.recy_iofo);
        }
    }
}
