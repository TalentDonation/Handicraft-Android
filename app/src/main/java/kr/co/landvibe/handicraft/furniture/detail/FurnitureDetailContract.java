package kr.co.landvibe.handicraft.furniture.detail;


public interface FurnitureDetailContract {

    interface View{

        void showLoading();

        void hideLoading();

        void moveToFurnitureMapActivity();

        void showContactDialog();

    }

    interface Presenter{

        void attachView(FurnitureDetailContract.View view);

        void detachView();

        void loadFurnitureDetailData();
    }

}
