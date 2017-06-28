package kr.co.landvibe.handicraft.furniturelist.presenter;


import kr.co.landvibe.handicraft.furniturelist.adapter.contract.FurnitureListAdapterContract;

public interface FurnitureListPresenter {
    interface View{

        void showLoading();

        void hideLoading();
    }

    interface Presenter{

        void attachView(FurnitureListPresenter.View view);

        void detachView();

        void setFurnitureListAdapterModel(FurnitureListAdapterContract.Model model);

        void setFurnitureListAdapterView(FurnitureListAdapterContract.View view);

        void loadFurnitureList();
    }
}
