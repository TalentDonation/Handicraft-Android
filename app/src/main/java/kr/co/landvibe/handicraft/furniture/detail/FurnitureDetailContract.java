package kr.co.landvibe.handicraft.furniture.detail;


import kr.co.landvibe.handicraft.data.domain.Furniture;

public interface FurnitureDetailContract {

    interface View{

        void showLoading();

        void hideLoading();

        void moveToFurnitureMapActivity();

        void showContactDialog();

        void bindData(Furniture furniture);
    }

    interface Presenter{

        void attachView(FurnitureDetailContract.View view);

        void detachView();

        void loadFurniture(long id);
    }

}
