package kr.co.landvibe.handicraft.furniture.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kr.co.landvibe.handicraft.domain.Furniture;
import kr.co.landvibe.handicraft.furniture.adapter.contract.FurnitureAdapterContract;
import kr.co.landvibe.handicraft.furniture.adapter.holder.FurnitureViewHolder;
import kr.co.landvibe.handicraft.listener.OnItemClickListener;

public class FurnitureAdapter extends RecyclerView.Adapter<FurnitureViewHolder>
    implements FurnitureAdapterContract.View, FurnitureAdapterContract.Model{

    private Activity mActivity;

    private OnItemClickListener mOnItemClickListener;

    private List<Furniture> list = new ArrayList<>();

    public FurnitureAdapter(Activity activity){
        super();
        mActivity=activity;
    }

    @Override
    public FurnitureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FurnitureViewHolder(mActivity,parent,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(FurnitureViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    /**
     * FurnitureAdapterContract.View
     */
    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener=listener;
    }

    /**
    * FurnitureAdapterContract.Model
    */
    @Override
    public void setListData(List<Furniture> list) {
        this.list.clear();
        this.list.addAll(list);
    }
}
