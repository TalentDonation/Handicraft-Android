package kr.co.landvibe.handicraft.furniture.add;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import kr.co.landvibe.handicraft.data.domain.Furniture;
import kr.co.landvibe.handicraft.data.source.furniture.FurnitureRepository;
import kr.co.landvibe.handicraft.utils.LogUtils;
import retrofit2.HttpException;

public class FurnitureAddPresenter implements FurnitureAddContract.Presenter {

    private FurnitureAddContract.View view;

    private FurnitureRepository mFurnitureRepository;

    private CompositeDisposable disposables;

    @Override
    public void attachView(FurnitureAddContract.View view) {
        this.view = view;
        mFurnitureRepository = FurnitureRepository.getInstance();
        disposables = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        this.view = null;
        mFurnitureRepository.destroyInstance();
        mFurnitureRepository = null;
        disposables.dispose();
        disposables = null;
    }

    @Override
    public void registerFurniture(Furniture furniture) {
        Disposable furnitureDisposable = mFurnitureRepository.createFurniture(furniture)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Furniture>() {
                    @Override
                    public void onSuccess(@NonNull Furniture furniture) {
                        view.hideLoading();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (e instanceof HttpException) {
                            LogUtils.i(e.getMessage());
                            int code = ((HttpException) e).code();
                            switch (code) {
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
                });

        disposables.add(furnitureDisposable);

        // view change
        view.backToMainActivity();
    }
}
