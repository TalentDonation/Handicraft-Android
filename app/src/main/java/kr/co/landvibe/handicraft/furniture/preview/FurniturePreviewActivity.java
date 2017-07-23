package kr.co.landvibe.handicraft.furniture.preview;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.landvibe.handicraft.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FurniturePreviewActivity extends AppCompatActivity
    implements FurniturePreviewContract.View {

    @BindView(R.id.toolbar_furniture_preview)
    Toolbar mToolbar;

    private FurniturePreviewContract.Presenter mFurniturePreviewPresenter;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_preview);
        ButterKnife.bind(this);

        init();
    }
    private void init() {
        // Toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mFurniturePreviewPresenter = new FurniturePreviewPresenter();
        mFurniturePreviewPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFurniturePreviewPresenter.detachView();
    }


    /**
     * FurniturePreviewContract.View
     */
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void backToAddActivity() {
        finish();
    }
}
