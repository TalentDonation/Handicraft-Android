package kr.co.landvibe.handicraft.furniture.detail.presenter;


public class FurnitureDetailPresenterImpl implements FurnitureDetailPresenter.Presenter {

    private FurnitureDetailPresenter.View view;

    @Override
    public void attachView(FurnitureDetailPresenter.View view) {
        this.view=view;

    }

    @Override
    public void detachView() {
        this.view=null;

    }

    @Override
    public void loadFurnitureDetailData() {

    }
}
