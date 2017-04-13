package com.joye.basedata.domainhandle;

import android.content.Context;

import com.joye.basedata.net.BaseRestApiImpl;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by joye on 2017/4/5.
 */

public class ArchiveNetApiImpl extends BaseRestApiImpl<ArchiveNetApi> {
     /**
     * Constructor of the class
     *
     * @param context {@link Context}.
     */
    public ArchiveNetApiImpl(Context context) {
        super(context);
    }

    public ArchiveNetApiImpl(){

    }

    @Override
    protected Class<ArchiveNetApi> getApiClass() {
        return ArchiveNetApi.class;
    }

    public Observable<ArchiveResponse> getArchive(  String url,  String timestamp){
        return create().getArchive(url,timestamp);
    }


    @Override
    protected String BaseUrl() {
        return "http://archive.org/wayback/";
    }
}
