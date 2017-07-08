package kr.co.landvibe.handicraft.furniture.add.presenter;


public interface FurnitureAddPresenter {

    interface View{

        void showLoading();

        void hideLoading();

        void backToMainActivity();

        void showPreviewActivity();

    }

    interface Presenter{

        void attachView(FurnitureAddPresenter.View view);

        void detachView();

        void registerFurniture();
    }

}
