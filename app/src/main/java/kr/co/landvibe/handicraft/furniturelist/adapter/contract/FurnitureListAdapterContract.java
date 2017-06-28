package kr.co.landvibe.handicraft.furniturelist.adapter.contract;


import java.util.List;

import kr.co.landvibe.handicraft.domain.Furniture;
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
