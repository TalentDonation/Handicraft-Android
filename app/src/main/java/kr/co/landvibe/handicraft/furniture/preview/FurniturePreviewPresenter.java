package kr.co.landvibe.handicraft.furniture.preview;


public class FurniturePreviewPresenter implements FurniturePreviewContract.Presenter {

    private FurniturePreviewContract.View view;

    @Override
    public void attachView(FurniturePreviewContract.View view) {
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
