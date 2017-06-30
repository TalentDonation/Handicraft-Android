package kr.co.landvibe.handicraft.furniture.add;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.furniture.add.presenter.FurnitureAddPresenter;
import kr.co.landvibe.handicraft.furniture.add.presenter.FurnitureAddPresenterImpl;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FurnitureAddActivity extends AppCompatActivity
    implements FurnitureAddPresenter.View{

    @BindView(R.id.toolbar_furniture_add)
    Toolbar mToolbar;

    private FurnitureAddPresenter.Presenter mFurnitureAddPresenter;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_add);
        ButterKnife.bind(this);

        init();
    }
    private void init() {
        // Toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mFurnitureAddPresenter = new FurnitureAddPresenterImpl();
        mFurnitureAddPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFurnitureAddPresenter.detachView();
    }

    /**
     * FurnitureAddPresenter.View
     */
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void backToMainActivity() {
        finish();
    }
}
