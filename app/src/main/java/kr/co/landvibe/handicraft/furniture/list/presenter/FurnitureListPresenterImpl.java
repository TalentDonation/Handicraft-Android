package kr.co.landvibe.handicraft.furniture.list.presenter;


import java.util.ArrayList;
import java.util.List;

import kr.co.landvibe.handicraft.R;
import kr.co.landvibe.handicraft.data.domain.Furniture;
import kr.co.landvibe.handicraft.furniture.list.adapter.contract.FurnitureListAdapterContract;
import kr.co.landvibe.handicraft.listener.OnItemClickListener;
import kr.co.landvibe.handicraft.utils.LogUtils;

public class FurnitureListPresenterImpl implements FurnitureListPresenter.Presenter, OnItemClickListener {

    private FurnitureListPresenter.View view;

    private FurnitureListAdapterContract.View mAdapterView;
    private FurnitureListAdapterContract.Model mAdapterModel;

    @Override
    public void attachView(FurnitureListPresenter.View view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        this.view=null;

        mAdapterModel=null;
        mAdapterView=null;
    }

    @Override
    public void setFurnitureListAdapterModel(FurnitureListAdapterContract.Model model) {
        mAdapterModel=model;
    }

    @Override
    public void setFurnitureListAdapterView(FurnitureListAdapterContract.View view) {
        mAdapterView=view;
        mAdapterView.setOnItemClickListener(this);
    }

    @Override
    public void loadFurnitureList() {

        List<Furniture> list = new ArrayList<>();
        list.add(new Furniture("a","회색의자!","팝니다","a+","1년만 쓴건데 상태좋아요"
                ,null,"의자","일룸",3, 100000,15,15,15,"서울",0.0,0.0,null, R.drawable.f1));
        list.add(new Furniture("a","회색의자!","팝니다","a+","1년만 쓴건데 상태좋아요"
                ,null,"의자","일룸",3, 100000,15,15,15,"서울",0.0,0.0,null, R.drawable.f3));
        list.add(new Furniture("a","회색의자!","팝니다","a+","1년만 쓴건데 상태좋아요"
                ,null,"의자","일룸",3, 100000,15,15,15,"서울",0.0,0.0,null, R.drawable.f5));
        list.add(new Furniture("a","회색의자!","팝니다","a+","1년만 쓴건데 상태좋아요"
                ,null,"의자","일룸",3, 100000,15,15,15,"서울",0.0,0.0,null, R.drawable.f7));
        list.add(new Furniture("a","회색의자!","팝니다","a+","1년만 쓴건데 상태좋아요"
                ,null,"의자","일룸",3, 100000,15,15,15,"서울",0.0,0.0,null, R.drawable.f8));
        list.add(new Furniture("a","회색의자!","팝니다","a+","1년만 쓴건데 상태좋아요"
                ,null,"의자","일룸",3, 100000,15,15,15,"서울",0.0,0.0,null, R.drawable.f9));

        mAdapterModel.setListData(list);
        mAdapterView.notifyAdapter();

    }

    @Override
    public void onItemClick(Object object) {
        Furniture furniture = (Furniture) object;
        LogUtils.d("clicked : " + furniture.getId());

        // move to furniture detail page
        view.moveToFurnitureDetailActivity();
    }
}
