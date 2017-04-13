package com.joye.basedata.majestic_.entity;

import java.util.List;

/**
 * Created by joye on 2017/4/6.
 */

public class AnchorTextEntity {

    public static final String[] TITLES = new String[]{"老域名","锚文本"};

    /**
     * AnchorText : {"Headers":{"CanReturnURLs":0,"Count":10,"FilterAnchorText":"majestic","FilterAnchorTextMode":0,"FilterRefDomain":"","From":0,"Item":"majestic.com","Mode":0,"OrigItem":"majestic.com","TextMode":0,"TotalBackLinks":2607767,"TotalRefDomains":16654,"TotalResults":419},"Data":[{"AnchorText":"Majestic","RefDomains":3063,"TotalLinks":126524,"DeletedLinks":34476,"NoFollowLinks":4804,"EstimatedLinkCitationFlow":"74","EstimatedLinkTrustFlow":"70"},{"AnchorText":"majestic","RefDomains":1009,"TotalLinks":229572,"DeletedLinks":3251,"NoFollowLinks":219720,"EstimatedLinkCitationFlow":"71","EstimatedLinkTrustFlow":"62"},{"AnchorText":"www.majestic.com","RefDomains":571,"TotalLinks":2660,"DeletedLinks":1583,"NoFollowLinks":580,"EstimatedLinkCitationFlow":"44","EstimatedLinkTrustFlow":"28"},{"AnchorText":"majestic.com","RefDomains":514,"TotalLinks":5237,"DeletedLinks":942,"NoFollowLinks":284,"EstimatedLinkCitationFlow":"51","EstimatedLinkTrustFlow":"39"},{"AnchorText":"http://www.majestic.com/","RefDomains":464,"TotalLinks":4971,"DeletedLinks":1172,"NoFollowLinks":1192,"EstimatedLinkCitationFlow":"52","EstimatedLinkTrustFlow":"55"},{"AnchorText":"http://www.majestic.com","RefDomains":373,"TotalLinks":2311,"DeletedLinks":815,"NoFollowLinks":951,"EstimatedLinkCitationFlow":"54","EstimatedLinkTrustFlow":"39"},{"AnchorText":"majestic","RefDomains":367,"TotalLinks":6334,"DeletedLinks":1931,"NoFollowLinks":2812,"EstimatedLinkCitationFlow":"58","EstimatedLinkTrustFlow":"47"},{"AnchorText":"majestic-seo","RefDomains":268,"TotalLinks":17606,"DeletedLinks":847,"NoFollowLinks":234,"EstimatedLinkCitationFlow":"64","EstimatedLinkTrustFlow":"40"},{"AnchorText":"Majestic links","RefDomains":203,"TotalLinks":3503,"DeletedLinks":568,"NoFollowLinks":0,"EstimatedLinkCitationFlow":"0","EstimatedLinkTrustFlow":"0"},{"AnchorText":"https://www.majestic.com/","RefDomains":170,"TotalLinks":1158,"DeletedLinks":501,"NoFollowLinks":150,"EstimatedLinkCitationFlow":"38","EstimatedLinkTrustFlow":"23"}]}
     */

    private AnchorTextBean AnchorText;

    private String oldDomainStr;

    public String getOldDomainStr() {
        return oldDomainStr;
    }

    public void setOldDomainStr(String oldDomainStr) {
        this.oldDomainStr = oldDomainStr;
    }

    public AnchorTextBean getAnchorText() {
        return AnchorText;
    }

    public void setAnchorText(AnchorTextBean AnchorText) {
        this.AnchorText = AnchorText;
    }

