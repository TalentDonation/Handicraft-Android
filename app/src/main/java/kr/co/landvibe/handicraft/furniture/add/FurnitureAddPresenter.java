package kr.co.landvibe.handicraft.furniture.add;


public class FurnitureAddPresenter implements FurnitureAddContract.Presenter {

    private FurnitureAddContract.View view;

    @Override
    public void attachView(FurnitureAddContract.View view) {
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
