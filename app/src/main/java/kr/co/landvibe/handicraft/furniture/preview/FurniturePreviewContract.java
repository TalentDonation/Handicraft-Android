package kr.co.landvibe.handicraft.furniture.preview;

public interface FurniturePreviewContract {

    interface View{

        void showLoading();

        void hideLoading();

        void backToAddActivity();

    }

    interface Presenter{

        void attachView(FurniturePreviewContract.View view);

        void detachView();

        void loadCachedFurnitureData();
    }
}
