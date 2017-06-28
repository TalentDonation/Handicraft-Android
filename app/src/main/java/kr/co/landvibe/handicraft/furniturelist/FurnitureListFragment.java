package kr.co.landvibe.handicraft.furniturelist;


import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ybq.android.spinkit.SpinKitView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.furniturelist.adapter.FurnitureListAdapter;
import kr.co.landvibe.handicraft.furniturelist.presenter.FurnitureListPresenter;
import kr.co.landvibe.handicraft.furniturelist.presenter.FurnitureListPresenterImpl;
import kr.co.landvibe.handicraft.utils.LogUtil;

public class FurnitureListFragment extends Fragment implements FurnitureListPresenter.View{

    @BindView(R.id.rv_furniture_list)
    RecyclerView mFurnitureListView;

    @BindView(R.id.pb_loading_indicator)
    SpinKitView mLoadingIndicator;

    @BindView(R.id.fab_register)
    FloatingActionButton mRegisterFAB;

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
        View view = inflater.inflate(R.layout.fragment_funiture_list, container, false);
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

        // Fab Button
        mRegisterFAB.setOnClickListener(view -> Snackbar.make(view, "Register Furniture", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
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
}
