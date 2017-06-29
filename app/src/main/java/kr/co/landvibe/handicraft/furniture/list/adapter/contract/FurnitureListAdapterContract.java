package kr.co.landvibe.handicraft.furniture.list.adapter.contract;


import java.util.List;

import kr.co.landvibe.handicraft.data.domain.Furniture;
import kr.co.landvibe.handicraft.listener.OnItemClickListener;

public interface FurnitureListAdapterContract {

    interface View{
        void notifyAdapter();

        void setOnItemClickListener(OnItemClickListener listener);
    }

    interface Model{
        void setListData(List<Furniture> list);
    }
}
