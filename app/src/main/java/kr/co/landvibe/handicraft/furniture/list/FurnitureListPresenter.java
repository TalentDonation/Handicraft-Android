package kr.co.landvibe.handicraft.furniture.list;


import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import kr.co.landvibe.handicraft.data.domain.Furniture;
import kr.co.landvibe.handicraft.data.source.furniture.remote.FurnitureRemoteDataSource;
import kr.co.landvibe.handicraft.data.support.Pagination;
import kr.co.landvibe.handicraft.furniture.list.adapter.contract.FurnitureListAdapterContract;
import kr.co.landvibe.handicraft.listener.OnItemClickListener;
import kr.co.landvibe.handicraft.utils.LogUtils;
import retrofit2.HttpException;

public class FurnitureListPresenter implements FurnitureListContract.Presenter, OnItemClickListener {

    private FurnitureListContract.View view;

    private FurnitureListAdapterContract.View mAdapterView;
    private FurnitureListAdapterContract.Model mAdapterModel;

    private FurnitureRemoteDataSource mFurnitureDataSource;

    private CompositeDisposable disposables;

    @Override
    public void attachView(FurnitureListContract.View view) {
        this.view = view;
        mFurnitureDataSource = FurnitureRemoteDataSource.getInstance();
        disposables = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        this.view = null;

        mAdapterModel = null;
        mAdapterView = null;

        mFurnitureDataSource.destroyInstance();
        mFurnitureDataSource = null;
        disposables.dispose();
    }

    @Override
    public void setFurnitureListAdapterModel(FurnitureListAdapterContract.Model model) {
        mAdapterModel = model;
    }

    @Override
    public void setFurnitureListAdapterView(FurnitureListAdapterContract.View view) {
        mAdapterView = view;
        mAdapterView.setOnItemClickListener(this);
    }

    @Override
    public void loadFurnitureList() {

//        List<Furniture> list = new ArrayList<>();
//        list.add(new Furniture(1, "회색의자!", "팝니다", "a+", "1년만 쓴건데 상태좋아요"
//                , null, "의자", "일룸", 3, 100000, 15, 15, 15, "서울", 0.0, 0.0, null, R.drawable.f1));
//        list.add(new Furniture(2, "회색의자!", "팝니다", "a+", "1년만 쓴건데 상태좋아요"
//                , null, "의자", "일룸", 3, 100000, 15, 15, 15, "서울", 0.0, 0.0, null, R.drawable.f3));
//        list.add(new Furniture(3, "회색의자!", "팝니다", "a+", "1년만 쓴건데 상태좋아요"
//                , null, "의자", "일룸", 3, 100000, 15, 15, 15, "서울", 0.0, 0.0, null, R.drawable.f5));
//        list.add(new Furniture(4, "회색의자!", "팝니다", "a+", "1년만 쓴건데 상태좋아요"
//                , null, "의자", "일룸", 3, 100000, 15, 15, 15, "서울", 0.0, 0.0, null, R.drawable.f7));
//        list.add(new Furniture(5, "회색의자!", "팝니다", "a+", "1년만 쓴건데 상태좋아요"
//                , null, "의자", "일룸", 3, 100000, 15, 15, 15, "서울", 0.0, 0.0, null, R.drawable.f8));
//        list.add(new Furniture(6, "회색의자!", "팝니다", "a+", "1년만 쓴건데 상태좋아요"
//                , null, "의자", "일룸", 3, 100000, 15, 15, 15, "서울", 0.0, 0.0, null, R.drawable.f9));

        disposables.add(mFurnitureDataSource.getFurnitureList(0,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Pagination<Furniture>>() {
                    @Override
                    public void onSuccess(@NonNull Pagination<Furniture> furniturePagination) {
                        List<Furniture> furnitures = furniturePagination.getContents();
                        mAdapterModel.setListData(furnitures);
                        mAdapterView.notifyAdapter();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if(e instanceof HttpException){
                            LogUtils.i(e.getMessage());
                            int code = ((HttpException) e).code();
                            switch (code){
                                case 400:
                                    break;
                                case 401:
                                    break;
                                case 403:
                                    break;
                                case 500:
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            LogUtils.e(e.getMessage());
                        }
                    }
                })
        );
    }

    @Override
    public void onItemClick(Object object) {
        Furniture furniture = (Furniture) object;
        LogUtils.d("clicked : " + furniture.getId());

        // move to furniture detail page
        view.moveToFurnitureDetailActivity(furniture.getId());
    }
}
