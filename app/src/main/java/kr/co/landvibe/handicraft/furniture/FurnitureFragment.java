package kr.co.landvibe.handicraft.furniture;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ybq.android.spinkit.SpinKitView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.furniture.adapter.FurnitureAdapter;
import kr.co.landvibe.handicraft.furniture.presenter.FurniturePresenter;
import kr.co.landvibe.handicraft.furniture.presenter.FurniturePresenterImpl;

public class FurnitureFragment extends Fragment implements FurniturePresenter.View{

    private final static String TAG = "FurnitureFragment";

    @BindView(R.id.rv_furniture_list)
    RecyclerView mFurnitureListView;

    @BindView(R.id.pb_loading_indicator)
    SpinKitView mLoadingIndicator;

    private FurnitureAdapter mFurnitureAdapter;

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    private FurniturePresenterImpl mFurniturePresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_funiture, container, false);
        ButterKnife.bind(this, view);
        Log.d(TAG, "onCreateView()");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated()");

        init();
    }

    private void init(){

        mFurnitureAdapter = new FurnitureAdapter(getActivity());
        mFurnitureListView.setAdapter(mFurnitureAdapter);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mFurnitureListView.setLayoutManager(mStaggeredGridLayoutManager);
        mFurnitureListView.setHasFixedSize(true);

        mFurniturePresenter = new FurniturePresenterImpl();
        mFurniturePresenter.attachView(this);
        mFurniturePresenter.setFurnitureAdapterModel(mFurnitureAdapter);
        mFurniturePresenter.setFurnitureAdapterView(mFurnitureAdapter);

        mFurniturePresenter.loadFurnitureList();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFurniturePresenter.detachView();
        mFurniturePresenter=null;
    }


    /**
     * FurniturePresenter.View
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
