package kr.co.landvibe.handicraft.masterProfile;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.landvibe.handicraft.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MasterProfileActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_master_name)
    Toolbar mToolbar;

    @BindView(R.id.tv_mobile)
    TextView mMobileNumberTv;

    @BindView(R.id.tv_work)
    TextView mWorkNumberTv;

    @BindView(R.id.tv_email)
    TextView mEmailTv;

    @BindView(R.id.tv_instagram)
    TextView mInstagramTv;

    @BindString(R.string.master_instagram_url)
    String instagramUrl;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_profile);
        ButterKnife.bind(this);

        init();
    }
    private void init(){
        // Toolbar
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("김건희");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @OnClick(R.id.fab)
    public void contactMaster(View v){
        // TODO fab에 이벤트 달기
    }

    @OnClick(R.id.iv_btn_mobile_icon)
    public void callMobile(View v){
        String mobileNumber = mMobileNumberTv.getText().toString();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder
                .setTitle("사장님과 통화")
                .setMessage("핸드폰 번호 : " + mobileNumber)
                .setPositiveButton("통화",(dialog, which) -> {
                    // call mobile number
                    Uri uri = Uri.parse("tel:"+mobileNumber);
                    Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(intent);
                })
                .setNegativeButton("취소", (dialog, which) -> dialog.cancel());

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    @OnClick(R.id.iv_btn_work_icon)
    public void callWork(View v){
        String workNumber = mWorkNumberTv.getText().toString();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder
                .setTitle("사장님과 통화")
                .setMessage("공방 번호 : " + workNumber)
                .setPositiveButton("통화",(dialog, which) -> {
                    // call mobile number
                    Uri uri = Uri.parse("tel:"+workNumber);
                    Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(intent);
                })
                .setNegativeButton("취소", (dialog, which) -> dialog.cancel());

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @OnClick(R.id.iv_btn_email_icon)
    public void sendEmail(View v){
        String email = mEmailTv.getText().toString();
        Uri uri = Uri.parse("mailto:"+email);
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(it);
    }

    @OnClick(R.id.iv_btn_instagram_icon)
    public void showInstagram(View v){
        Uri uri = Uri.parse(instagramUrl);
        Intent it  = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }
}
