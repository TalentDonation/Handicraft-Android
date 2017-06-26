package kr.co.landvibe.handicraft.furniture.presenter;


import kr.co.landvibe.handicraft.furniture.adapter.contract.FurnitureAdapterContract;

public interface FurniturePresenter {
    interface View{

        void showLoading();

        void hideLoading();
    }

    interface Presenter{

        void attachView(FurniturePresenter.View view);

        void detachView();

        void setFurnitureAdapterModel(FurnitureAdapterContract.Model model);

        void setFurnitureAdapterView(FurnitureAdapterContract.View view);

        void loadFurnitureList();
    }
}
