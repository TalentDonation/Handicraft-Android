package kr.co.landvibe.handicraft.furniture.list.presenter;


import kr.co.landvibe.handicraft.furniture.list.adapter.contract.FurnitureListAdapterContract;

public interface FurnitureListPresenter {
    interface View{

        void showLoading();

        void hideLoading();

        void moveToFurnitureDetailActivity();
    }

    interface Presenter{

        void attachView(FurnitureListPresenter.View view);

        void detachView();

        void setFurnitureListAdapterModel(FurnitureListAdapterContract.Model model);

        void setFurnitureListAdapterView(FurnitureListAdapterContract.View view);

        void loadFurnitureList();
    }
}
