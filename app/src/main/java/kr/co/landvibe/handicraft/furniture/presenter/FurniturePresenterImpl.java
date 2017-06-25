package kr.co.landvibe.handicraft.furniture.presenter;


public class FurniturePresenterImpl implements FurniturePresenter.Presenter {

    private final static String TAG = "FurniturePresenterImpl";

    private FurniturePresenter.View view;

    @Override
    public void attachView(FurniturePresenter.View view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        this.view=null;
    }
}
