package kr.co.landvibe.handicraft.furniturelist.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kr.co.landvibe.handicraft.domain.Furniture;
import kr.co.landvibe.handicraft.furniturelist.adapter.contract.FurnitureListAdapterContract;
import kr.co.landvibe.handicraft.furniturelist.adapter.holder.FurnitureListViewHolder;
import kr.co.landvibe.handicraft.listener.OnItemClickListener;

public class FurnitureListAdapter extends RecyclerView.Adapter<FurnitureListViewHolder>
    implements FurnitureListAdapterContract.View, FurnitureListAdapterContract.Model{

    private Activity mActivity;

    private OnItemClickListener mOnItemClickListener;

    private List<Furniture> list = new ArrayList<>();

    public FurnitureListAdapter(Activity activity){
        super();
        mActivity=activity;
    }

    @Override
    public FurnitureListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FurnitureListViewHolder(mActivity,parent,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(FurnitureListViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    /**
     * FurnitureListAdapterContract.View
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
    * FurnitureListAdapterContract.Model
    */
    @Override
    public void setListData(List<Furniture> list) {
        this.list.clear();
        this.list.addAll(list);
    }
}
