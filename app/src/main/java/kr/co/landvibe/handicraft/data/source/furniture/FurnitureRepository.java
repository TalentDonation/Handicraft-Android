package kr.co.landvibe.handicraft.data.source.furniture;


import android.support.annotation.NonNull;

import io.reactivex.Single;
import kr.co.landvibe.handicraft.GlobalApp;
import kr.co.landvibe.handicraft.data.domain.Furniture;
import kr.co.landvibe.handicraft.data.source.furniture.remote.FurnitureService;
import kr.co.landvibe.handicraft.data.support.Pagination;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class FurnitureRepository implements FurnitureDataSource{

    private static FurnitureRepository INSTANCE;

    private FurnitureService mFurnitureService;

    private FurnitureRepository() {
        OkHttpClient okHttpClient = GlobalApp.getOkHttpClientInstance();
        Retrofit retrofit = GlobalApp.getRetrofitInstance(okHttpClient);

        mFurnitureService = retrofit.create(FurnitureService.class);
    }

    public static FurnitureRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FurnitureRepository();
        }
        return INSTANCE;


    }

    public void destroyInstance() {
        INSTANCE = null;
        mFurnitureService = null;
    }

    @Override
    public Single<Furniture> createFurniture(@NonNull Furniture furniture) {
        return mFurnitureService.createFurniture(furniture);
    }

    @Override
    public Single<Furniture> getFurniture(long id) {
        return mFurnitureService.getFurniture(id);
    }

    @Override
    public Single<Furniture> updateFurniture(@NonNull Furniture furniture) {
        return mFurnitureService.updateFurniture(furniture.getId(), furniture);
    }

    @Override
    public Single<Pagination<Furniture>> getFurnitureList(int page, int perPage) {
        return mFurnitureService.getFurnitureList(page, perPage);
    }

    @Override
    public void deleteFurniture(@NonNull Furniture furniture) {
        deleteFurniture(furniture.getId());
    }

    @Override
    public void deleteFurniture(@NonNull long id) {
        mFurnitureService.deleteFurniture(id);
    }
}
