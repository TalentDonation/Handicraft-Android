package kr.co.landvibe.handicraft.introduction;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.landvibe.handicraft.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class IntroductionActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;

    @BindView(R.id.bt_workshop_intro)
    Button mIntro;

    @BindView(R.id.bt_class)
    Button mClass;

    @BindView(R.id.bt_directions_intro)
    Button mDirections;

    @BindView(R.id.tv_workshop_content)
    TextView mIntro_TV;

    private int i,j,k = 0;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        ButterKnife.bind(this);
        mIntro.setOnClickListener(this);
        mClass.setOnClickListener(this);
        mDirections.setOnClickListener(this);

        init();

    }

    private void init(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar_intro_name);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_workshop_intro:
                if(i == 0){
                    mIntro_TV.setVisibility(View.VISIBLE);
                    i = 1;
                    mIntro.setText("-");
                }
                else {
                    mIntro_TV.setVisibility(View.GONE);
                    i = 0;
                    mIntro.setText("+");
                }

        }

    }
}
