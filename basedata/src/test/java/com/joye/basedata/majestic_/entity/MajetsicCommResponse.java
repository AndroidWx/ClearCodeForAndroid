package com.joye.basedata.majestic_.entity;

/**
 * Created by joye on 2017/4/6.
 */

public class MajetsicCommResponse<T> {

    /**
     * Code : OK
     * ErrorMessage :
     * FullError :
     * IndexBuildDate : 2017-03-12 03:16:03
     * IndexType : 0
     * ServerBuild : 2017-03-16 14:29:46
     * ServerName : SHADOJAGUAR
     * ServerVersion : 1.0.6284.26093
     * UniqueIndexID : 20170312031603-HISTORICAL
     * DataTables : {"AnchorText":{"Headers":{"CanReturnURLs":1,"Count":10,"FilterAnchorText":"","FilterAnchorTextMode":0,"FilterRefDomain":"","From":0,"Item":"txwxhl.com","MaxTopics":10,"Mode":0,"OrigItem":"txwxhl.com","TextMode":0,"TopicsCount":3,"TotalBackLinks":116552,"TotalRefDomains":31910,"TotalResults":1000},"Data":[{"AnchorText":"淘宝人工客服电话","RefDomains":115,"TotalLinks":1827,"DeletedLinks":928,"NoFollowLinks":0,"EstimatedLinkCitationFlow":0,"EstimatedLinkTrustFlow":0,"TopicalTrustFlow_Topic_0":"","TopicalTrustFlow_Value_0":"","TopicalTrustFlow_Topic_1":"","TopicalTrustFlow_Value_1":"","TopicalTrustFlow_Topic_2":"","TopicalTrustFlow_Value_2":""},{"AnchorText":"淘宝客服电话转人工","RefDomains":113,"TotalLinks":1570,"DeletedLinks":720,"NoFollowLinks":0,"EstimatedLinkCitationFlow":0,"EstimatedLinkTrustFlow":0,"TopicalTrustFlow_Topic_0":"","TopicalTrustFlow_Value_0":"","TopicalTrustFlow_Topic_1":"","TopicalTrustFlow_Value_1":"","TopicalTrustFlow_Topic_2":"","TopicalTrustFlow_Value_2":""},{"AnchorText":"天猫投诉电话人工","RefDomains":113,"TotalLinks":1464,"DeletedLinks":677,"NoFollowLinks":0,"EstimatedLinkCitationFlow":0,"EstimatedLinkTrustFlow":0,"TopicalTrustFlow_Topic_0":"","TopicalTrustFlow_Value_0":"","TopicalTrustFlow_Topic_1":"","TopicalTrustFlow_Value_1":"","TopicalTrustFlow_Topic_2":"","TopicalTrustFlow_Value_2":""},{"AnchorText":"天猫人工客服电话","RefDomains":112,"TotalLinks":1813,"DeletedLinks":867,"NoFollowLinks":0,"EstimatedLinkCitationFlow":0,"EstimatedLinkTrustFlow":0,"TopicalTrustFlow_Topic_0":"","TopicalTrustFlow_Value_0":"","TopicalTrustFlow_Topic_1":"","TopicalTrustFlow_Value_1":"","TopicalTrustFlow_Topic_2":"","TopicalTrustFlow_Value_2":""},{"AnchorText":"淘宝人工客服","RefDomains":111,"TotalLinks":1490,"DeletedLinks":704,"NoFollowLinks":0,"EstimatedLinkCitationFlow":0,"EstimatedLinkTrustFlow":0,"TopicalTrustFlow_Topic_0":"","TopicalTrustFlow_Value_0":"","TopicalTrustFlow_Topic_1":"","TopicalTrustFlow_Value_1":"","TopicalTrustFlow_Topic_2":"","TopicalTrustFlow_Value_2":""},{"AnchorText":"淘宝人工服务","RefDomains":109,"TotalLinks":1202,"DeletedLinks":534,"NoFollowLinks":0,"EstimatedLinkCitationFlow":0,"EstimatedLinkTrustFlow":0,"TopicalTrustFlow_Topic_0":"","TopicalTrustFlow_Value_0":"","TopicalTrustFlow_Topic_1":"","TopicalTrustFlow_Value_1":"","TopicalTrustFlow_Topic_2":"","TopicalTrustFlow_Value_2":""},{"AnchorText":"淘宝人工服务怎么打","RefDomains":109,"TotalLinks":1102,"DeletedLinks":509,"NoFollowLinks":0,"EstimatedLinkCitationFlow":0,"EstimatedLinkTrustFlow":0,"TopicalTrustFlow_Topic_0":"","TopicalTrustFlow_Value_0":"","TopicalTrustFlow_Topic_1":"","TopicalTrustFlow_Value_1":"","TopicalTrustFlow_Topic_2":"","TopicalTrustFlow_Value_2":""},{"AnchorText":"天猫人工投诉","RefDomains":109,"TotalLinks":964,"DeletedLinks":462,"NoFollowLinks":0,"EstimatedLinkCitationFlow":0,"EstimatedLinkTrustFlow":0,"TopicalTrustFlow_Topic_0":"","TopicalTrustFlow_Value_0":"","TopicalTrustFlow_Topic_1":"","TopicalTrustFlow_Value_1":"","TopicalTrustFlow_Topic_2":"","TopicalTrustFlow_Value_2":""},{"AnchorText":"淘宝人工电话","RefDomains":108,"TotalLinks":1452,"DeletedLinks":657,"NoFollowLinks":0,"EstimatedLinkCitationFlow":0,"EstimatedLinkTrustFlow":0,"TopicalTrustFlow_Topic_0":"","TopicalTrustFlow_Value_0":"","TopicalTrustFlow_Topic_1":"","TopicalTrustFlow_Value_1":"","TopicalTrustFlow_Topic_2":"","TopicalTrustFlow_Value_2":""},{"AnchorText":"天猫投诉电话","RefDomains":106,"TotalLinks":1168,"DeletedLinks":532,"NoFollowLinks":0,"EstimatedLinkCitationFlow":0,"EstimatedLinkTrustFlow":0,"TopicalTrustFlow_Topic_0":"","TopicalTrustFlow_Value_0":"","TopicalTrustFlow_Topic_1":"","TopicalTrustFlow_Value_1":"","TopicalTrustFlow_Topic_2":"","TopicalTrustFlow_Value_2":""}]}}
     */

