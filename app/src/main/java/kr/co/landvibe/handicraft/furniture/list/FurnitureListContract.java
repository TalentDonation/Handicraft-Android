package kr.co.landvibe.handicraft.furniture.list;


import kr.co.landvibe.handicraft.furniture.list.adapter.contract.FurnitureListAdapterContract;

public interface FurnitureListContract {
    interface View{

        void showLoading();

        void hideLoading();

        void moveToFurnitureDetailActivity(long id);

        void moveToFurnitureAddActivity();

    }

    interface Presenter{

        void attachView(FurnitureListContract.View view);

        void detachView();

        void setFurnitureListAdapterModel(FurnitureListAdapterContract.Model model);

        void setFurnitureListAdapterView(FurnitureListAdapterContract.View view);

        void loadFurnitureList();
    }
}