    public static class AnchorTextBean {
        /**
         * Headers : {"CanReturnURLs":0,"Count":10,"FilterAnchorText":"majestic","FilterAnchorTextMode":0,"FilterRefDomain":"","From":0,"Item":"majestic.com","Mode":0,"OrigItem":"majestic.com","TextMode":0,"TotalBackLinks":2607767,"TotalRefDomains":16654,"TotalResults":419}
         * Data : [{"AnchorText":"Majestic","RefDomains":3063,"TotalLinks":126524,"DeletedLinks":34476,"NoFollowLinks":4804,"EstimatedLinkCitationFlow":"74","EstimatedLinkTrustFlow":"70"},{"AnchorText":"majestic","RefDomains":1009,"TotalLinks":229572,"DeletedLinks":3251,"NoFollowLinks":219720,"EstimatedLinkCitationFlow":"71","EstimatedLinkTrustFlow":"62"},{"AnchorText":"www.majestic.com","RefDomains":571,"TotalLinks":2660,"DeletedLinks":1583,"NoFollowLinks":580,"EstimatedLinkCitationFlow":"44","EstimatedLinkTrustFlow":"28"},{"AnchorText":"majestic.com","RefDomains":514,"TotalLinks":5237,"DeletedLinks":942,"NoFollowLinks":284,"EstimatedLinkCitationFlow":"51","EstimatedLinkTrustFlow":"39"},{"AnchorText":"http://www.majestic.com/","RefDomains":464,"TotalLinks":4971,"DeletedLinks":1172,"NoFollowLinks":1192,"EstimatedLinkCitationFlow":"52","EstimatedLinkTrustFlow":"55"},{"AnchorText":"http://www.majestic.com","RefDomains":373,"TotalLinks":2311,"DeletedLinks":815,"NoFollowLinks":951,"EstimatedLinkCitationFlow":"54","EstimatedLinkTrustFlow":"39"},{"AnchorText":"majestic","RefDomains":367,"TotalLinks":6334,"DeletedLinks":1931,"NoFollowLinks":2812,"EstimatedLinkCitationFlow":"58","EstimatedLinkTrustFlow":"47"},{"AnchorText":"majestic-seo","RefDomains":268,"TotalLinks":17606,"DeletedLinks":847,"NoFollowLinks":234,"EstimatedLinkCitationFlow":"64","EstimatedLinkTrustFlow":"40"},{"AnchorText":"Majestic links","RefDomains":203,"TotalLinks":3503,"DeletedLinks":568,"NoFollowLinks":0,"EstimatedLinkCitationFlow":"0","EstimatedLinkTrustFlow":"0"},{"AnchorText":"https://www.majestic.com/","RefDomains":170,"TotalLinks":1158,"DeletedLinks":501,"NoFollowLinks":150,"EstimatedLinkCitationFlow":"38","EstimatedLinkTrustFlow":"23"}]
         */

        private HeadersBean Headers;
        private List<DataBean> Data;

        public HeadersBean getHeaders() {
            return Headers;
        }

        public void setHeaders(HeadersBean Headers) {
            this.Headers = Headers;
        }

        public List<DataBean> getData() {
            return Data;
        }

        public void setData(List<DataBean> Data) {
            this.Data = Data;
        }

        public static class HeadersBean {
            /**
             * CanReturnURLs : 0
             * Count : 10
             * FilterAnchorText : majestic
             * FilterAnchorTextMode : 0
             * FilterRefDomain :
             * From : 0
             * Item : majestic.com
             * Mode : 0
             * OrigItem : majestic.com
             * TextMode : 0
             * TotalBackLinks : 2607767
             * TotalRefDomains : 16654
             * TotalResults : 419
             */

            private int CanReturnURLs;
            private int Count;
            private String FilterAnchorText;
            private int FilterAnchorTextMode;
            private String FilterRefDomain;
            private int From;
            private String Item;
            private int Mode;
            private String OrigItem;
            private int TextMode;
            private int TotalBackLinks;
            private int TotalRefDomains;
            private int TotalResults;

            public int getCanReturnURLs() {
                return CanReturnURLs;
            }

            public void setCanReturnURLs(int CanReturnURLs) {
                this.CanReturnURLs = CanReturnURLs;
            }

            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public String getFilterAnchorText() {
                return FilterAnchorText;
            }

            public void setFilterAnchorText(String FilterAnchorText) {
                this.FilterAnchorText = FilterAnchorText;
            }

            public int getFilterAnchorTextMode() {
                return FilterAnchorTextMode;
            }

