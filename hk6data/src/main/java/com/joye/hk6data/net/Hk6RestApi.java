package com.joye.hk6data.net;

import com.joye.hk6data.entity.Hk6Entity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/20.
 * 304622254@qq.com
 * Remeark:六合彩请求api
 */

public interface Hk6RestApi extends BaseApi {
    /**
     * @param token  令牌
     * @param code   代码
     * @param date   时间
     * @param format 转换格式
     * @return 六合彩列表数据
     */
    @GET("newly.do")
    Observable<List<Hk6Entity>> getHk6ListData(@Query(TOKEN) String token,
                                               @Query(CODE) String code,
                                               @Query(DATE) String date,
                                               @FORMAT_THEME
                                               @Query(FORMAT) String format);
}
