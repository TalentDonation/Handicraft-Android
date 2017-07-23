package kr.co.landvibe.handicraft.furniture.add;


public interface FurnitureAddContract {

    interface View{

        void showLoading();

        void hideLoading();

        void backToMainActivity();

        void showPreviewActivity();

    }

    interface Presenter{

        void attachView(FurnitureAddContract.View view);

        void detachView();

        void registerFurniture();
    }

}
