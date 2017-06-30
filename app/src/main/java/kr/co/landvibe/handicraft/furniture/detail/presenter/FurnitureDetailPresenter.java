package kr.co.landvibe.handicraft.furniture.detail.presenter;


public interface FurnitureDetailPresenter {

    interface View{

        void showLoading();

        void hideLoading();

        void moveToFurnitureMapActivity();

        void showContactDialog();

    }

    interface Presenter{

        void attachView(FurnitureDetailPresenter.View view);

        void detachView();

        void loadFurnitureDetailData();
    }

}
