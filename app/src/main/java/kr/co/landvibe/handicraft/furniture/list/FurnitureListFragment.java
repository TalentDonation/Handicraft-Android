package kr.co.landvibe.handicraft.furniture.list;


import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ybq.android.spinkit.SpinKitView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.furniture.add.FurnitureAddActivity;
import kr.co.landvibe.handicraft.furniture.detail.FurnitureDetailActivity;
import kr.co.landvibe.handicraft.furniture.list.adapter.FurnitureListAdapter;
import kr.co.landvibe.handicraft.furniture.list.presenter.FurnitureListPresenter;
import kr.co.landvibe.handicraft.furniture.list.presenter.FurnitureListPresenterImpl;
import kr.co.landvibe.handicraft.utils.LogUtil;

public class FurnitureListFragment extends Fragment
        implements FurnitureListPresenter.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_furniture_list)
    RecyclerView mFurnitureListView;

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.pb_loading_indicator)
    SpinKitView mLoadingIndicator;

    private FurnitureListAdapter mFurnitureListAdapter;

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    private FurnitureListPresenterImpl mFurnitureListPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_furniture_list, container, false);
        ButterKnife.bind(this, view);
        LogUtil.d("onCreateView()");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.d("onActivityCreated()");

        init();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        switch (newConfig.orientation){
            case Configuration.ORIENTATION_LANDSCAPE:
                mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                break;
        }
    }

    private void init(){

        // Swipe Refresh
        mSwipeRefreshLayout.setOnRefreshListener(this);

        // Set RecyclerView
        mFurnitureListAdapter = new FurnitureListAdapter(getActivity());
        mFurnitureListView.setAdapter(mFurnitureListAdapter);
        //mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        onConfigurationChanged(Resources.getSystem().getConfiguration());
        mFurnitureListView.setLayoutManager(mStaggeredGridLayoutManager);
        mFurnitureListView.setHasFixedSize(true);

        // Set Presenter
        mFurnitureListPresenter = new FurnitureListPresenterImpl();
        mFurnitureListPresenter.attachView(this);
        mFurnitureListPresenter.setFurnitureListAdapterModel(mFurnitureListAdapter);
        mFurnitureListPresenter.setFurnitureListAdapterView(mFurnitureListAdapter);

        // Load Data
        mFurnitureListPresenter.loadFurnitureList();

    }

    @OnClick(R.id.fab_register)
    public void moveToAddPage(View v){
        moveToFurnitureAddActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFurnitureListPresenter.detachView();
        mFurnitureListPresenter=null;
    }


    /**
     * FurnitureListPresenter.View
     */
    @Override
    public void showLoading() {
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoadingIndicator.setVisibility(View.INVISIBLE);
    }

    @Override
    public void moveToFurnitureDetailActivity() {
        final Intent intent = new Intent(getActivity(), FurnitureDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    @Override
    public void moveToFurnitureAddActivity() {
        final Intent intent = new Intent(getActivity(), FurnitureAddActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        mFurnitureListPresenter.loadFurnitureList();

        mSwipeRefreshLayout.setRefreshing(false);
    }
}
