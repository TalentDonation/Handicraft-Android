package kr.co.landvibe.handicraft.data.source.furniture;


import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Single;
import kr.co.landvibe.handicraft.data.domain.Furniture;

public interface FurnitureDataSource {

    Single<Furniture> createFurniture(@NonNull Furniture furniture);

    Single<Furniture> getFurniture(long id);

    Single<Furniture> updateFurniture(@NonNull Furniture furniture);

    Single<List<Furniture>> getFurnitureList(int page, int perPage);

    void deleteFurniture(@NonNull Furniture furniture);

    void deleteFurniture(@NonNull long id);
}
