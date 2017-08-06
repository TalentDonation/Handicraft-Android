package kr.co.landvibe.handicraft.furniture.list.adapter.holder;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.data.domain.Furniture;
import kr.co.landvibe.handicraft.listener.OnItemClickListener;

public class FurnitureListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_furniture_image)
    ImageView mFurnitureImage;

    @BindView(R.id.tv_furniture_title)
    TextView mTitle;

    @BindView(R.id.tv_furniture_state)
    TextView mState;

    @BindView(R.id.tv_furniture_desc)
    TextView mDescription;

    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    public FurnitureListViewHolder(Context context, ViewGroup parent, OnItemClickListener listener) {
        super(LayoutInflater.from(context).inflate(R.layout.viewholder_funiture_list, parent, false));

        mContext = context;
        mOnItemClickListener = listener;

        ButterKnife.bind(this, itemView);
    }

    public void onBind(Furniture furniture) {
        if (furniture.getImageUrl() != null && furniture.getImageUrl().size() > 0) {
            Glide.with(mContext)
                    .load(furniture.getImageUrl().get(0))
                    .thumbnail(0.2f)
                    .into(mFurnitureImage);
        }

        mTitle.setText(furniture.getTitle());
        mState.setText(furniture.getState());
        mDescription.setText(furniture.getDescription());

        itemView.setOnClickListener(v -> mOnItemClickListener.onItemClick(furniture));
    }


}
