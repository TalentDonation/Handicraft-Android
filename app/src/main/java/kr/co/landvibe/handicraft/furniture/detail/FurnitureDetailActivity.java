package kr.co.landvibe.handicraft.furniture.detail;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.furniture.detail.presenter.FurnitureDetailPresenter;
import kr.co.landvibe.handicraft.furniture.detail.presenter.FurnitureDetailPresenterImpl;
import kr.co.landvibe.handicraft.furniture.map.LocationActivity;
import kr.co.landvibe.handicraft.utils.LogUtil;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FurnitureDetailActivity extends AppCompatActivity
        implements FurnitureDetailPresenter.View, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    @BindView(R.id.toolbar_furniture_detail)
    Toolbar mToolbar;

    @BindView(R.id.slider_furniture_list)
    SliderLayout mFurnitureImageSlider;

    @BindView(R.id.slider_indicator)
    PagerIndicator mPagerIndicator;

    @BindView(R.id.slider_container)
    RelativeLayout mSliderContainer;

    @BindView(R.id.tv_furniture_title)
    TextView mTitleTv;
    @BindView(R.id.tv_furniture_price)
    TextView mPriceTv;
    @BindView(R.id.tv_furniture_state)
    TextView mStateTv;
    @BindView(R.id.tv_furniture_grade)
    TextView mGradeTv;
    @BindView(R.id.tv_furniture_time)
    TextView mTimeTv;
    @BindView(R.id.tv_furniture_brand)
    TextView mBrandTv;
    @BindView(R.id.tv_furniture_type)
    TextView mTypeTv;
    @BindView(R.id.tv_furniture_period)
    TextView mPeriodTv;
    @BindView(R.id.tv_furniture_size)
    TextView mSizeTv;
    @BindView(R.id.tv_furniture_desc)
    TextView mDescTv;
    @BindView(R.id.tv_furniture_location)
    TextView mLocationTv;

    private FurnitureDetailPresenter.Presenter mFurnitureDetailPresenter;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_detail);
        ButterKnife.bind(this);

        init();
    }
    private void init(){
        // Toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // mockup data
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.f1);
        file_maps.put("Big Bang Theory",R.drawable.f3);
        file_maps.put("House of Cards",R.drawable.f5);
        file_maps.put("Game of Thrones", R.drawable.f8);

        // Image Slider
        for(String name : file_maps.keySet()){
            DefaultSliderView defaultSliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            defaultSliderView
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);

            //add your extra information
//            textSliderView.bundle(new Bundle());
//            textSliderView.getBundle()
//                    .putString("extra",name);
            mFurnitureImageSlider.addSlider(defaultSliderView);
        }
        mFurnitureImageSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mFurnitureImageSlider.setCustomIndicator(mPagerIndicator);
        mFurnitureImageSlider.addOnPageChangeListener(this);
        setSliderHeight(mFurnitureImageSlider);


        mFurnitureDetailPresenter = new FurnitureDetailPresenterImpl();
        mFurnitureDetailPresenter.attachView(this);
        mFurnitureDetailPresenter.loadFurnitureDetailData();

    }

    private void setSliderHeight(SliderLayout slider){
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int height = metrics.heightPixels*6/10;
        slider.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,height));
    }

    @OnClick(R.id.tv_furniture_location)
    public void moveToFurnitureMapActivity(View v){
        moveToFurnitureMapActivity();
    }

    @OnClick(R.id.star_container)
    public void starAtThisFurniture(View v){
        LogUtil.d("starAtThisFurniture()");
    }

    @OnClick(R.id.buy_container)
    public void contactToSeller(View v){
        LogUtil.d("contactToSeller()");
    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation
        mFurnitureImageSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFurnitureDetailPresenter.detachView();
    }

    /**
     * BaseSliderView.OnSliderClickListener
     * @param slider
     */
    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    /**
     * ViewPagerEx.OnPageChangeListener
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * FurnitureDetailPresenter.View
     */
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void moveToFurnitureMapActivity() {
        final Intent intent = new Intent(this, LocationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    @Override
    public void showContactDialog() {

    }
}