            public void setFilterAnchorTextMode(int FilterAnchorTextMode) {
                this.FilterAnchorTextMode = FilterAnchorTextMode;
            }

            public String getFilterRefDomain() {
                return FilterRefDomain;
            }

            public void setFilterRefDomain(String FilterRefDomain) {
                this.FilterRefDomain = FilterRefDomain;
            }

            public int getFrom() {
                return From;
            }

            public void setFrom(int From) {
                this.From = From;
            }

            public String getItem() {
                return Item;
            }

            public void setItem(String Item) {
                this.Item = Item;
            }

            public int getMode() {
                return Mode;
            }

            public void setMode(int Mode) {
                this.Mode = Mode;
            }

            public String getOrigItem() {
                return OrigItem;
            }

            public void setOrigItem(String OrigItem) {
                this.OrigItem = OrigItem;
            }

            public int getTextMode() {
                return TextMode;
            }

            public void setTextMode(int TextMode) {
                this.TextMode = TextMode;
            }

            public int getTotalBackLinks() {
                return TotalBackLinks;
            }

            public void setTotalBackLinks(int TotalBackLinks) {
                this.TotalBackLinks = TotalBackLinks;
            }

            public int getTotalRefDomains() {
                return TotalRefDomains;
            }

            public void setTotalRefDomains(int TotalRefDomains) {
                this.TotalRefDomains = TotalRefDomains;
            }

            public int getTotalResults() {
                return TotalResults;
            }

            public void setTotalResults(int TotalResults) {
                this.TotalResults = TotalResults;
            }
        }

        public static class DataBean {
            /**
             * AnchorText : Majestic
             * RefDomains : 3063
             * TotalLinks : 126524
             * DeletedLinks : 34476
             * NoFollowLinks : 4804
             * EstimatedLinkCitationFlow : 74
             * EstimatedLinkTrustFlow : 70
             */

            private String AnchorText;
            private int RefDomains;
            private int TotalLinks;
            private int DeletedLinks;
            private int NoFollowLinks;
            private String EstimatedLinkCitationFlow;
            private String EstimatedLinkTrustFlow;

            /**
             * 锚文本
             * @return
             */
            public String getAnchorText() {
                return AnchorText;
            }

            public void setAnchorText(String AnchorText) {
                this.AnchorText = AnchorText;
            }

            /**
             *  具有指定锚文本的引用域数
             * @return
             */
            public int getRefDomains() {
                return RefDomains;
            }

            public void setRefDomains(int RefDomains) {
                this.RefDomains = RefDomains;
            }

            /**
             * 具有指定锚文本的反向链接总数（外部）
             * @return
             */
            public int getTotalLinks() {
                return TotalLinks;
            }

            public void setTotalLinks(int TotalLinks) {
                this.TotalLinks = TotalLinks;
            }

            /**
             *具有指定锚文本的反向链接总数（外部）
             * @return
             */
            public int getDeletedLinks() {
                return DeletedLinks;
            }

            public void setDeletedLinks(int DeletedLinks) {
                this.DeletedLinks = DeletedLinks;
            }

            /**
             * nofollow的链接数
             * @return
             */
            public int getNoFollowLinks() {
                return NoFollowLinks;
            }

            public void setNoFollowLinks(int NoFollowLinks) {
                this.NoFollowLinks = NoFollowLinks;
            }

            /**
             * 估计引用链接的引用流（nofollow链接被忽略）
             * @return
             */
            public String getEstimatedLinkCitationFlow() {
                return EstimatedLinkCitationFlow;
            }

            public void setEstimatedLinkCitationFlow(String EstimatedLinkCitationFlow) {
                this.EstimatedLinkCitationFlow = EstimatedLinkCitationFlow;
            }

            /**
             * - 估计通过它的引用链接的信任流（忽略nofollow链接）
             * @return
             */
            public String getEstimatedLinkTrustFlow() {
                return EstimatedLinkTrustFlow;
            }

            public void setEstimatedLinkTrustFlow(String EstimatedLinkTrustFlow) {
                this.EstimatedLinkTrustFlow = EstimatedLinkTrustFlow;
            }
        }
    }
}
