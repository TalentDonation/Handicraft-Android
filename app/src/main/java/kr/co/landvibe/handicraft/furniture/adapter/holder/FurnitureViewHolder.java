package kr.co.landvibe.handicraft.furniture.adapter.holder;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.listener.OnItemClickListener;

public class FurnitureViewHolder extends RecyclerView.ViewHolder{

    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    public FurnitureViewHolder(Context context, ViewGroup parent, OnItemClickListener listener){
        super(LayoutInflater.from(context).inflate(R.layout.viewholder_funiture_list,parent,false));

        mContext=context;

        mOnItemClickListener=listener;

        ButterKnife.bind(this, itemView);
    }

    private void onBind(){

    }


}
