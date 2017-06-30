package kr.co.landvibe.handicraft.furniture.add.presenter;


public class FurnitureAddPresenterImpl implements FurnitureAddPresenter.Presenter {

    private FurnitureAddPresenter.View view;

    @Override
    public void attachView(FurnitureAddPresenter.View view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        this.view=null;
    }

    @Override
    public void registerFurniture() {

        // register


        // view change
        view.backToMainActivity();
    }
}
