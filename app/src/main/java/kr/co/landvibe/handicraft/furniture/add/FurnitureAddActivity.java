package kr.co.landvibe.handicraft.furniture.add;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.furniture.add.presenter.FurnitureAddPresenter;
import kr.co.landvibe.handicraft.furniture.add.presenter.FurnitureAddPresenterImpl;
import kr.co.landvibe.handicraft.furniture.preview.FurniturePreviewActivity;
import kr.co.landvibe.handicraft.type.StateType;
import kr.co.landvibe.handicraft.type.TradeType;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FurnitureAddActivity extends AppCompatActivity
        implements FurnitureAddPresenter.View {

    @BindView(R.id.toolbar_furniture_add)
    Toolbar mToolbar;

    @BindView(R.id.et_title)
    EditText mTitleEt;
    @BindView(R.id.et_price)
    EditText mPriceEt;
    @BindView(R.id.tv_state)
    TextView mStateTv;
    @BindView(R.id.tv_trade)
    TextView mTradeTv;

    private String mPriceText = "";

    @BindArray(R.array.state_rank)
    String[] mStateList;

    @BindArray(R.array.trade_type)
    String[] mTradeTypeList;

    private StateType currentStateType = StateType.EMPTY;
    private TradeType currentTradeType = TradeType.EMPTY;

    private AlertDialog mStateChoiceDialog;
    private AlertDialog mTradeChoiceDialog;

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

        mPriceEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()!=0 && !s.toString().equals(mPriceText)) {
                    DecimalFormat df = new DecimalFormat("###,###");
                    mPriceText = df.format(
                            Long.parseLong(s.toString().replaceAll(",", ""))
                    );
                    mPriceEt.setText(mPriceText);
                    mPriceEt.setSelection(mPriceText.length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                s.append(" 원");
            }
        });

        mStateChoiceDialog = new AlertDialog.Builder(this)
                .setTitle("상품 상태")
                .setItems(mStateList, (dialog, which) -> {
                    mStateTv.setText(mStateList[which]);
                    currentStateType=StateType.get(which);
                    mStateChoiceDialog.dismiss();
                }).create();

        mTradeChoiceDialog = new AlertDialog.Builder(this)
                .setTitle("거래 형태")
                .setItems(mTradeTypeList,((dialog, which) -> {
                    mTradeTv.setText(mTradeTypeList[which]);
                    currentTradeType=TradeType.get(which);
                    mTradeChoiceDialog.dismiss();
                })).create();

        mFurnitureAddPresenter = new FurnitureAddPresenterImpl();
        mFurnitureAddPresenter.attachView(this);
    }
    @OnClick(R.id.state_container)
    public void createStateChoiceDialog(View v){
        mStateChoiceDialog.show();
    }

    @OnClick(R.id.tv_trade_container)
    public void createTradeChoiceDialog(View v){
        mTradeChoiceDialog.show();
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

    @Override
    public void showPreviewActivity() {
        final Intent intent = new Intent(this, FurniturePreviewActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
