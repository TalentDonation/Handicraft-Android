package kr.co.landvibe.handicraft.furniture.preview.presenter;


public class FurniturePreviewPresenterImpl implements FurniturePreviewPresenter.Presenter {

    private FurniturePreviewPresenter.View view;

    @Override
    public void attachView(FurniturePreviewPresenter.View view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        this.view=null;
    }

    @Override
    public void loadCachedFurnitureData() {

    }
}
