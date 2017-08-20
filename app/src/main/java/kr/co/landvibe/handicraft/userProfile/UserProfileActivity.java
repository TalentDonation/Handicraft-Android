package kr.co.landvibe.handicraft.userProfile;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.landvibe.handicraft.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class UserProfileActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_user_name)
    Toolbar mToolbar;

    @BindView(R.id.tv_user_intro)
    TextView mUser;

    @BindView(R.id.tv_work_num)
    TextView mWorkNum;

    //폰트바꾸기
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);

        init();
    }

    private void init(){
        // Toolbar
        //mToolbar = (Toolbar) findViewById(R.id.toolbar_user_name);

        //사용시 툴바를 액션바로 사용할 수 있다.
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("육상은");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @OnClick(R.id.fab)
    public void editContent(){
        //정보수정
    }

}
