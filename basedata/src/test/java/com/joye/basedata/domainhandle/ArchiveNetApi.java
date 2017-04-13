package com.joye.basedata.domainhandle;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by joye on 2017/4/5.
 */

public interface ArchiveNetApi {
    @GET("available")
    Observable<ArchiveResponse> getArchive(@Query("url") String url,@Query("timestamp")String timestamp);

}
