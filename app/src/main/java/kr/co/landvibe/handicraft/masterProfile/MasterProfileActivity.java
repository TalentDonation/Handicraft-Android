package kr.co.landvibe.handicraft.masterProfile;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.landvibe.handicraft.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MasterProfileActivity extends AppCompatActivity {

    public final static String TAG = "MasterProfileActivity";

    @BindView(R.id.toolbar_master_name)
    Toolbar mToolbar;

    @BindView(R.id.tv_mobile)
    TextView mMobileNumberTv;

    @BindView(R.id.tv_work)
    TextView mWorkNumberTv;

    @BindView(R.id.tv_email)
    TextView mEmailTv;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_profile);
        ButterKnife.bind(this);

        /**
         * @TODO 취미, sns(인스타,페북), 한마디?
         */

        init();
    }
    private void init(){
        // Toolbar
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("김건희");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
