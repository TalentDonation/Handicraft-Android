package kr.co.landvibe.handicraft.data.source.furniture.remote;


import android.support.annotation.NonNull;

import io.reactivex.Single;
import kr.co.landvibe.handicraft.GlobalApp;
import kr.co.landvibe.handicraft.data.domain.Furniture;
import kr.co.landvibe.handicraft.data.source.furniture.FurnitureDataSource;
import kr.co.landvibe.handicraft.data.support.Pagination;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class FurnitureRemoteDataSource implements FurnitureDataSource {

    private static FurnitureRemoteDataSource INSTANCE;

    private FurnitureService mFurnitureService;

    private FurnitureRemoteDataSource() {
        OkHttpClient okHttpClient = GlobalApp.getOkHttpClientInstance();
        Retrofit retrofit = GlobalApp.getRetrofitInstance(okHttpClient);

        mFurnitureService = retrofit.create(FurnitureService.class);
    }

    public static FurnitureRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FurnitureRemoteDataSource();
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