    private String Code;
    private String ErrorMessage;
    private String FullError;
    private String IndexBuildDate;
    private int IndexType;
    private String ServerBuild;
    private String ServerName;
    private String ServerVersion;
    private String UniqueIndexID;
    private T DataTables;
    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    public String getFullError() {
        return FullError;
    }

    public void setFullError(String FullError) {
        this.FullError = FullError;
    }

    public String getIndexBuildDate() {
        return IndexBuildDate;
    }

    public void setIndexBuildDate(String IndexBuildDate) {
        this.IndexBuildDate = IndexBuildDate;
    }

    public int getIndexType() {
        return IndexType;
    }

    public void setIndexType(int IndexType) {
        this.IndexType = IndexType;
    }

    public String getServerBuild() {
        return ServerBuild;
    }

    public void setServerBuild(String ServerBuild) {
        this.ServerBuild = ServerBuild;
    }

    public String getServerName() {
        return ServerName;
    }

    public void setServerName(String ServerName) {
        this.ServerName = ServerName;
    }

    public String getServerVersion() {
        return ServerVersion;
    }

    public void setServerVersion(String ServerVersion) {
        this.ServerVersion = ServerVersion;
    }

    public String getUniqueIndexID() {
        return UniqueIndexID;
    }

    public void setUniqueIndexID(String UniqueIndexID) {
        this.UniqueIndexID = UniqueIndexID;
    }

    public T getDataTables() {
        return DataTables;
    }

    public void setDataTables(T dataTables) {
        DataTables = dataTables;
    }
}
