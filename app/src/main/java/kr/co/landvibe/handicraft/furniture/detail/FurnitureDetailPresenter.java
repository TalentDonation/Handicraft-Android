package kr.co.landvibe.handicraft.furniture.detail;


public class FurnitureDetailPresenter implements FurnitureDetailContract.Presenter {

    private FurnitureDetailContract.View view;

    @Override
    public void attachView(FurnitureDetailContract.View view) {
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
