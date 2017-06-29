package kr.co.landvibe.handicraft.furniture.detail;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.landvibe.handicraft.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FurnitureDetailActivity extends AppCompatActivity
        implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    @BindView(R.id.toolbar_furniture_detail)
    Toolbar mToolbar;

    @BindView(R.id.slider_furniture_list)
    SliderLayout mFurnitureImageSlider;

    @BindView(R.id.slider_indicator)
    PagerIndicator mPagerIndicator;

    @BindView(R.id.slider_container)
    RelativeLayout mSliderContainer;

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

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.f1);
        file_maps.put("Big Bang Theory",R.drawable.f3);
        file_maps.put("House of Cards",R.drawable.f5);
        file_maps.put("Game of Thrones", R.drawable.f8);

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

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int height = metrics.heightPixels*6/10;
        setSliderHeight(height);
    }
    private void setSliderHeight(int height){
        mFurnitureImageSlider.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,height));
    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation
        mFurnitureImageSlider.stopAutoCycle();
        super.onStop();
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
}
