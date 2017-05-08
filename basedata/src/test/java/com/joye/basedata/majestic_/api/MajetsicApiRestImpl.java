package com.joye.basedata.majestic_.api;

import com.joye.basedata.majestic_.entity.AnchorTextEntity;
import com.joye.basedata.majestic_.entity.MajetsicCommResponse;
import com.joye.basedata.net.BaseRestApiImpl;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by joye on 2017/4/6.
 */

public class MajetsicApiRestImpl extends BaseRestApiImpl<MajetsicApi> {

    @Override
    protected Class<MajetsicApi> getApiClass() {
        return MajetsicApi.class;
    }

    /**
     * 此函数返回给定域，子域或URL的Anchor文本，并允许您通过关键字过滤结果
     * <br>
     *     第二个参数 ：Optional - defaults to historic Either:
     *                   "fresh" - to query against fresh index,
     *                    or
     *                   "historic" - to query against historic index.
     * @param item  URL/Subdomain/Domain to query
     * @param TextMode
     * 0（默认） - 返回锚文本（强制为小写），因为它发现所有的点标记等
     * 1 - 通过删除穿插符号和其他分隔符来清除锚文本
     * @param Mode
     * 确定将返回的数据类型：
     * 0（默认 - 返回聚合锚文本统计信息
     * 1 - 将返回引用域以精确匹配提供的锚文本
     * 2 - 返回给定锚文本或锚文本和引用域的反向链接，仅在查询锚文本或引用域时变量CanReturnURLs设置为1时才有效。
     * @param FilterAnchorText 应用于过滤锚文本FilterAnchorTextMode设置为适当的模式。
     * @param FilterAnchorTextMode
     * 0（默认） - 在锚文本上没有过滤器
     * 1 - 在FilterAnchorText参数中精确匹配指定的锚文本
     * 2 - 匹配包含指定的FilterAnchorText的所有锚文本
     * @param FilterRefDomain 仅在需要针对特定参考域返回反向链接的情况下使用。
     * @param Count
     * 要返回的结果数（锚文本，引用域或反向链接）。
     * 默认值：10，最大值：1000
     * @param UsePrefixScan
     * 可选：设置为1将激活前缀模式。=
     * 这就像在majestic.com 网站上的Majestic Site Explorer中的“Path（URL *）”功能。
     * 此命令将检查是否可以实时查询给定项目，如果不是这样，那么将返回RealTimePrefixQueryNotPossible错误代码。
     * 另请参见获取前缀查询估计
     * @return
     */
    public Observable<MajetsicCommResponse<AnchorTextEntity>> GetAnchorText(
                                                                     String item,
                                                                     String TextMode,
                                                                     String Mode,
                                                                     String FilterAnchorText,
                                                                            String FilterAnchorTextMode,
                                                                     String FilterRefDomain,
                                                                     String Count,
                                                                     String UsePrefixScan){
//        return create().GetAnchorText("GetAnchorText", "historic", "域名","1", "0", "", "", "", "", "");
        return create().GetAnchorText("GetAnchorText", "historic", item, TextMode, Mode, FilterAnchorText, FilterAnchorTextMode, FilterRefDomain, Count, UsePrefixScan);

    }


    @Override
    protected String BaseUrl() {
        return "http://api.majestic.com/api/";
    }

    @Override
    protected List<Interceptor> getListInterceptors() {
        List<Interceptor>interceptors=super.getListInterceptors();
        interceptors.add(apiKeyInterceptor);
        return interceptors;
    }

    private final Interceptor apiKeyInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl.Builder builder = chain.request().url()
                    .newBuilder()
                    .setEncodedQueryParameter("app_api_key", "C3B8D0A0D76197EC466A1DA463DBDB96");
            request = request.newBuilder().url(builder.build()).build();
            Response response = chain.proceed(request);
            return response;
        }
    };


}
