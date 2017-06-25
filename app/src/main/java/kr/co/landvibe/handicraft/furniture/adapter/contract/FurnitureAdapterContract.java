package kr.co.landvibe.handicraft.furniture.adapter.contract;


public interface FurnitureAdapterContract {

    interface View{
        void notifyAdapter();
    }

    interface Model{
        void setListData();
    }
}
