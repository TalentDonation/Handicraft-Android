package kr.co.landvibe.handicraft.furniture.presenter;


public interface FurniturePresenter {
    interface View{

        void showLoading();

        void hideLoading();
    }

    interface Presenter{

        void attachView(FurniturePresenter.View view);

        void detachView();
    }
}
