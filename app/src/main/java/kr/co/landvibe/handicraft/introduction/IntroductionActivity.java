package kr.co.landvibe.handicraft.introduction;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.main.ViewPageAdapter;
import kr.co.landvibe.handicraft.utils.LogUtils;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class IntroductionActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_info)
    Toolbar mToolbar;

    @BindView(R.id.viewPager_info)
    ViewPager mViewPager;

    @BindView(R.id.toolbar_info_tab)
    TabLayout mTabLayout;

    @BindArray(R.array.tab_info)
    String[] tabName;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        ButterKnife.bind(this);

        init();

    }

    private void init(){
        // Tab
        Observable.fromArray(tabName)
                .subscribe(
                        name -> mTabLayout.addTab(mTabLayout.newTab().setText(name)),    // binding
                        Throwable::printStackTrace,                                     // error
                        () -> LogUtils.d("onComplete"));                                // completed

        // View Pager
        mViewPager.setAdapter(new introPageAdapter(getSupportFragmentManager(), mTabLayout.getTabCount()));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        // Tab Event
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
