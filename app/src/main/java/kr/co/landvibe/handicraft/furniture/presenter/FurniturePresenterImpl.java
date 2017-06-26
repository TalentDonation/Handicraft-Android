package kr.co.landvibe.handicraft.furniture.presenter;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.domain.Furniture;
import kr.co.landvibe.handicraft.furniture.adapter.contract.FurnitureAdapterContract;
import kr.co.landvibe.handicraft.listener.OnItemClickListener;

public class FurniturePresenterImpl implements FurniturePresenter.Presenter, OnItemClickListener {

    private final static String TAG = "FurniturePresenterImpl";

    private FurniturePresenter.View view;

    private FurnitureAdapterContract.View mAdapterView;
    private FurnitureAdapterContract.Model mAdapterModel;

    @Override
    public void attachView(FurniturePresenter.View view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        this.view=null;
    }

    @Override
    public void setFurnitureAdapterModel(FurnitureAdapterContract.Model model) {
        mAdapterModel=model;
    }

    @Override
    public void setFurnitureAdapterView(FurnitureAdapterContract.View view) {
        mAdapterView=view;
        mAdapterView.setOnItemClickListener(this);
    }

    @Override
    public void loadFurnitureList() {

        List<Furniture> list = new ArrayList<>();
        list.add(new Furniture("a","회색의자!","팝니다","1년만 쓴건데 상태좋아요","", R.drawable.f1));
        list.add(new Furniture("c","청록색 쇼파!","팝니다","1년만 쓴건데 상태좋아요","", R.drawable.f3));
        list.add(new Furniture("e","벤치!","가져가세요","1년만 쓴건데 상태좋아요","", R.drawable.f5));
        list.add(new Furniture("e","벤치!","가져가세요","1년만 쓴건데 상태좋아요","", R.drawable.f7));
        list.add(new Furniture("e","벤치!","가져가세요","1년만 쓴건데 상태좋아요","", R.drawable.f8));
        list.add(new Furniture("e","벤치!","가져가세요","1년만 쓴건데 상태좋아요","", R.drawable.f9));

        mAdapterModel.setListData(list);
        mAdapterView.notifyAdapter();

    }

    @Override
    public void onItemClick(Object object) {
        Furniture furniture = (Furniture) object;
        Log.d(TAG, "clicked : " + furniture.getId());
        // move to furniture detail page
    }
}
