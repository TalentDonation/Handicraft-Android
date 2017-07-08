package kr.co.landvibe.handicraft.furniture.preview.presenter;

public interface FurniturePreviewPresenter {

    interface View{

        void showLoading();

        void hideLoading();

        void backToAddActivity();

    }

    interface Presenter{

        void attachView(FurniturePreviewPresenter.View view);

        void detachView();

        void loadCachedFurnitureData();
    }
}
